package com.tnxts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tnxts.dao.ShortUrlDao;
import com.tnxts.domain.ShortUrl;
import com.tnxts.service.ShortUrlService;
import com.tnxts.utils.ConversionUtil;
import com.tnxts.utils.StringModifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class ShortUrlServiceImpl extends ServiceImpl<ShortUrlDao, ShortUrl> implements ShortUrlService {

    @Autowired
    private ShortUrlDao dao;
    /**
     * 获取短url
     *
     * @return 短url
     */
    public String getShortUrl(ShortUrl urlInfo) {
        try{
            if(urlInfo.getLongUrl().isEmpty())
            {
                return "";
            }
            int id = getLastId() + 1;
            String shortUrl = StringModifyUtil.toShortUrl(id);
            if(shortUrl.isEmpty())
            {
                return "";
            }
            ShortUrl url = new ShortUrl();
            url.setId(id);
            url.setShortUrl(shortUrl);
            url.setLongUrl(urlInfo.getLongUrl());

            if(dao.insert(url) <= 0)
            {
                return "";
            }
            return shortUrl;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * 重定向到目标地址
     *
     * @param shortUrl 短链接
     * @return ModelAndView
     */
    public ModelAndView redirectToLongUrl(String shortUrl)
    {
       long id = ConversionUtil.Str62ToLong(shortUrl);
        ShortUrl url =  dao.selectById(id);
        String longUrl = url.getLongUrl();
        if(longUrl.contains("http://") || longUrl.contains("https://"))
        {
            return new ModelAndView("redirect:" + longUrl);
        }
        else
        {
            return new ModelAndView("redirect:" + "http://" + longUrl);
        }
    }

    /**
     * 获取最后一条数据的id
     *
     * @return Id
     */
    private Integer getLastId(){
        QueryWrapper<ShortUrl> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().orderByDesc("id");
        return this.list(queryWrapper).get(0).getId();
    }
}
