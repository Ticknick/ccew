package com.system.ccew.entity;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Entity
@Table(name = "orders", schema = "caffeine", catalog = "")
public class OrderEntity {
    private String id;
    private String user;
    private String bidid;
    private String idcard;
    private String transactionPassword;
    private String state;
    private String remark;



    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "bidid")
    public String getBidid() {
        return bidid;
    }

    public void setBidid(String bidid) {
        this.bidid = bidid;
    }

    @Basic
    @Column(name = "idcard")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "transaction_password")
    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (bidid != null ? !bidid.equals(that.bidid) : that.bidid != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;
        if (transactionPassword != null ? !transactionPassword.equals(that.transactionPassword) : that.transactionPassword != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return remark != null ? remark.equals(that.remark) : that.remark == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (bidid != null ? bidid.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (transactionPassword != null ? transactionPassword.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
