package com.mycompany.virtualization.connection;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";

    public List<Document> mongoConnection(){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("mongo");
        MongoCollection<Document> customers = database.getCollection("customers");

        FindIterable<Document> iterable = customers.find();
        MongoCursor<Document> cursor = iterable.iterator();

        List<Document> listret = new ArrayList<>();
        StringBuffer response;
        //Recorre el iterador obtenido del iterable
        while (cursor.hasNext()) {
            System.out.println("desdee el iterador------->");
            System.out.println(cursor.next());
            if(listret.size() <= 10){
                listret.add(cursor.next());

            }
        }

        return listret;
    }

    public void insert(String cadena){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("mongo");
        MongoCollection<Document> customers = database.getCollection("customers");

        Document document = new Document();
        document.append("cadena",cadena);
        document.append("fecha", new Date());
        customers.insertOne(document);
    }


}
