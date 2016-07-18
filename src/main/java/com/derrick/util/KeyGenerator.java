package com.derrick.util;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by ccc on 2016/7/11.
 */
public class KeyGenerator {
    public static void generateKey(String keyFilePath){
        RSAEncrypt.genKeyPair();
    }

    /*public static void main(String[] args){
        //KeyGenerator.generateKey(Constant.KEY_FILE_PATH);
        try {
            String plainTxt = "{branchCode:4010100,userCode:999,expTime:'2017-07-10 23:59:59'}";
            String base64Txt = Base64EncryptorUtils.encoderBASE64(plainTxt);
            System.out.println("base64Txt:" + base64Txt);

            RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByStr(Constant.PUBLIC_KEY_STR);
            RSAPrivateKey privateKey = RSAEncrypt.loadPrivateKeyByStr(Constant.PRIVATE_KEY_STR);
            byte[] encryptByte = RSAEncrypt.encrypt(publicKey, plainTxt.getBytes());
            System.out.println("encryptByte:" + new String(encryptByte));
            String encryptStr = Base64.encodeBase64String(encryptByte);
            System.out.println("encryptStr:" + encryptStr);

            byte[] deByte = Base64.decodeBase64(encryptStr);
            System.out.println("deByte:" + new String(deByte));
            byte[] deTxt = RSAEncrypt.decrypt(privateKey, deByte);
            System.out.println("deTxt:" + new String(deTxt));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}
