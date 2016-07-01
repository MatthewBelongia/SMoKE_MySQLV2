package io.matthewbelongia.controllers;

import io.matthewbelongia.models.User;
import io.matthewbelongia.models.UserDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@CrossOrigin
@RestController
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
//
//  /**
//   * /create  --> Create a new user and save it in the database.
//   *
//   * @param email User's email
//   * @param name User's name
//   * @return A string describing if the user is succesfully created or not.
//   */
//  @RequestMapping("/create")
//  @ResponseBody
//  public String create(String email, String name,String lastname,String password) {
//    User user = null;
//    try {
//      user = new User(email, name,lastname,password);
//      userDao.save(user);
//    }
//    catch (Exception ex) {
//      return "Error creating the user: " + ex.toString();
//    }
//    return "User succesfully created! (id = " + user.getId() + ")";
//  }
//
//  /**
//   * /delete  --> Delete the user having the passed id.
//   *
//   * @param id The id of the user to delete
//   * @return A string describing if the user is succesfully deleted or not.
//   */
//  @RequestMapping("/delete")
//  @ResponseBody
//  public String delete(long id) {
//    try {
//      User user = new User(id);
//      userDao.delete(user);
//    }
//    catch (Exception ex) {
//      return "Error deleting the user: " + ex.toString();
//    }
//    return "User succesfully deleted!";
//  }
//
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    /**
   * /pw  --> Return the user  having the passed password.
   * 
   * @param password The email to search in the database.
   * @return The user or a message error if the user is not found.
   */
  @RequestMapping(value = "/pw", method = RequestMethod.GET)
  @ResponseBody
  public User getByPassword(String password) {
    User user;
    try {
      user = userDao.findByPassword(password);
        //log.info(user.toString());
        log.info("user found");

    }
    catch (Exception ex) {
        log.info("User not found");
      return null;
    }
    return user;
  }


////
////  *
////   * /update  --> Update the email and the name for the user in the database
////   * having the passed id.
////   *
////   * @param id The id for the user to update.
////   * @param email The new email.
////   * @param name The new name.
////   * @return A string describing if the user is succesfully updated or not.
////
////  @RequestMapping("/update")
////  @ResponseBody
////  public String updateUser(long id, String email, String name,String lastname,String password) {
////    try {
////      User user = userDao.findOne(id);
////      user.setId(id);
////      user.setFirstname(name);
////      userDao.save(user);
////    }
////    catch (Exception ex) {
////      return "Error updating the user: " + ex.toString();
////    }
////    return "User succesfully updated!";
////  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserDao userDao;
  
} // class UserController
