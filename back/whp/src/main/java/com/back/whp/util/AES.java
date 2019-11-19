package com.back.whp.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密及解密
 */
public class AES {

    //初始向量
    private static final String CLIENT_VIPARA = "aabbccddeeffgghh";   //AES 为16bytes. DES 为8bytes
    //编码方式
    private static final String bm = "UTF-8";
    //私钥
    private static final String CLIENT_ASE_KEY = "aabbccddeeffgghh";   //AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。

    //服务器加密信息
    private static final String SERVER_VIPARA = "tuituituituibaba";
    private static final String SERVER_ASE_KEY = "tuituituituibaba";

    /**
     * AES加密
     *
     * @param cleartext 明文
     * @return 密文
     */
    public static String clientEncrypt(String cleartext) {
        //加密方式： AES128(CBC/PKCS5Padding) + Base64, 私钥：aabbccddeeffgghh
        return encryptWithViparaAndASEKey(cleartext, CLIENT_VIPARA, CLIENT_ASE_KEY);
    }

    /**
     * 解密
     *
     * @param encrypted 密文
     * @return 明文
     */
    public static String clientDecrypt(String encrypted) {
        return decryptWithViparaAndASEKey(encrypted, CLIENT_VIPARA, CLIENT_ASE_KEY);
    }

    public static String serverEncrypt(String cleartext){
        return encryptWithViparaAndASEKey(cleartext, SERVER_VIPARA, SERVER_ASE_KEY);
    }

    public static String serverDecrypt(String encrypted){
        return decryptWithViparaAndASEKey(encrypted, SERVER_VIPARA, SERVER_ASE_KEY);
    }

    private static String encryptWithViparaAndASEKey(String cleartext, String vipara,String ase_key){
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(vipara.getBytes());
            //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            SecretKeySpec key = new SecretKeySpec(ase_key.getBytes(), "AES");
            //实例化加密类，参数为加密方式，要写全
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //PKCS5Padding比PKCS7Padding效率高，PKCS7Padding可支持IOS加解密
            //初始化，此方法可以采用三种方式，按加密算法要求来添加。
            // （1）无第三个参数
            // （2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)
            // （3）采用此代码中的IVParameterSpec
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等。此处看服务器需要什么编码方式
            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(bm));

            return new BASE64Encoder().encode(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String decryptWithViparaAndASEKey(String encrypted, String vipara,String ase_key){
        try {
            byte[] byteMi = new BASE64Decoder().decodeBuffer(encrypted);
            IvParameterSpec zeroIv = new IvParameterSpec(vipara.getBytes());
            SecretKeySpec key = new SecretKeySpec(
                    ase_key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //与加密时不同MODE:Cipher.DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData, bm);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 测试main方法
     */
    public static void main(String[] args) throws Exception {

        String content = "123456";
        // 加密
        System.out.println("加密前：" + content);
        String encryptResult = clientEncrypt(content);

        System.out.println("加密后：" + encryptResult);
        // 解密
        String decryptResult = clientDecrypt(encryptResult);
        System.out.println("解密后：" + decryptResult);

        System.out.println(AES.clientEncrypt("/W9ZVyyem7ZFZ0TM5XwI+g=="));

    }

}
