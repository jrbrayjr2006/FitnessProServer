package com.jaydot2.fitnesspro.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jamesbray on 7/3/16.
 */
@Controller
@EnableAutoConfiguration
public class CoreController {

    private static final Logger logger = LoggerFactory.getLogger(CoreController.class);
    private static final String SUCCESS = "success";
    private static final String TAG = "CoreController";

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Android";
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
    public String addUser(String firstname, String lastname, String username) {
        logger.debug(TAG, "ENTER: addUser(String,String,String)...");
        return SUCCESS;
    }

    public String getUser(String username) {
        return SUCCESS;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoreController.class, args);
    }
}
