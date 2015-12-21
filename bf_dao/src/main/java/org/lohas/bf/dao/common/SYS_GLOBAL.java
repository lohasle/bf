package org.lohas.bf.dao.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: fule
 * @version: Revision 1.0.0
 * @see:
 * @创建日期:14-1-26
 * @功能说明: 封装属性配置器  添加取得属性值的方法
 * 获得系统配置信息
 */
public class SYS_GLOBAL extends PropertyPlaceholderConfigurer {
    private Logger logger = LoggerFactory.getLogger(SYS_GLOBAL.class);

    private static Map<String, String> ctxPropertiesMap;

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        logger.info("---加载系统配置信息BEGIN---");
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
            logger.info("read value:"+keyStr+":"+value);
        }
        logger.info("---加载系统配置信息END---");
    }

    public static String getConfig(String name) {
        return ctxPropertiesMap.get(name);
    }
}
