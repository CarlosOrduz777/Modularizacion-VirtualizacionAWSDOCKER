package com.mycompany.virtualization;
import static spark.Spark.*;
public class SparkWeb {

    public static void main(String[] args) {
        get("hello", (req, res) -> {
            return "Hello World";
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
