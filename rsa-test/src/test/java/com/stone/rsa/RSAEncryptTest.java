package com.stone.rsa;

import com.stone.util.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * RSA加解密测试
 * Created by Stone on 2016/12/21.
 */
public class RSAEncryptTest {

    private String plainText;
    private String cipher;
    private byte[] cipherData;
    private byte[] res;
    private String resStr;
    private String filepath;

    @Before
    public void before() {
        URL url = this.getClass().getClassLoader().getResource("");
        assertNotNull(url);
        String file = url.getFile();
        filepath = new File(file).getAbsolutePath();
    }

    @After
    public void after() {
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + cipher);
        System.out.println("解密：" + resStr);
    }

    @Test
    public void genKeyPair() throws Exception {
        RSAEncrypt.genKeyPair(filepath);
    }

    @Test
    public void pubEncryptPriDecrypt() throws Exception {
        plainText = "stone_公钥加密私钥解密";
        // 公钥加密过程
        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
                plainText.getBytes());
        cipher = Base64.encode(cipherData);
        // 私钥解密过程
        res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        assertNotNull(res);
        resStr = new String(res);
    }

    @Test
    public void priEncryptPubDecrypt() throws Exception {
        plainText = "stone_私钥加密公钥解密";
        // 私钥加密过程
        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), plainText.getBytes());
        cipher = Base64.encode(cipherData);
        // 公钥解密过程
        res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        assertNotNull(res);
        resStr = new String(res);
    }

}