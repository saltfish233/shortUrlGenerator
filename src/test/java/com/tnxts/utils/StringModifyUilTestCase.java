package com.tnxts.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringModifyUilTestCase {
    @Test
    public void testToShortUrl()
    {
        System.out.println(StringModifyUtil.toShortUrl(121654568));
    }
}
