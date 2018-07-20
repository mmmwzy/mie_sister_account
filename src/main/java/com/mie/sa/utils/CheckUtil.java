package com.mie.sa.utils;

import com.mie.base.core.exception.CommonException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WangRicky on 2018/7/20.
 */
public class CheckUtil {

    public static void isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            throw new CommonException("手机号应为11位数");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                throw new CommonException("请输入正确的手机号");
            }
        }
    }
}
