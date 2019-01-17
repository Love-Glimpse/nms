package com.kuaidu.nms;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.utils.OsInfo;
import com.kuaidu.nms.utils.Utils;

public class DesTest {
    // 算法名称/加密模式/填充方式    
    public static final String CIPHER_ALGORITHM_ECB = "DES/ECB/ZeroBytePadding";  
    public static void main(String[] args) throws Exception {    
        /*  
         * 使用 ECB mode  
         * 密钥生成器 生成密钥  
         * ECB mode cannot use IV  
         */    
        byte[] key = "12345678".getBytes();     
        byte[] encrypt = encrypt("你好大大".getBytes(),key); 
        String encodeBase64String = Base64.encodeBase64String(encrypt);
        System.out.println(encodeBase64String);
        System.out.println(new String(decrypt(encrypt, key)));                  
/*    	System.out.println(Config.PIC_PATH);
    	System.out.println(Config.CHAPTER_PATH);
    	System.out.println(Config.TEM_PATH);*/
/*    	String imgUrl = "http://a.hiphotos.baidu.com/image/h%3D300/sign=1d071b503501213fd03348dc64e636f8/fc1f4134970a304eb5088f73ddc8a786c9175c14.jpg";
		String fileName = Utils.getNameFromUrl(imgUrl);
		System.out.println(fileName);
		//传值（网络url,文件名，文件路径）
		System.out.println(Utils.downloadFile(imgUrl,Config.PIC_PATH,fileName));*/
		//String url = "http://192.168.1.131:80/group1/M00/00/00/wKgBg1s01zyIY3hyAAAgH5KnhNoAAAAAQHMcwAAACA3618.jpg?dsd=dadad";

		//System.out.println(Utils.getNameFromUrl(url));
    }    
        
	//加密算是是des
    private static final String ALGORITHM = "DES";
    //转换格式
    private static final String TRANSFORMATION = "DES/ECB/PKCS5Padding";

    //利用8个字节64位的key给src加密
    public static byte[] encrypt(byte[] src,byte[]key)
    {
        try {
            //加密
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,new SecureRandom());
            byte[] enMsgBytes = cipher.doFinal(src);    
            return enMsgBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //利用8个字节64位的key给src解密
    public static byte[] decrypt(byte[] encryptBytes,byte[]key){
        try {
            //解密
            //Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            Cipher deCipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeyFactory deDecretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            KeySpec deKeySpec = new DESKeySpec(key);
            SecretKey deSecretKey = deDecretKeyFactory.generateSecret(deKeySpec);
            deCipher.init(Cipher.DECRYPT_MODE, deSecretKey,new SecureRandom());
            byte[] deMsgBytes = deCipher.doFinal(encryptBytes);
            return deMsgBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
