package com.system.ccew.entity;

import com.google.gson.Gson;

import javax.persistence.*;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Entity
@Table(name = "message", schema = "caffeine", catalog = "")
public class MessageEntity {
    private int messageid;
    private int admin;
    private String usergruop;
    private Integer userid;
    private String title;
    private String messtype;
    private String content;

    @Id
    @Column(name = "messageid")
    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    @Basic
    @Column(name = "admin")
    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Basic
    @Column(name = "usergruop")
    public String getUsergruop() {
        return usergruop;
    }

    public void setUsergruop(String usergruop) {
        this.usergruop = usergruop;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "messtype")
    public String getMesstype() {
        return messtype;
    }

    public void setMesstype(String messtype) {
        this.messtype = messtype;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (messageid != that.messageid) return false;
        if (admin != that.admin) return false;
        if (usergruop != null ? !usergruop.equals(that.usergruop) : that.usergruop != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (messtype != null ? !messtype.equals(that.messtype) : that.messtype != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageid;
        result = 31 * result + admin;
        result = 31 * result + (usergruop != null ? usergruop.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (messtype != null ? messtype.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
