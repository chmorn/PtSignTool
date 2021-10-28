package com.chmorn.utils;

import com.chmorn.config.GlobalConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @description 自动签到
 * @date 2021/9/11
 **/
public class SignUtil {

    private static Logger logger = LoggerFactory.getLogger(SignUtil.class);
    private static final String path = System.getProperty("user.dir");

    private GlobalConfig globalConfig;

    public SignUtil(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    public static void main(String[] args) {

    }

    //TTG签到
    public void signTtg() {
        String url = globalConfig.getTtg();
        String cookie = "";
        String cookiefile = path + File.separator + "ttg.cookie";
        try (BufferedReader br = new BufferedReader(new FileReader(cookiefile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cookie += line.trim();
            }
            Document res = getJsoupConn(url,cookie);
            logger.info(res.html());
        } catch (IOException e) {
            logger.info("TTG签到失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    //HDC签到
    public void signHdc() {
        String url = globalConfig.getHdc();
        String cookie = "";
        String cookiefile = path + File.separator + "hdc.cookie";
        try (BufferedReader br = new BufferedReader(new FileReader(cookiefile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cookie += line.trim();
            }
            Document res = getJsoupConn(url,cookie);
            logger.info(res.html());
        } catch (IOException e) {
            logger.info("HDC签到失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    //PTTime签到
    public void signTime() {
        String url = globalConfig.getTime();
        String cookie = "";
        String cookiefile = path + File.separator + "time.cookie";
        try (BufferedReader br = new BufferedReader(new FileReader(cookiefile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cookie += line.trim();
            }
            Document res = getJsoupConn(url,cookie);
            logger.info(res.html());
        } catch (IOException e) {
            logger.info("PTTime签到失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    //Hares签到
    public void signHares() {
        String url = globalConfig.getHares();
        String cookie = "";
        String cookiefile = path + File.separator + "hares.cookie";
        try (BufferedReader br = new BufferedReader(new FileReader(cookiefile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cookie += line.trim();
            }
            Document res = getJsoupConn(url,cookie);
            logger.info(res.html());
        } catch (IOException e) {
            logger.info("Hares签到失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    //Lemon签到
    public void signLemon() {
        String url = globalConfig.getLemon();
        String cookie = "";
        String cookiefile = path + File.separator + "lemon.cookie";
        try (BufferedReader br = new BufferedReader(new FileReader(cookiefile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cookie += line.trim();
            }
            Document res = getJsoupConn(url,cookie);
            logger.info(res.html());
        } catch (IOException e) {
            logger.info("Lemon签到失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized Document getJsoupConn(String url, String cookie) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        headers.put("Cookie", cookie);
        Document res = null;
        try {
            res = Jsoup.connect(url).headers(headers).ignoreContentType(true).get();
        } catch (IOException e) {
            logger.info("连接失败：" + url);
            //e.printStackTrace();
        }
        //String body = res.body().html();
        return res;
    }


}
