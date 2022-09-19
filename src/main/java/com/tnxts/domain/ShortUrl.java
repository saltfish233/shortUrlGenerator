package com.tnxts.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("tbl_urls")
public class ShortUrl {
    private Integer id;
    private  String longUrl;
    private  String shortUrl;

    public ShortUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public ShortUrl(Integer id, String longUrl, String shortUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
