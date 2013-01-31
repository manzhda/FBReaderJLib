package org.geometerplus.expansion.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptorUtils {

    public static boolean isEncrypted(InputStream stream, String pattern) {
        boolean isEncrypted = false;

        byte[] patternBytes = pattern.getBytes();
        byte[] prefix = new byte[patternBytes.length];

        int READ_LIMIT = patternBytes.length;
        int count = 0;
        InputStream inputStream = new BufferedInputStream(stream, READ_LIMIT);
        inputStream.mark(READ_LIMIT);

        try {
            count = inputStream.read(prefix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((equals(prefix, patternBytes)) && (count == prefix.length)) {
            isEncrypted = true;
        }

        return isEncrypted;
    }

    public static String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        return number.toString(16);
    }

    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return digest;
    }

    private static boolean equals(byte[] prefix, byte[] pattern) {
        for (int i = 0; i < prefix.length; i++) {
            char infile = (char) prefix[i];
            char inpattern = (char) pattern[i];

            System.out.println(infile + " " + inpattern);

            if (prefix[i] != pattern[i]) {
                return false;
            }
        }

        return true;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        byte[] data = new byte[16384];
        int nRead;
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        return buffer.toByteArray();
    }

    public static byte[] getBytes(InputStream is) throws IOException {

        int size = 16384;
        int len;
        byte[] buf;

        if ((is instanceof ByteArrayInputStream)) {
            size = is.available();
            buf = new byte[size];
            len = is.read(buf, 0, size);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buf = new byte[size];

            while ((len = is.read(buf, 0, size)) != -1)
                bos.write(buf, 0, len);
            buf = bos.toByteArray();
        }

        return buf;
    }
}