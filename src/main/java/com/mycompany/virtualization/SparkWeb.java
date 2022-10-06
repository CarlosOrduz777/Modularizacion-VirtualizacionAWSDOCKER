package com.mycompany.virtualization;
import com.mycompany.virtualization.connection.HttpConnection;

import static spark.Spark.*;
public class SparkWeb {

    public static void main(String[] args) {
        port(getPort());
        HttpConnection connection = new HttpConnection();
        staticFiles.location("/public");
        get("/hello", (req, res) -> {
            return connection.mongoConnection();
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
