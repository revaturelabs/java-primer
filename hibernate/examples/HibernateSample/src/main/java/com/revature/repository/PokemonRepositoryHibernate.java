package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;
import com.revature.util.ConnectionUtil;

public class PokemonRepositoryHibernate implements PokemonRepository {

	@Override
	public int save(Pokemon pokemon) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		Integer generatedId = (Integer) session.save(pokemon);
		session.getTransaction().commit();
		return generatedId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> findAll() {
		return ConnectionUtil.getSession()
				.createCriteria(Pokemon.class)
				.list();
	}

	@Override
	public Pokemon findByName(String name) {
		return (Pokemon) ConnectionUtil.getSession()
				.createCriteria(Pokemon.class)
				.add(Restrictions.like("name", name))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> findByType(PokemonType pokemonType) {
		return ConnectionUtil.getSession()
				.createCriteria(Pokemon.class)
				.add(Restrictions.eq("type", pokemonType))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> findByNameLike(String pattern) {
		String hql = "FROM com.revature.model.Pokemon WHERE name LIKE :pattern";
		return ConnectionUtil.getSession()
				.createQuery(hql)
				.setString("pattern", pattern)
				.list();
	}

	@Override
	public Pokemon findByNameNative(String name) {
		String sql = "SELECT * FROM POKEMON WHERE P_NAME LIKE UPPER(:name)";
		return (Pokemon) ConnectionUtil.getSession()
				.createSQLQuery(sql)
				.addEntity(Pokemon.class)
				.setString("name", name)
				.uniqueResult();
	}

}
