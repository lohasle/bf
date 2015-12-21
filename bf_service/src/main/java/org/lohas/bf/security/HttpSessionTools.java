package org.lohas.bf.security;

import javax.servlet.http.HttpSession;

/**
 * Created by lohas on 2015/7/11.
 * https://github.com/lohasle
 */
public class HttpSessionTools {


    /**
     * 是否包含以下的session key
     * @param session
     * @return
     */
    public static boolean hasThisSessions(HttpSession session,String ...keys){
        for (String key:keys){
            if(session.getAttribute(key)!=null){
                return true;
            }
        }
        return false;
    }
}
