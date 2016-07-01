package io.matthewbelongia.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by matthewb on 6/15/16.
 */
@Transactional
public interface TabDao extends CrudRepository<Tab,Long> {

    /**
     * Return the tab having the passed id or null is no tab is found.
     *
     * @param id the tab id
     */
    Tab findById(Long id);
}
