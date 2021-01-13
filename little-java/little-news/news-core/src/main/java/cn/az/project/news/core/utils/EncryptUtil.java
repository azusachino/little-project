package cn.az.project.news.core.utils;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.Security;

/**
 * The type Encrypt util.
 *
 * @author azusachino
 */
public class EncryptUtil {


    private static String strDefaultKey = "defaultKey";

    private Cipher encryptCipher;

    private Cipher decryptCipher;

    /**
     * Instantiates a new Encrypt util.
     *
     * @throws Exception the exception
     */
    public EncryptUtil() throws Exception {
        this(strDefaultKey);
    }

    /**
     * Instantiates a new Encrypt util.
     *
     * @param strKey the str key
     * @throws Exception the exception
     */
    EncryptUtil(String strKey) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());

        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    private static String byteArr2HexStr(byte[] arr) {
        int iLen = arr.length;
        StringBuilder sb = new StringBuilder(iLen * 2);
        for (byte anArr : arr) {
            int intTmp = anArr;
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    private static byte[] hexStr2ByteArr(String strIn) {
        byte[] arr = strIn.getBytes();
        int iLen = arr.length;

        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arr, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    private byte[] encrypt(byte[] arr) throws Exception {
        return encryptCipher.doFinal(arr);
    }

    /**
     * Encrypt string.
     *
     * @param strIn the str in
     * @return the string
     * @throws Exception the exception
     */
    String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes()));
    }

    private byte[] decrypt(byte[] arr) throws Exception {
        return decryptCipher.doFinal(arr);
    }

    /**
     * Decrypt string.
     *
     * @param strIn the str in
     * @return the string
     */
    String decrypt(String strIn) {
        try {
            return new String(decrypt(hexStr2ByteArr(strIn)));
        } catch (Exception e) {
            return "";
        }
    }

    private Key getKey(byte[] arrTmp) {
        byte[] arr = new byte[8];
        for (int i = 0; i < arrTmp.length && i < arr.length; i++) {
            arr[i] = arrTmp[i];
        }
        return new javax.crypto.spec.SecretKeySpec(arr, "DES");
    }
}
