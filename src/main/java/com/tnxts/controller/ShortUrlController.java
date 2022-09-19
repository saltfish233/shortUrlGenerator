package com.tnxts.controller;

import com.tnxts.controller.utils.R;
import com.tnxts.domain.ShortUrl;
import com.tnxts.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/redirect")
public class ShortUrlController {
    @Autowired
    private ShortUrlService sUrlService;

//    @GetMapping("{id}")
//    public R getById(@PathVariable Integer id)
//    {
//        return new R(true,sUrlService.getById(id));
//    }

    @GetMapping("{shortUrl}")
    public ModelAndView redirectToLongUrl(@PathVariable String shortUrl){
        return sUrlService.redirectToLongUrl(shortUrl);
    }

    @PostMapping
    public R getShortUrl(@RequestBody ShortUrl UrlInfo){
        String url = sUrlService.getShortUrl(UrlInfo) ;
        if(url.equalsIgnoreCase(""))
        {
            return new R(false,null,"generate failed!");
        }
    return new R(true,url,"generate success.");
    }
}