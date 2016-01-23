package org.lohas.bf.dao.mongomodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by fule https:github.com/lohasle on 2016/1/23 0023.
 * api 统计
 */
@Document(collection = "api_statistics")
public class ApiStatisticsModel {

    @Id
    private String id;

    /**
     * 接口地址
     */
    private String url;

    /**
     * ip
     */
    private String ip;

    /**
     * ua
     */
    private String ua;

    /**
     * 相应时间
     */
    private Long repTime;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRepTime() {
        return repTime;
    }

    public void setRepTime(Long repTime) {
        this.repTime = repTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
