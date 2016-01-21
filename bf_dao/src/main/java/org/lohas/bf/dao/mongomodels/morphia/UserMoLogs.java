package org.lohas.bf.dao.mongomodels.morphia;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by fule https:github.com/lohasle on 2016/1/14 0014.
 */
@Entity(noClassnameStored = true)
public class UserMoLogs {
    @Id
    private String id;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserMoLogs() {
    }

    public UserMoLogs(String content) {
        this.content = content;
    }
}
