package com.elite.findmyphone.api.sticky;

import java.util.Date;
import java.util.List;

/**
 * Create by wjc133
 * Date: 2016/3/23
 * Time: 15:15
 */
public class Sticky {
    private Long uid;
    private String title;
    private Date lastModify;
    private String coverUrl;
    private List<Content> messages;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Content> getMessages() {
        return messages;
    }

    public void setMessages(List<Content> messages) {
        this.messages = messages;
    }
}
