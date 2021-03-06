package com.jaydot2.fitnesspro.server.dao;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by jamesbray on 7/3/16.
 */
@Component("DAO")
@Slf4j
public class MongoDBDAOImpl {

    private final static String TAG = "MongoDBDAOImpl";

    private MongoClient mongoClient;
    private String host = "localhost";
    private int port = 27017;
    private MongoDatabase database;
    private MongoCollection<Document> collection;


    /**
     * <p>
     *     Get a count of records
     * </p>
     * @return
     */
    public String getCount() {
        String result = "0";
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }

        MongoDatabase db = mongoClient.getDatabase("fitnesspro");
        MongoCollection<Document> exerciseCollection = db.getCollection("exercises");

        return result;
    }

    /**
     * <p>
     *     Singleton pattern applied
     * </p>
     * @return
     */
    public static MongoDBDAOImpl getInstance() {
        MongoDBDAOImpl dao = new MongoDBDAOImpl();
        return dao;
    }

    private MongoDBDAOImpl() {}


    public void setDatabaseConnection(String server, int port) {
        log.debug(TAG + " ::ENTER:: setDatabaseConnection(String,int)...");
        if(mongoClient == null) {
            mongoClient = new MongoClient(server,port);
        }
        log.debug(TAG + " ::EXIT:: setDatabaseConnection(String,int)...");
    }

    /**
     * <b>Description</b>
     * <p>
     *     Get collection from a single MongoDB database instance
     * </p>
     * @param databaseName
     * @param collectionName
     * @return
     */
    protected MongoCollection<Document> getCollection(String databaseName, String collectionName) {
        log.debug(TAG + " ::ENTER:: getCollection(String,String)...");
        MongoCollection<Document> col = null;
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }

        if(databaseName != null) {
            database = mongoClient.getDatabase(databaseName);
        } else {
            database = mongoClient.getDatabase("fitnesspro");
        }

        if(collectionName != null) {
            col = database.getCollection(collectionName);
        } else {
            col = database.getCollection("exercises");
        }

        //TODO

        log.debug(TAG + " ::EXIT:: getCollection(String,String)...");
        return col;
    }


    protected MongoCollection<Document> getCollectionFromReplicaSet(ServerAddress[] servers, String databaseName, String collecionName) {
        log.debug(TAG + " ::ENTER:: getCollectionFromReplicaSet(ServerAddress[],String,String)...");
        MongoClient replicaSet = new MongoClient(Arrays.asList(servers));
        database = replicaSet.getDatabase(databaseName);
        MongoCollection<Document> col = database.getCollection(collecionName);
        log.debug(TAG + " ::EXIT:: getCollectionFromReplicaSet(ServerAddress[],String,String)...");
        return col;
    }

    /**
     * Insert a new record into the database
     */
    public void insertData(String databaseName, String collectionName) {
        log.debug(TAG + " ::ENTER:: insertData(String,String)...");
        MongoCollection<Document> col = null;
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }

        if(databaseName != null) {
            database = mongoClient.getDatabase(databaseName);
        } else {
            database = mongoClient.getDatabase("fitnesspro");
        }

        if(collectionName != null) {
            col = database.getCollection(collectionName);
        } else {
            col = database.getCollection("exercises");
        }

        Document record = new Document();  //TODO
        //TODO
        col.insertOne(record);

        log.debug(TAG + " ::EXIT:: insertData(String,String)...");
    }

    /**
     * <p>
     *     Delete a record from the database
     * </p>
     * @param objId
     */
    public void deleteRecord(String databaseName, String collectionName, String objId) {
        log.debug(TAG + " ::ENTER:: deleteRecord(String,String,String)...");
        MongoCollection<Document> col = null;
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }

        if(databaseName != null) {
            database = mongoClient.getDatabase(databaseName);
        } else {
            database = mongoClient.getDatabase("fitnesspro");
        }

        if(collectionName != null) {
            col = database.getCollection(collectionName);
        } else {
            col = database.getCollection("exercises");
        }

        //TODO

        log.debug(TAG + " ::EXIT:: deleteRecord(String,String,String)...");
    }
}
