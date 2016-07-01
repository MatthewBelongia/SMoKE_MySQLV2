package io.matthewbelongia.controllers;

import com.google.common.collect.Lists;
import io.matthewbelongia.models.Tab;
import io.matthewbelongia.models.TabDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by matthewb on 6/15/16.
 */
@CrossOrigin
@RestController
public class TabController {



    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /newtab --> create a new tab and save it in database
     *
     * @param empid Employee's Id who opened tab
     * @param name Employess's name who opened tab
     * @param location tab's location
     * @param card tab's card
     *
     * @param date timestamp of tab opening
     */
    @RequestMapping(value = "/newtab", method = RequestMethod.GET)
    @ResponseBody
    public Tab newTab(String empid, String name,String location,String card, Timestamp date){
        Tab tab = null;
        try{
            tab = new Tab(empid,name,location,card,date);
            tabDao.save(tab);
            log.info("tab saved");
        }catch (Exception ex){
            log.info("tab not saved");
            return null;
        }
        return tab;
    }

    /**
     * /tabid --> Return the tab having the passed id
     *
     *
     * @return the tab or null if not found
     */
    @RequestMapping(value = "/tab", method = RequestMethod.GET)
    @ResponseBody
    public List<Tab> getAllTabs(){
        return Lists.newArrayList(tabDao.findAll());
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------


    @Autowired
    private TabDao tabDao;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

}
