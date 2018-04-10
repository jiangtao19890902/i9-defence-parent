package i9.defence.platform.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/** 
 * 创建时间：2017年11月16日 下午5:07:21
 * @author  lby
 * @version  
 * 
 */
public class StringUtil {
    public static String MD5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }
    
    public static String dateToString(Date date){
        if (date != null) {
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdm.format(date);
        }else {
            return "";
        }
        
    }
    
    public static String dateToStringByRep(Date date,String rep){
        if (date != null) {
            SimpleDateFormat sdm = new SimpleDateFormat(rep);
            return sdm.format(date);
        }else {
            return "";
        }
    }
    /**
     * 日期转换
     * @param date
     * @return
     */
    public static String dateToStringWithoutTime(Date date) {
        if (null != date) {
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");
            return sdm.format(date);
        } else {
            return "";
        }
    }
    
    /**
     * 时间转日期
     * @param endDateString
     * @param string
     * @return
     */
	public static Date stringToDateByRep(String endDateString, String rep) {
		if (StringUtils.isNotBlank(endDateString)) {
            SimpleDateFormat sdm = new SimpleDateFormat(rep);
            try {
				return sdm.parse(endDateString);
			} catch (ParseException e) {
				return null;
			}
        }else {
            return null;
        }
	}
}
