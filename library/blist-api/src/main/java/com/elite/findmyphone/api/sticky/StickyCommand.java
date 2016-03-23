package com.elite.findmyphone.api.sticky;

import java.util.List;

/**
 * Create by wjc133
 * Date: 2016/3/23
 * Time: 16:45
 */
public class StickyCommand {
    private String ticket;
    private String title;
    private List<ContentCommand> messages;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ContentCommand> getMessages() {
        return messages;
    }

    public void setMessages(List<ContentCommand> messages) {
        this.messages = messages;
    }
}
