package com.system.ccew.entity;

import com.google.gson.Gson;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Entity
@Table(name = "orders", schema = "caffeine", catalog = "")
public class OrderEntity {

    private int id;
    private int userId;
    private String bidid;
    private String idcard;
    private String bidid_psd;
    private OrderState state;
    private String remark;



    private UserEntity user;

    private Timestamp createTime;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Basic
    @Column(name = "userid")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    public String getBidid_psd() {
        return bidid_psd;
    }

    public void setBidid_psd(String bidid_psd) {
        this.bidid_psd = bidid_psd;
    }

    @Basic
    @Column(name = "state")
    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
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

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.DETACH, targetEntity = UserEntity.class,optional = true)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (userId != that.userId) return false;
        if (bidid != null ? !bidid.equals(that.bidid) : that.bidid != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;
        if (bidid_psd != null ? !bidid_psd.equals(that.bidid_psd) : that.bidid_psd != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return remark != null ? remark.equals(that.remark) : that.remark == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + userId;
        result = 31 * result + (bidid != null ? bidid.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (bidid_psd != null ? bidid_psd.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
