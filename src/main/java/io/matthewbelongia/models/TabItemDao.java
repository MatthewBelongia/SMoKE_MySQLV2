package io.matthewbelongia.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by matthewb on 6/15/16.
 */
@Transactional
public interface TabItemDao extends CrudRepository<TabItem,Long>{

    /**
     *
     * Return the tabItems of a tab given the tabid
     *
     * @param tabid
     */
    //TabItem findBytabid(Long tabid);

    List<TabItem> findAllByTabid(Long tabid);
}
