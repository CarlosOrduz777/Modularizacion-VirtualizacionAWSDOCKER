package com.mycompany.virtualization.connection;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";

    public String mongoConnection(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://carlos:sanord20@mongo.fwxzofj.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("mongo");
        MongoCollection<Document> customers = database.getCollection("customers");

        FindIterable<Document> iterable = customers.find();
        MongoCursor<Document> cursor = iterable.iterator();

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        Document student1 = customers.find(new Document("_id", 123)).first();
        //Crea un documento BSON con el cliente
        //Document customer = new Document("_id", new ObjectId("12345"));
        //customer.append("firstName", "Carlos");
        //customer.append("lastName", "Orduz");



        //Agrega el nuevo cliente a la colección
        //customers.insertOne(customer);

        return student1.toJson();
    }


}
