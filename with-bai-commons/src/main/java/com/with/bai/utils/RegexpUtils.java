package com.with.bai.utils;

public class RegexpUtils {
    /**
     * 验证手机号
     */
    public static final String PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    /**
     * 验证身份证
     */
    public static final String IDNUMBER= "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$";
    /**
     * 正浮点数
     */
    public static final String PFN="[1-9]\\d*(\\.\\d\\d?)?|0[.?]\\d\\d?|0";

    /**
     * 验证邮箱地址
     */
    public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }

    /**
     * 验证身份证
     *
     */
    public static boolean checkIdNumer(String idNumer) {
        return idNumer.matches(IDNUMBER);
    }


}
