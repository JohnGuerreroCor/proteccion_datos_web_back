package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IItemDao;
import com.usco.edu.entities.Item;
import com.usco.edu.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao itemDao;

	@Override
	public List<Item> obtenerListadoItem() {

		return itemDao.obtenerListadoItem();

	}

	@Override
	public List<Item> obtenerItemsPorSeccion(Integer seccionCodigo) {

		return itemDao.obtenerItemsPorSeccion(seccionCodigo);

	}

	@Override
	public Item obtenerItem(Integer codigo) {

		return itemDao.obtenerItem(codigo);

	}

}
