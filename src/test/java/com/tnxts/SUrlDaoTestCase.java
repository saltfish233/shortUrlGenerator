package com.tnxts;

import com.tnxts.dao.ShortUrlDao;
import com.tnxts.utils.ConversionUtil;
import com.tnxts.utils.StringModifyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SUrlDaoTestCase {
    @Autowired
    private ShortUrlDao shortUrlDao;

    @Test
    void testGetById()
    {
        //System.out.println(shortUrlDao.selectById(1));
        System.out.println(ConversionUtil.strTo16("我是一个sb"));
    }
}
