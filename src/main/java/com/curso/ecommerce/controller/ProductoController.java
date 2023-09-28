package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ProductoService;
import com.curso.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private UploadFileService uploadFileService;

	@Autowired
	ProductoService productoService;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/show";
	}

	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}

	@PostMapping("/save")
	public String save(Producto producto, @RequestParam("img") MultipartFile fileMultipartFile) throws IOException {
		LOGGER.info("Guardando producto: {} " + producto);
		Usuario usuario = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(usuario);

		// imagen
		if (producto.getId() == null) {// cuando se crea un producto
			String nombreImage = uploadFileService.saveImage(fileMultipartFile);
			producto.setImagen(nombreImage);

		} else {

		}

		productoService.save(producto);
		return "redirect:/productos/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto = productoService.findById(id);
		producto = optionalProducto.get();

		LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("producto", producto);

		return "productos/edit";

	}

	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile fileMultipartFile) throws IOException {

		Producto p = new Producto();
		p = productoService.findById(producto.getId()).get();

		LOGGER.info("Actualizando producto: {} " + producto);
		if (fileMultipartFile.isEmpty()) {// cuando editamos un producto y no cambiamos la imagen
			p.setImagen(producto.getImagen());
		} else {// cuando se edita la imagen

			// eliminar cunadoo no se la imagen por defecto
			if (!p.getImagen().equals("default.jpg")) {
				uploadFileService.deleteImage(p.getImagen());
			}
			String nombreImage = uploadFileService.saveImage(fileMultipartFile);
			producto.setImagen(nombreImage);
		}

		producto.setUsuario(p.getUsuario());

		productoService.update(producto);
		return "redirect:/productos/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		LOGGER.info("Eliminando producto: {} " + id);

		Producto p = new Producto();
		p = productoService.findById(id).get();

		// eliminar cunadoo no se la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {
			uploadFileService.deleteImage(p.getImagen());
		}

		productoService.deleteById(id);
		return "redirect:/productos/";
	}

}