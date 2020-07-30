package org.demo.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.demo.dao.EjemploDao;

@Stateless
public class BarBean implements Bar {

	private EjemploDao service;

	public EjemploDao getService() {
		return this.service;
	}

	@PostConstruct
	public void initialize() {
		this.service = new EjemploDao();
		// setDataManager(this.service); setear datasources
	}

	@Override
	public String decirHola() {
		return "Esto es la implementacion de un ejb!";
	}

	/**@Override
	public List<Contoh> listarCon() {
		return getService().getAllContoh();
	}**/

}
