
import javax.crypto.*;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by user on 11/21/17.
 */

public class CipTest {
    public static void main(String[] args) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Ciphering ciphering = new Ciphering();
        Key k = Ciphering.generatorKey("1234567890123456");
        System.out.print(ciphering.encrypt("Hello",k));
        System.out.println();
        System.out.print(ciphering.decrypt(ciphering.encrypt("Hello",k),k));
    }
}
