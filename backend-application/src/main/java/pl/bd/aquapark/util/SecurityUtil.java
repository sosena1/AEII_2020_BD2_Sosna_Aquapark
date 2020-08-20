package pl.bd.aquapark.util;

import pl.bd.aquapark.exception.SneakyException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class SecurityUtil {
    public static String toMd5(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes());
            byte[] digest = messageDigest.digest();
            return DatatypeConverter.printHexBinary(digest).toLowerCase();
        } catch (Exception e) {
            throw new SneakyException(e);
        }
    }
}
