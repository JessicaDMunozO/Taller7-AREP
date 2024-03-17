package co.edu.escuelaing.arem.ase.app;

import static spark.Spark.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class UserLogin {
    public static HashMap<String, String> userDB = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        userDB.put("JDMO", Cypher.cypherPassword("123456789"));
        userDB.put("Ossa", Cypher.cypherPassword("coco47"));

        secure("certificados/ecikeystore.p12", "123456", null, null);

        port(getPort());

        get("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            String response = loginResponse(username, password);
            return response;
        });

    }

    /**
     * Gives the response of a login with a username and password
     * 
     * @param username the username of the user that wants to login
     * @param password the password of the user that wants to login
     * @return a message with the response of the authentication
     * @throws NoSuchAlgorithmException if there is an error with the cryptographic
     *                                  algorithm
     */
    public static String loginResponse(String username, String password) throws NoSuchAlgorithmException {
        if (!userDB.containsKey(username)) {
            return "Invalid username";
        } else {
            if (userDB.get(username).equals(Cypher.cypherPassword(password))) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        }
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}
