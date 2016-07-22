package com.jaydot2.fitnesspro.server.dao;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by jamesbray on 7/3/16.
 */
@Component("DAO")
public class MongoDBDAOImpl {

    private final static String TAG = "MongoDBDAOImpl";
    private Logger LOG = LogManager.getLogger(MongoDBDAOImpl.class);

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
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
        LOG.debug(TAG + " ::ENTER:: getCollection(String,String)...");
        database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> col = database.getCollection(collectionName);
        LOG.debug(TAG + " ::EXIT:: getCollection(String,String)...");
        return col;
    }


    protected MongoCollection<Document> getCollectionFromReplicaSet(ServerAddress[] servers, String databaseName, String collecionName) {
        LOG.debug(TAG + " ::ENTER:: getCollectionFromReplicaSet(ServerAddress[],String,String)...");
        MongoClient replicaSet = new MongoClient(Arrays.asList(servers));
        database = replicaSet.getDatabase(databaseName);
        MongoCollection<Document> col = database.getCollection(collecionName);
        LOG.debug(TAG + " ::EXIT:: getCollectionFromReplicaSet(ServerAddress[],String,String)...");
        return col;
    }

    /**
     *
     */
    public void insertData() {
        LOG.debug(TAG + " ::ENTER:: insertData()...");
        //TODO
        collection = getCollection("test","users");
        LOG.debug(TAG + " ::EXIT:: insertData()...");
    }
}
