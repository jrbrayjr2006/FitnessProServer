package com.jaydot2.fitnesspro.server.controller;

import com.jaydot2.fitnesspro.server.delegate.DataAdapterDelegate;
import com.jaydot2.fitnesspro.server.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
@Slf4j
public class CoreController {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String TAG = "CoreController";

    private DataAdapterDelegate delegate = new DataAdapterDelegate();

    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public CoreController() {}

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Android";
    }

    @GetMapping(value = "/count")
    @ResponseBody
    public ResponseEntity<String> getCount() {
        String result = "0";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);

        return responseEntity;
    }

    /**
     * <b>Description</b>
     * <p>
     *     Call delegate to commit new user to the database
     * </p>
     * @param user
     * @return
     */
    @PostMapping( value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        log.debug(TAG, "ENTER: addUser(String,String,String)...");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        if(delegate.createUser(user)) {
            return responseEntity;
        }
        log.debug(TAG, "EXIT: addUser(User user)...");
        return responseEntity;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(String username) {
        log.debug(TAG, "::ENTER:: getUser(String)...");
        //TODO
        log.debug(TAG, "::EXIT:: getUser(String)...");
        return SUCCESS;
    }

    @RequestMapping(value = "/myfitness/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getMyFitness(@PathVariable("id") String id) {
        log.debug(TAG, "::ENTER:: getMyFitness(String)...");
        Map<String, String> result = new HashMap<String, String>();
        //TODO
        log.debug(TAG, "::EXIT:: getMyFitness(String)...");
        return result;
    }

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public Map<String,String> test() {
        Map<String,String> result = new HashMap<String, String>();
        result.put("testKey", "testValue");
        return result;
    }

}
