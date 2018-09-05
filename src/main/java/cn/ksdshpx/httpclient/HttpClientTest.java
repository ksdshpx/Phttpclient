package cn.ksdshpx.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/5
 * Time: 19:23
 * Description:HttpClient简介
 */
public class HttpClientTest {
    @Test
    public void test() {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        try {
            //获取HttpClient客户端
            httpClient = HttpClients.createDefault();
            //创建HttpGet
            httpGet = new HttpGet("https://www.tuicool.com");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0)");
            //执行
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            System.out.println("StatusCode:" + httpResponse.getStatusLine().getStatusCode());
            //返回HttpEntity
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(httpEntity.getContentType().getName() + ":" + httpEntity.getContentType().getValue());
            System.out.println(EntityUtils.toString(httpEntity, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
