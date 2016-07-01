
package io.matthewbelongia.controllers;

import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import io.matthewbelongia.models.Item;
import io.matthewbelongia.models.ItemDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


/**
 * A class to test interactions with the MySQL database using the ItemDao class.
 *
 * @author zipcoderm
 */

@CrossOrigin
@RestController
public class ItemController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * /sku --> search mySql database for item
     * @param sku id in the mySql db
     * @return item with matching id
     */
    //@CrossOrigin
    @RequestMapping(value = "/sku", method = RequestMethod.GET)
    @ResponseBody
    public Item getBySku(BigInteger sku) {
        Item item;
        try {
            item = itemDao.findBySku(sku);
            log.info("item found");
        }
        catch (Exception ex) {
            log.info("Item not found");
            return null;
        }
        return item;
    }

    /**
     * /cigarid search MySql database for item
     * @param id id in MySQL db
     * @return item with matching cigarid
     */

    @RequestMapping(value = "/cigarid",method = RequestMethod.GET)
    @ResponseBody
    public Item getByCigarId(Long id){
        Item item;
        try {
            item = itemDao.findById(id);
            log.info("item found by cigarid");
            //log.info(item.getName());
        }
        catch (Exception ex){
            log.info("Item not found by cigarid");
            return null;
        }
        return item;
    }

    /*
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/rid")
    public @ResponseBody Item item(@RequestParam(required = false, d))
    */



    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private ItemDao itemDao;


    /**
     * /create  --> Create a new item and save it in the database.
     *
     * @param brandId Item's email
     * @param name Item's name
     * @return A string describing if the item is succesfully created or not.
     */
/*
    @RequestMapping("/createitem")
    @ResponseBody
    public String create(Integer brandId, String name,Double cost) {
        Item item = null;
        try {
            item = new Item(name,cost);
            item.setId(1l);
            itemDao.save(item);
        }
        catch (Exception ex) {
            return "Error creating the item: " + ex.toString();
        }
        return "Item succesfully created! (name = " + item.getFirstname() + ")";
    }
*/
    /**
     * /delete  --> Delete the item having the passed id.
     *
     * @param id The id of the item to delete
     * @return A string describing if the item is succesfully deleted or not.
     */
/*
    @RequestMapping("/deleteitem")
    @ResponseBody
    public String delete(long id) {
        try {
            Item item = new Item(id);
            itemDao.delete(item);
        }
        catch (Exception ex) {
            return "Error deleting the item: " + ex.toString();
        }
        return "Item succesfully deleted!";
    }

    /**
     * /brandId  --> Return the name for the item having the passed brandId.
     *
     * @param brandId The brandId to search in the database.
     * @return The item name or a message error if the item is not found.
     */

    /*
    @RequestMapping("/brandId")
    @ResponseBody
    public String getByBrandId(Integer brandId) {
        String itemName;
        try {
            Item item = itemDao.findByBrandId(brandId);
            itemName = String.valueOf(item.getFirstname());
        }
        catch (Exception ex) {
            return "Item not found";
        }
        return "The item name is: " + itemName;
    }
*/






    /*
        private final Logger log = LoggerFactory.getLogger(this.getClass());

        @RequestMapping(value  = "/user", method = RequestMethod.GET)
        public User getUser(){
            log.info("requested a user via GET");
            return new User("Drake",30);
        }

        @RequestMapping(value = "/user", method = RequestMethod.POST)
        public User createUser(){
            log.info("requested a user via POST");
            return new User("Drake",22);
        }
    */



    /**
     * /update  --> Update the brandId and the name for the item in the database
     * having the passed brandId.
     *
     * @param id The id for the item to update.
     * @param brandId The new brandId.
     * @param name The new name.
     * @return A string describing if the item is succesfully updated or not.
     */
/*
    @RequestMapping("/updateitem")
    @ResponseBody
    public String updateItem(long id, Integer brandId, String name) {
        try {
            Item item = itemDao.findOne(id);
            //item.setBrandId(brandId);
            item.setFirstname(name);
            itemDao.save(item);
        }
        catch (Exception ex) {
            return "Error updating the item: " + ex.toString();
        }
        return "Item succesfully updated!";
    }
*/


} // class ItemController
