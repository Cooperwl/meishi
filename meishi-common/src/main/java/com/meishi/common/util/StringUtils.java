package com.meishi.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * 字符串助手
 * Created by wangliang on 2016/7/8.
 */
public class StringUtils {
    private static Logger log  = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 判断字符串是否为null或是为空串（空格也算空串）
     * @param	s	要校验的字符串
     * @return	true 是，false 否
     */
    public static boolean isNullOrEmpty(String s){
        if( s==null || s.trim().length()==0 ){
            return true;
        }
        return false;
    }

    /**
     * 检查字符串是否都是数字组成,null或"" 返回false
     * @param str
     * @return 数字true,非数字false
     */
    public static boolean isNumerical(String str){
        if(isNullOrEmpty(str)){
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i);
            if (temp >= 0x0030 && temp <= 0x0039) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }



    /**
     * 名称是否合法，名称可以是 中文，英文，数字 组成，其他字符非法
     * @param name
     * @return 合法 true, 非法false
     */
    public static boolean isRightName(String name){
        if (isNullOrEmpty(name)){
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            int temp = name.charAt(i);
            if ((temp >= 0x4E00 && temp <= 0x9FA5)
                    || //中文
                    (temp >= 0x0061 && temp <= 0x007A)
                    || //小写英文
                    (temp >= 0x0041 && temp <= 0x005A)
                    || //大写英文
                    (temp >= 0x0030 && temp <= 0x0039) //数字
                    ) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isCellPhone(String s){
        if(s == null || s.length() != 11){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9'){
                return false;
            }
        }

        return true;
    }

    public static String[] split(String s, String regex){
        String[] strArray;

        if(isNullOrEmpty(s)){
            strArray = new String[1];
            strArray[0] = s;
            return strArray;
        }

        if(regex.equals(".")){
            strArray = s.split("\\.");
        }else{
            strArray = s.split(regex);
        }

        return strArray;
    }

    /**
     * 字符串相等 null和空字符串认为相等，忽略字符串前后空格
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean compareString(String str1, String str2) {
        if (null == str1) {
            str1 = "";
        }
        if (null == str2) {
            str2 = "";
        }
        if (str1.trim().equals(str2.trim())) {
            return true;
        }
        return false;
    }

    /**
     * <p>功能描述:将字符串转码</p>
     * @param str
     * @param format	源编码
     * @param newFormat	目标编码
     * @return
     * @author: WangLiang
     * @update:[2014年12月12日 下午3:06:04] WangLiang [变更描述]
     */
    public static String convertCharacterSet(String str, String format, String newFormat) {
        if (str == null) {
            return null;
        }

        try {
            return new String(str.getBytes(format), newFormat);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * <p>功能描述:将字符串转码</p>
     * @param str
     * @return
     * @author: WangLiang
     * @update:[2014年12月12日 下午3:06:04] WangLiang [变更描述]
     */
    public static String convertCharacterSet(String str) {
        if (str == null) {
            return null;
        }

        try {
            return new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String join(Collection<String> strs){
        StringBuffer t = new StringBuffer("");
        for(String s : strs){
            t.append(s).append(",");
        }
        return t.substring(0, t.length()-1).toString();
    }
}
