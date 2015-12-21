package org.lohas.bf.web.route;

import org.apache.commons.lang.StringUtils;

/**
 * Created by lohas on 2015/6/3.
 * https://github.com/lohasle
 * view 层 jsp 路由
 */
public class MobileViewRoute {

    /**
     * 默认版本号
     */
    public static final String DEFAULT_VERSION = "v2";

    /**
     * 默认视图  (加上默认的版本号码)
     * @param model
     * @param jspName
     * @return
     */
    public static String getDefaultView(String model, String jspName) {
        return getView(model,DEFAULT_VERSION,jspName);
    }

    /**
     * 自定义视图
     * @param model    模块名称
     * @param version  版本号码 或者 模板名称  web-inf/pages/mobile/***.jsp （默认试图）
     *                 web-inf/pages/mobile/{version}/***.jsp （主题，版本试图）
     * @param jspName  页面模板名称
     * @return
     */
    public static String getView(String model, String version, String jspName) {
        String jspUri = (StringUtils.isBlank(model)?"":model+"/")+jspName;
        if(StringUtils.isNotBlank(version)){
            // mobile/doctor/list  v2
            return "mobile/"+version+"/"+jspUri;
        }else{
            return "mobile/"+jspUri;
        }
    }
}
