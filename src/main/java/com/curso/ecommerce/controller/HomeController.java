package com.curso.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private Producto producto;

	@Autowired
	private ProductoService productoService;
	
	List<DetalleOrden> detalleOrden= new ArrayList<DetalleOrden>();

	DetalleOrden detalle = new DetalleOrden();
	
	Orden orden = new Orden();

	@GetMapping("")
	public String home(Model model) {

		model.addAttribute("productos", productoService.findAll());
		return "usuario/home";

	}

	@GetMapping("productohome/{id}")
	public String productoHome(Model model, @PathVariable Integer id) {
		LOGGER.info("Id producto enviado como parametro {}: " + id);
		Optional<Producto> productoOptoinal = productoService.findById(id);
		producto = productoOptoinal.get();
		model.addAttribute("producto", producto);
		return "usuario/productohome";
	}

	
	@PostMapping("/cart")
	public String addCart(Model model, @RequestParam("id") Integer id, @RequestParam("cantidad") Integer cantidad) {
		LOGGER.info("Id producto enviado al carrito como parametro {}: " + id);
		double sumaTotal = 0;
		
		Optional<Producto> productoOptional = productoService.findById(id);
		
		LOGGER.info("Id producto añadido al carrito {}: " + id);
		LOGGER.info("Cantidad añadida al carrito {}: " + cantidad);
		
		producto = productoOptional.get();
		model.addAttribute("producto", producto);
		return "usuario/carrito";
	}
	
	

	
	
	
}
