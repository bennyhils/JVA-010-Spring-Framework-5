package com.luxoft.springdb.lab2.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luxoft.springdb.lab2.dao.CountryDao;
import com.luxoft.springdb.lab2.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(country);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		if (entityManager != null) {
			countries = entityManager.createQuery("from Country", Country.class)
					.getResultList();
			entityManager.close();
		}

		return countries;
	}

	@Override
	public Country getCountryByName(String name) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Country country = null;
		if (em != null) {
			country = em
					.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name",
							Country.class).setParameter("name", name)
					.getSingleResult();
			em.close();
		}
		return country;
	}

}
