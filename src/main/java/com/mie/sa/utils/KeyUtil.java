package com.mie.sa.utils;

import javax.crypto.SecretKey;
import java.util.Random;

/**
 * 
* @ClassName: KeyUtil  
* @Description: TODO(随机字符帮助类)  
* @author Administrator 
* @date 2018年6月10日 上午10:15:57
*
 */
public class KeyUtil {
	
	/**
	 * 生成指定位数的随机密钥
	 * @param KeyLength 指定长度
	 * @return
	 */
	public static String KeyCreate(int KeyLength){
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
		Random random = new Random();
		StringBuffer Keysb = new StringBuffer();
		for(int i = 0; i<KeyLength; i++){
			int number = random.nextInt(base.length());
			Keysb.append(base.charAt(number));
		}
		return Keysb.toString();
	}


	
}
