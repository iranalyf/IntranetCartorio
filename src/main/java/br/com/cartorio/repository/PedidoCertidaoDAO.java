package br.com.cartorio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cartorio.models.PedidoCertidao;

public class PedidoCertidaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf;
	private EntityManager manager;

	public PedidoCertidaoDAO() {
		this.emf = Persistence.createEntityManagerFactory("cartorioPU");
		this.manager = emf.createEntityManager();
	}

	public void saveOrUpdate(PedidoCertidao pedidoCertidao) {
		this.manager.getTransaction().begin();
		this.manager.merge(pedidoCertidao);
		this.manager.getTransaction().commit();
	}

	public void delete(PedidoCertidao pedidoCertidao) {
		this.manager.getTransaction().begin();
		this.manager.remove(pedidoCertidao);
		this.manager.getTransaction().commit();
	}

	public List<PedidoCertidao> findAll() {

		return this.manager.createQuery("select pc from PedidoCertidao pc", PedidoCertidao.class)
				.getResultList();
	}

	public PedidoCertidao findOne(Long id) {
		return this.manager.find(PedidoCertidao.class, id);
	}
}
