package com.curso.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Producto;

@Service
public interface ProductoService {

	public Producto save(Producto producto);

	public Optional<Producto> findById(Integer id);

	public void update(Producto producto);

	public void deleteById(Integer id);

}
