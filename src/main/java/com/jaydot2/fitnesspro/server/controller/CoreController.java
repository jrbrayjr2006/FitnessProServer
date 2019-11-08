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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by jamesbray on 7/3/16.
 */
@RestController
@CrossOrigin
@RequestMapping("/fitnesspro")
@Slf4j
@Api(value = "CoreController", description = "An API for basic CRUD operations")
public class CoreController {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String TAG = "CoreController";

    private DataAdapterDelegate delegate = new DataAdapterDelegate();

    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public CoreController() {}

    @GetMapping("/")
    public String home() {
        return "Hello, Android";
    }

    @GetMapping(value = "/count")
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
    @ApiOperation(
            value = "A brief description of this operation",
            notes = "detailed notes on what this operation does"
    )
    @ApiResponses( value = {@ApiResponse(code=201, message="This user was created")})
    @PostMapping( value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        log.debug(TAG, "ENTER: addUser(String,String,String)...");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        if(delegate.createUser(user)) {
            return responseEntity;
        }
        log.debug(TAG, "EXIT: addUser(User user)...");
        return responseEntity;
    }

    @GetMapping(value = "/getuser")
    public ResponseEntity<String> getUser(String username) {
        log.debug(TAG, "::ENTER:: getUser(String)...");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
        //TODO
        log.debug(TAG, "::EXIT:: getUser(String)...");
        return responseEntity;
    }

    @GetMapping(value = "/myfitness/{id}")
    public Map<String, String> getMyFitness(@PathVariable("id") String id) {
        log.debug(TAG, "::ENTER:: getMyFitness(String)...");
        Map<String, String> result = new HashMap<String, String>();
        //TODO
        log.debug(TAG, "::EXIT:: getMyFitness(String)...");
        return result;
    }

    @GetMapping(value="/test")
    public Map<String,String> test() {
        Map<String,String> result = new HashMap<String, String>();
        result.put("testKey", "testValue");
        return result;
    }

}
