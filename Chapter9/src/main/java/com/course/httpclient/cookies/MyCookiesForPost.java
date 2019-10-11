package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //    用来存储cookies信息的变量
    private CookieStore store;


    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {

        String result;
        String uri = this.url + bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(uri);
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());

        System.out.println(result);

//        获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie name = "+name+";Cookie value = "+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;

        DefaultHttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost(testUrl);

        JSONObject param = new JSONObject();

        param.put("name","Jun");
        param.put("age","18");

        post.setHeader("Content-Type","appliaction/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        String result;

        client.setCookieStore(this.store);
        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());

        System.out.println(result);

        JSONObject resultjson = new JSONObject(result);

        String success = (String) resultjson.get("jun");
        String status = (String) resultjson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
