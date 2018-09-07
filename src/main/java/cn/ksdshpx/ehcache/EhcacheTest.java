package cn.ksdshpx.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/7
 * Time: 11:25
 * Description:Ehcache缓存框架
 */
public class EhcacheTest {
    @Test
    public void test(){
        CacheManager cacheManager = CacheManager.create(this.getClass().getClassLoader().getResourceAsStream("ehcache.xml"));
        Cache cache = cacheManager.getCache("User");
        Element element = new Element("java","itcast");
        cache.put(element);
        Element javaEle = cache.get("java");
        System.out.println(javaEle.getObjectValue());
        cache.flush();
        cacheManager.shutdown();
    }
}
