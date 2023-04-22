package com.yanshang.watchpro.utils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

public class RequestUtils {

    /**
     * 发送post请求
     * @param url 地址
     * @param parameter 参数
     * @return
     */
    public static JSONObject sendPost(String url, MultiValueMap<String, String> parameter) {
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameter, headers);
        // 执行HTTP请求，将返回的结构使用JSONObject类格式化
        ResponseEntity<String> result = client.exchange(url, method, requestEntity, String.class);
        return JSONObject.parseObject(result.getBody());
    }
    /**
     * 发送post请求
     * @param url 地址
     * @param parameter 参数
     * @return
     */
    public static JSONObject GetMsg(String url, MultiValueMap<String, String> parameter) {
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));
        HttpMethod method = HttpMethod.GET;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameter, headers);
        // 执行HTTP请求，将返回的结构使用JSONObject类格式化
        ResponseEntity<String> result = client.exchange(url, method, requestEntity, String.class);
        return JSONObject.parseObject(result.getBody());
    }

}