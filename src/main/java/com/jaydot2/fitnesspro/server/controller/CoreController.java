package com.jaydot2.fitnesspro.server.controller;

import com.jaydot2.fitnesspro.server.delegate.DataAdapterDelegate;
import com.jaydot2.fitnesspro.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamesbray on 7/3/16.
 */
@RestController
@CrossOrigin
@RequestMapping("/fitnesspro")
@EnableAutoConfiguration
public class CoreController {

    private static final Logger logger = LoggerFactory.getLogger(CoreController.class);
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String TAG = "CoreController";

    private DataAdapterDelegate delegate = new DataAdapterDelegate();

    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Android";
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String getCount() {
        String result = "0";

        return result;
    }

    /**
     * <b>Description</b>
     * <p>
     *     Call delegate to commit new user to the database
     * </p>
     * @param firstname
     * @param lastname
     * @param username
     * @return
     */
    @RequestMapping(value = "/createuser/{firstname}/{lastname}/{username}", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname, @PathVariable("username") String username) {
        logger.debug(TAG, "ENTER: addUser(String,String,String)...");
        String result = FAILURE;
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        if(delegate.createUser(user)) {
            result = SUCCESS;
        }
        logger.debug(TAG, "EXIT: addUser(String,String,String)...");
        return result;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(String username) {
        logger.debug(TAG, "::ENTER:: getUser(String)...");
        //TODO
        logger.debug(TAG, "::EXIT:: getUser(String)...");
        return SUCCESS;
    }

    @RequestMapping(value = "/myfitness/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getMyFitness(@PathVariable("id") String id) {
        logger.debug(TAG, "::ENTER:: getMyFitness(String)...");
        Map<String, String> result = new HashMap<String, String>();
        //TODO
        logger.debug(TAG, "::EXIT:: getMyFitness(String)...");
        return result;
    }

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public Map<String,String> test() {
        Map<String,String> result = new HashMap<String, String>();
        result.put("testKey", "testValue");
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoreController.class, args);
    }
}
