package tn.iit.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tn.iit.entities.User;

@Repository
@EnableTransactionManagement
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Add a user
	 * 
	 * @param user
	 *            to add
	 */
	@Transactional
	public void add(User user) {
		em.persist(user);
	}

	/**
	 * Edit a user
	 * 
	 * @param user
	 *            to edit
	 */
	@Transactional
	public void update(User user) {
		em.merge(user);

	}

	/**
	 * Remove a given user
	 * 
	 * @param id
	 *            to be removed
	 */
	@Transactional
	public void remove(User u) {
		em.remove(em.contains(u) ? u : em.merge(u));
	}

	/**
	 * Remove a given user by login
	 * 
	 * @param user
	 *            login to be removed
	 */
	// @Transactional
	// public void removeByLogin(String login) {
	// users.remove(getByLogin(login));
	//
	// }

	/**
	 * get all users
	 * 
	 * @return all users
	 */
	public List<User> getAll() {
		return em.createQuery("SELECT u from User u", User.class).getResultList();
	}

	/**
	 * Get a single user by login
	 * 
	 * @param id
	 *            of the user
	 * @return a user
	 */
	public User getById(Long id) {
		return em.find(User.class, id);
	}

}
