package Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.spec.KeySpec;

/**
 * Created by butkoav on 22.06.2016.
 */
public class AESEncryptionExample
{
    private static void encryptData(String pass, InputStream is, OutputStream os) throws Throwable
    {

        SecretKey key = getKey(pass);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        int count = 0;
        byte[] in = new byte[is.available()];

        os.write(iv.length);
        os.write(iv);

        is.read(in);

        os.write(cipher.doFinal(in));
    }

    private static void decryptData(String pass, InputStream is, OutputStream os) throws Throwable
    {
        SecretKey key = getKey(pass);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        int ivLenth = is.read();
        byte[] iv = new byte[ivLenth];
        is.read(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        int count = 0;
        byte[] in = new byte[is.available()];
        is.read(in);
        {
            os.write(cipher.doFinal(in));
        }
    }

    private static SecretKey getKey(String password) throws Throwable
    {
        byte[] salt = {1, 3, 3, 2, 1, 3, 3, 2};
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
    }
}
