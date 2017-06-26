package br.com.cartorio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cartorio.models.Cliente;

public class ClienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf;
	private EntityManager manager;

	public ClienteDAO() {
		this.emf = Persistence.createEntityManagerFactory("cartorioPU");
		this.manager = emf.createEntityManager();
	}

	public void saveOrUpdate(Cliente cliente) {
		this.manager.getTransaction().begin();
		this.manager.merge(cliente);
		this.manager.getTransaction().commit();
	}

	public void delete(Cliente cliente) {
		this.manager.getTransaction().begin();
		this.manager.remove(cliente);
		this.manager.getTransaction().commit();
	}

	public List<Cliente> findAll() {

		return this.manager.createQuery("select c from Cliente c", Cliente.class)
				.getResultList();
	}

	public Cliente findOne(Long id) {
		return this.manager.find(Cliente.class, id);
	}

}
