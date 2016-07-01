package io.matthewbelongia.controllers;

import com.google.common.collect.Lists;
import io.matthewbelongia.models.TabItem;
import io.matthewbelongia.models.TabItemDao;
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
public class TabItemController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     *   /addtabitem --> add tabitem to tab and save it to database
     *
     *   @param tabid tab id which is being added to
     *   @param cigarid id of item added
     *   @param retail price of item
     *   @param quantity number of item added
     *   @param discount discount on item in tab
     *   @param finalamount price after discount
     *   @param timestamp time item was added to tab
     *   @param coalcount number of coals used
     *   @param hookahbuilder type of hookah used
     *   @param salesemployeeid the employee who added the item
     *
     */
    @RequestMapping(value = "/addtabitem", method = RequestMethod.GET)
    @ResponseBody
    public TabItem addTabItemById(Long tabid, Long cigarid, Double retail, Long quantity,
                                  Long discount, Double finalamount, Timestamp timestamp,
                                  Long coalcount,String hookahbuilder,String salesemployeeid){
        TabItem tabItem = null;
        try{
            tabItem = new TabItem(tabid,cigarid,retail,quantity,discount,finalamount,timestamp,coalcount,hookahbuilder,salesemployeeid);
            tabItemDao.save(tabItem);
            log.info("tab item added");
        }catch(Exception ex){
            log.info(ex.toString());
            log.info("tab item not added");
            return null;
        }
        return tabItem;
    }

    /**
     * /gettabitem --> return the tabitem
     * @param tabid
     * @return
     */
    @RequestMapping(value = "gettabitem", method = RequestMethod.GET)
    @ResponseBody
    public List<TabItem> getTabItemBytabid(Long tabid){
        return Lists.newArrayList(tabItemDao.findAllByTabid(tabid));
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private TabItemDao tabItemDao;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


}
