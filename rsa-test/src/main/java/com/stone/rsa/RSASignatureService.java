package com.stone.rsa;

import com.stone.util.Base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSASignatureService {
    static private final String SIGN_ALGORITHMS = "SHA1WithRSA";
    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    public RSASignatureService() {

    }

    public static void main(String[] args) throws FileNotFoundException,
            Exception {
        RSASignatureService ser = new RSASignatureService();
        ser.setPrivateKey(new FileInputStream("E:/private_key_pkcs8.pem"));
        String sign = ser.sign("哈哈");
        // System.out.println(sign);
        // ser.setPublicKey(new FileInputStream("E:/public_key.pem"));//设置公钥
        ser.setPublicDer(new FileInputStream("E:/public.der"));// 设置公钥证书
        System.out.println(ser.verify(sign, "哈哈"));// 验签
        String s = ser.encrpt("哈哈");
        System.out.println(ser.decrypt(s));// 公钥解密
    }

    public String encrpt(String content) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 使用默认RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] cipherData = cipher.doFinal(content.getBytes());
        String signature = Base64.encode(cipherData);
        return signature;
    }

    public String decrypt(String sign) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 使用默认RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] output = cipher.doFinal(Base64.decode(sign));
        return new String(output);
    }

    public String sign(String content) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initSign(privateKey);
        signature.update(content.getBytes());
        byte[] signed = signature.sign();
        return Base64.encode(signed);
    }

    public boolean verify(String sign, String content)
            throws NoSuchAlgorithmException, InvalidKeyException,
            SignatureException {
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initVerify(publicKey);
        signature.update(content.getBytes());
        boolean bverify = signature.verify(Base64.decode(sign));
        return bverify;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = (FileInputStream) in;

            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPrivateKey(InputStream privateKeyResource) throws Exception {
        byte[] tmp = toByteArray(privateKeyResource);
        byte[] buffer = Base64.decode(new String(tmp));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    public void setPublicKey(InputStream publicKeyResource) throws Exception {
        byte[] tmp = toByteArray(publicKeyResource);
        byte[] buffer = Base64.decode(new String(tmp));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
        publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    public void setPublicDer(InputStream publicKeyResource) throws Exception {
        CertificateFactory of = CertificateFactory.getInstance("X.509");
        java.security.cert.Certificate ceof = of
                .generateCertificate(publicKeyResource);
        // 获取CA的公钥
        publicKey = (RSAPublicKey) ceof.getPublicKey();
    }
}