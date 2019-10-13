package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RealMyGet01 {

    private ResourceBundle bundle;
    private CookieStore store;
    private String url;


    @BeforeTest
    public void beforeTest(){
        this.bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void getCookies() throws IOException {
        String postUrl = url + bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(postUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String res = EntityUtils.toString(response.getEntity());

        System.out.println(res);
        store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
//        System.out.println(cookieList.get(0));
        for(Cookie cookie: cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:"+name+"\nvalue:"+value);
        }
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(testUrl);
        CookieStore cookie = this.store;
        client.setCookieStore(cookie);
        HttpResponse response = client.execute(get);
        int status = response.getStatusLine().getStatusCode();
        if (status==200){
            String rs = EntityUtils.toString(response.getEntity());
            System.out.println(rs);
        }
    }
}
