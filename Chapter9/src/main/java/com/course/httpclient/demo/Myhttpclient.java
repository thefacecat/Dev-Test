package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Myhttpclient {


    @Test
    public void test() throws IOException {

        //存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
//       这个是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
//        ctrl+q查看返回对象类型
        HttpResponse response = client.execute(get);
//        获取所有响应内容
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
