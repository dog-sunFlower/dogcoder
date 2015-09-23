package com.rl.utils;


import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
/**
 * Created by guodongdong on 2015/9/10.
 */
public class CommonPropertyUtils {
    private static String FILE_NAME = "common.properties";
    private static Properties properties = null;
    private static byte[] lock = new byte[0];
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonPropertyUtils.class);

    private CommonPropertyUtils(){
        LOGGER.info("[CommonPropertyUtils.instance][begin]");
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
            if (properties == null) {
                synchronized (lock) {
                    properties = new Properties();
                }
            }
            properties.load(inputStream);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("[CommonPropertyUtils.instance][end]");
    }
    public static CommonPropertyUtils getInstance(){
        return CommonPropertyUtilsHolder.INSTANCE;
    }
    private static final class  CommonPropertyUtilsHolder{
        private static final CommonPropertyUtils INSTANCE = new CommonPropertyUtils();
    }

    public Object getPropertyValue(String key){
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(CommonPropertyUtils.getInstance().getPropertyValue("client_tag"));
    }
}
