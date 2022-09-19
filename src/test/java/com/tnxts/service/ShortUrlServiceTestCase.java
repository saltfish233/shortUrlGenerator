package com.tnxts.service;

import com.tnxts.domain.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortUrlServiceTestCase {
    @Autowired
    private ShortUrlService shortUrlService;

    @Test
    public void testGetById()
    {
        //System.out.println(shortUrlService.getById(1));
        ShortUrl su = new ShortUrl("dasdsadasda我是");
        System.out.println();
    }

    @Test
    public void testGetLastId()
    {
        //System.out.println(shortUrlService.getLastId());
    }
    @Test
    public void testStrToHex()
    {
        System.out.println(Integer.toHexString(849814));
    }

}
