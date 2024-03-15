package co.edu.escuelaing.arem.ase.app;

import static spark.Spark.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class UserLogin {
    private static HashMap<String, String> userDB = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        userDB.put("JDMO", Cypher.cypherPassword("123456789"));
        userDB.put("Ossa", Cypher.cypherPassword("coco47"));

        secure("certificados/ecikeystore.p12", "123456", null, null);

        port(getPort());

        get("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            if (!userDB.containsKey(username)) {
                return "Invalid username";
            } else {
                if (userDB.get(username).equals(Cypher.cypherPassword(password))) {
                    return "Login successful";
                } else {
                    return "Invalid password";
                }
            }
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}
