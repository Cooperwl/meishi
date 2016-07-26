package com.meishi.common.security;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * MD5加密, 返回32个字符的加密串
 * @author fangyi
 */
public class MD5 {
	public static final String DEFAULT_CHARSET = "utf-8";
	
	
	/**
	 * MD5加密字符串, 字符集为utf-8
	 * @param text
	 * @return  32位字符
	 */
	public static String sign(String text) {
		return sign(text, DEFAULT_CHARSET);
	}
	
	/**
	 * MD5加密字符串, 指定字符串字符集 
	 * @param text 待加密字符串
	 * @param charset 字符串字符集
	 * @return
	 */
	public static String sign(String text, String charset) {
		return sign(text, "", charset);
	}
	
	
    /**
     * 对text + key进行md5加密
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String charset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, charset));
    }
    

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
}