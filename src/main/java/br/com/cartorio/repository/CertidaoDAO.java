package br.com.cartorio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cartorio.models.Certidao;

public class CertidaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	private EntityManager manager;

	public CertidaoDAO() {
		this.emf = Persistence.createEntityManagerFactory("cartorioPU");
		this.manager = emf.createEntityManager();
	}

	public void saveOrUpdate(Certidao certidao) {

		this.manager.getTransaction().begin();
		this.manager.merge(certidao);
		this.manager.getTransaction().commit();
	}

	public void delete(Certidao certidao) {

		this.manager.getTransaction().begin();
		this.manager.remove(certidao);
		this.manager.getTransaction().commit();
	}

	public List<Certidao> findAll() {

		return this.manager.createQuery("select c from Certidao c", Certidao.class)
				.getResultList();
	}

	public Certidao findOne(Long id) {
		return this.manager.find(Certidao.class, id);
	}
}
