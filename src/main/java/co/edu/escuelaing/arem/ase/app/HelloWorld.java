package co.edu.escuelaing.arem.ase.app;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        secure("certificados/ecikeystore.p12", "123456", null, null);

        staticFiles.location("/public");
        port(getPort());

        get("/hello", (req, res) -> "Hello World");

        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            return SecureUrlReader.secureReader(username, password);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
