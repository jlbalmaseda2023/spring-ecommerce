package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> findById(Integer id) {
		return productoRepository.findById(id);
	}

	// Este metodo en JPA funciona de la siguiente manera, si le mandamos un objeto
	// de tipo producto, que ya existe en la base de datos, se actualizará
	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void deleteById(Integer id) {
		productoRepository.deleteById(id);
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

}
