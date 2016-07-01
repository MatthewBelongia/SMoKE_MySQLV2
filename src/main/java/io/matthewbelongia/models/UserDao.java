package io.matthewbelongia.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

/**
 * A DAO for the entity Item is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author netgloo
 */
@Transactional
public interface UserDao extends CrudRepository<User, String> {

  /**
   * Return the user having the passed password or null if no user is found.
   * 
   * @param password the user password.
   */
  User findByPassword(String password);

} // class UserDao
