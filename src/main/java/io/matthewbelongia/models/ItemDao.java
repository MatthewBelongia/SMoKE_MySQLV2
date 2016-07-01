
package io.matthewbelongia.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

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
public interface ItemDao extends CrudRepository<Item, BigInteger> {

    /**
     * Return the item having the passed brandId or null if no user is found.
     *
     * @param sku the item.
     */

     //Item findByBrandId(Integer brandId);

     Item findBySku(BigInteger sku);

     Item findById(Long id);



} // class ItemDao

