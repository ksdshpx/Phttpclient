package cn.ksdshpx.jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/6
 * Time: 14:17
 * Description:Jsoup的使用
 */
public class JsoupTest {
    @Test
    public void test() {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse httpResponse = null;
        try {
            //获取HttpClient客户端
            httpClient = HttpClients.createDefault();
            //创建HttpGet
            httpGet = new HttpGet("https://www.cnblogs.com/");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0)");
            //执行
            httpResponse = httpClient.execute(httpGet);
            //返回HttpEntity
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity, "UTF-8");
            Document document = Jsoup.parse(content);
            Elements elements = document.getElementsByTag("title");
            Element element = elements.get(0);
            System.out.println("title:" + element.text());
            element = document.getElementById("site_nav_top");
            System.out.println("口号:" + element.text());
            System.out.println("==============================================");
            Elements itemElements = document.getElementsByClass("post_item");
            for (Element itemElement : itemElements) {
                System.out.println(itemElement.html());
                System.out.println("+++++++++++++++++++++++++++++++");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
