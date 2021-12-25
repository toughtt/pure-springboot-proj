package org.example.client;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;

import java.util.Map;

public interface MyClient {

    /**
     * 本地测试接口
     */
    @Get(url = "http://127.0.0.1:80/demo/index")
    String index();

    @Get(url = "http://127.0.0.1:80/demo/hello?msg=${msg}")
    String hello(@DataVariable("msg") String msg);

    /**
     * 高德地图API
     */
    @Get(url = "http://ditu.amap.com/service/regeo?longitude=${longitude}&latitude=${latitude}")
    Map getLocation(@DataVariable("longitude") String longitude, @DataVariable("latitude") String latitude);

    @Get(url = "https://yasinshaw.com/articles/86")
    Object httpsTest();
}

