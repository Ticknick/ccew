package com.system.ccew.entity;

import com.google.gson.Gson;

import javax.persistence.*;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Entity
@Table(name = "administrator", schema = "huangniuonline", catalog = "")
public class AdminEntity {
    private int adminid;
    private String tel;
    private String nickname;
    private String mail;
    private String password;
    private String admingroup;
    private String empoyeeid;

    @Id
    @Column(name = "adminid")
    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "admingroup")
    public String getAdmingroup() {
        return admingroup;
    }

    public void setAdmingroup(String admingroup) {
        this.admingroup = admingroup;
    }

    @Basic
    @Column(name = "empoyeeid")
    public String getEmpoyeeid() {
        return empoyeeid;
    }

    public void setEmpoyeeid(String empoyeeid) {
        this.empoyeeid = empoyeeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (adminid != that.adminid) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (admingroup != null ? !admingroup.equals(that.admingroup) : that.admingroup != null) return false;
        if (empoyeeid != null ? !empoyeeid.equals(that.empoyeeid) : that.empoyeeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminid;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (admingroup != null ? admingroup.hashCode() : 0);
        result = 31 * result + (empoyeeid != null ? empoyeeid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
