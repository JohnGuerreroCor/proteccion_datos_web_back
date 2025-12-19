package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Item;

public interface IItemDao {
	
	public List<Item> obtenerListadoItem();
	
	public List<Item> obtenerItemsPorSeccion(Integer seccionCodigo);
	
	public Item obtenerItem(Integer codigo);

}
