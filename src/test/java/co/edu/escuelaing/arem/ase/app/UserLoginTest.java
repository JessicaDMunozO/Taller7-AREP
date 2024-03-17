package co.edu.escuelaing.arem.ase.app;

import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;

public class UserLoginTest extends TestCase {
    private UserLogin userLogin = new UserLogin();

    public void setUp() throws NoSuchAlgorithmException {
        userLogin.userDB.put("JDMO", Cypher.cypherPassword("123456789"));
        userLogin.userDB.put("Ossa", Cypher.cypherPassword("coco47"));
    }

    public void testInvalidUsername() throws NoSuchAlgorithmException {
        assertEquals("Invalid username", userLogin.loginResponse("Carlos", "123456789"));
    }

    public void testValidLogin() throws NoSuchAlgorithmException {
        assertEquals("Login successful", userLogin.loginResponse("JDMO", "123456789"));
    }

    public void testInvalidPassword() throws NoSuchAlgorithmException {
        assertEquals("Invalid password", userLogin.loginResponse("Ossa", "hola_mundo"));
    }
}
