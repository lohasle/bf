package org.lohas.bf.dao.mongomodels.morphia;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * Created by fule https:github.com/lohasle on 2016/1/14 0014.
 * 用户中心用户对象
 */
@Entity(noClassnameStored = true)
public class UserMo {

    @Id
    private String id;


    @Reference
    private List<UserMoLogs> userLogs;


    @Embedded
    private List inner;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserMoLogs> getUserLogses() {
        return userLogs;
    }

    public void setUserLogses(List<UserMoLogs> userLogses) {
        this.userLogs = userLogses;
    }

    public List getInner() {
        return inner;
    }

    public void setInner(List inner) {
        this.inner = inner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

