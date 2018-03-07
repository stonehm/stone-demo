package com.stone.rsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * RSA签名验签测试
 * Created by Stone on 2016/12/21.
 */
public class RSASignatureTest {

    private String content;
    private String signStr;
    private String filepath;

    @Before
    public void before() {
        URL url = this.getClass().getClassLoader().getResource("");
        assertNotNull(url);
        String file = url.getFile();
        filepath = new File(file).getAbsolutePath();
    }

    @After
    public void verify() throws Exception {
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signStr);
        System.out.println("验签结果：" + RSASignature.verify(content, signStr, RSAEncrypt.loadPublicKeyByFile(filepath)));
    }

    @Test
    public void genKeyPair() throws Exception {
        RSAEncrypt.genKeyPair(filepath);
    }

    @Test
    public void sign() throws Exception {
        content = "stone_这是用于签名的原始数据";
        signStr = RSASignature.sign(content, RSAEncrypt.loadPrivateKeyByFile(filepath));
    }

}