package com.revature.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.model.PokemonType;
import com.revature.util.ConnectionUtil;

public class PokemonTypeRepositoryHibernate implements PokemonTypeRepository {

	@Override
	public int save(PokemonType pokemonType) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		Integer generatedId = (Integer) session.save(pokemonType);
		session.getTransaction().commit();
		return generatedId;
	}

	@Override
	public PokemonType findByElement(String element) {
		try {
			return (PokemonType) ConnectionUtil.getSession()
					.createCriteria(PokemonType.class)
					.add(Restrictions.like("element", element))
					.list()
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
