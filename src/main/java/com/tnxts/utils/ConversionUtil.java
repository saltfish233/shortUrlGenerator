package com.tnxts.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 10进制、62进制互转，字符串转16进制
 */
public class ConversionUtil {
    /**
     * 初始化 62 进制数据，索引位置代表字符的数值，比如 A代表10，z代表61等
     */
    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int scale = 62;

    /**
     * 将数字转为62进制
     *
     * @param num    Long 型数字
     * @return 62进制字符串
     */
    public static String longToStr62(long num) {
        StringBuilder sb = new StringBuilder();
        int remainder;

        while (num > scale - 1) {
            /*
             * 对 scale 进行求余，然后将余数追加至 sb 中，由于是从末位开始追加的，因此最后需要反转（reverse）字符串
             */
            remainder = Long.valueOf(num % scale).intValue();
            sb.append(chars.charAt(remainder));

            num = num / scale;
        }

        sb.append(chars.charAt(Long.valueOf(num).intValue()));
        return sb.reverse().toString();//StringUtils.leftPad(value, length, '0');
    }

    /**
     * 62进制字符串转为数字
     *
     * @param str 编码后的62进制字符串
     * @return 解码后的 10 进制字符串
     */
    public static long Str62ToLong(String str) {
        /*
         * 将 0 开头的字符串进行替换
         */
        str = str.replace("^0*", "");
        long num = 0;
        int index;
        for (int i = 0; i < str.length(); i++) {
            /*
             * 查找字符的索引位置
             */
            index = chars.indexOf(str.charAt(i));
            /*
             * 索引位置代表字符的数值
             */
            num += (long) (index * (Math.pow(scale, str.length() - i - 1)));
        }

        return num;
    }

    /**
     * 字符串转16进制
     *
     * @param str 任意要编码的字符串
     * @return 转换后的16进制字符串
     */
    public static String strTo16(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            String charToHex = Integer.toHexString(c);
            stringBuilder.append(charToHex);
        }
        return stringBuilder.toString();
    }
}

