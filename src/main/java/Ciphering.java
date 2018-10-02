import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by user on 11/23/17.
 */
public class Ciphering {
    public static Key generatorKey(String keyValue){
        return new SecretKeySpec(keyValue.getBytes(),"AES");
    }
    public String encrypt(String word,Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipherEncrypt = Cipher.getInstance("AES");
        cipherEncrypt.init(Cipher.ENCRYPT_MODE,key);
        byte[] bytes = cipherEncrypt.doFinal(word.getBytes());
        return  new BASE64Encoder().encode(bytes);

    }

    public String decrypt(String word,Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        Cipher cipherDecrypt = Cipher.getInstance("AES");
        cipherDecrypt.init(Cipher.DECRYPT_MODE,key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(word);
        byte[] bytes = cipherDecrypt.doFinal(decordedValue);
        return new String(bytes);
    }
}
