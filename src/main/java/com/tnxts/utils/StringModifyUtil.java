package com.tnxts.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringModifyUtil {

    /**
     * 获取短Url
     *
     * @param id 要转化的Id
     * @return 短Url
     */
    public static String toShortUrl(Integer id) {
        return ConversionUtil.longToStr62(id);
    }
}
