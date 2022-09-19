package com.tnxts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tnxts.domain.ShortUrl;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ShortUrlService extends IService<ShortUrl> {
    String getShortUrl(ShortUrl urlInfo);
    ModelAndView redirectToLongUrl(String shortUrl);
}
