package com.chmorn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenxu
 * @version 1.0
 * @description 读取配置文件自定义属性
 * @date 2021/10/28
 **/
@Component
@ConfigurationProperties(prefix = "website.url")
public class GlobalConfig {
    @Value("${website.url.ttg}")
    private String ttg;
    @Value("${website.url.hdc}")
    private String hdc;
    @Value("${website.url.time}")
    private String time;
    @Value("${website.url.hares}")
    private String hares;
    @Value("${website.url.lemon}")
    private String lemon;

    public String getTtg() {
        return ttg;
    }

    public void setTtg(String ttg) {
        this.ttg = ttg;
    }

    public String getHdc() {
        return hdc;
    }

    public void setHdc(String hdc) {
        this.hdc = hdc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHares() {
        return hares;
    }

    public void setHares(String hares) {
        this.hares = hares;
    }

    public String getLemon() {
        return lemon;
    }

    public void setLemon(String lemon) {
        this.lemon = lemon;
    }

    @Override
    public String toString() {
        return "GlobalConfig{" +
                "ttg='" + ttg + '\'' +
                ", hdc='" + hdc + '\'' +
                ", time='" + time + '\'' +
                ", hares='" + hares + '\'' +
                ", lemon='" + lemon + '\'' +
                '}';
    }
}
