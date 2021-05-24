package cn.blbsz.shop.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lenovo on 2017/3/28.
 */
@Entity
@Table(name = "User_101322", schema = "dbo", catalog = "winmob3")
public class UserEntity {
    private Integer userId;
    private Integer custId;
    private String nickname;
    private String headimgurl;
    private String weixincode;
    private String pstr;
    private Integer flag;
    private Integer flagId;
    private String daicode;
    private Integer dTypeid;
    private String sex;
    private String email;
    private String qq;
    private String mobile;
    private String tel;
    private String truename;
    private String provice;
    private String city;
    private String eare;
    private String street;
    private String addr;
    private Integer areaId;
    private String code;
    private Date setdate;
    private Date logintime;
    private BigDecimal allmoney;
    private BigDecimal nowmoney;
    private BigDecimal livemoney;
    private BigDecimal linmoney;
    private BigDecimal allpoint;
    private BigDecimal nowpoint;
    private BigDecimal livePoint;
    private BigDecimal linpoint;
    private BigDecimal givePoint;
    private BigDecimal alljian;
    private BigDecimal nowjian;
    private BigDecimal liveJian;
    private BigDecimal linjian;
    private Integer allCustomCoupon;
    private Integer customCoupon;
    private Integer pv;
    private String ip;
    private Integer pid2;
    private String firstUrl;
    private String correctingMsg;
    private Byte isBuy;
    private Integer fenstatus;
    private Date lastAttention;
    private BigDecimal allRecharges;
    private BigDecimal nowRecharges;
    private String wxCode;
    private String unionId;
    private BigDecimal orderCompleteGivePoint;
    private String loginName;
    private String passWord;
    private Byte isReg;
    private String transactionPassWord;
    private Integer isInBlacklist;
    private UserEntity parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "none"))
    public UserEntity getParent() {
        return parent;
    }

    public void setParent(UserEntity parent) {
        this.parent = parent;
    }

    @Id
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "custID")
    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
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
    @Column(name = "headimgurl")
    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    @Basic
    @Column(name = "weixincode")
    public String getWeixincode() {
        return weixincode;
    }

    public void setWeixincode(String weixincode) {
        this.weixincode = weixincode;
    }

    @Basic
    @Column(name = "pstr")
    public String getPstr() {
        return pstr;
    }

    public void setPstr(String pstr) {
        this.pstr = pstr;
    }

    @Basic
    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "flagID")
    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    @Basic
    @Column(name = "daicode")
    public String getDaicode() {
        return daicode;
    }

    public void setDaicode(String daicode) {
        this.daicode = daicode;
    }

    @Basic
    @Column(name = "dTypeid")
    public Integer getdTypeid() {
        return dTypeid;
    }

    public void setdTypeid(Integer dTypeid) {
        this.dTypeid = dTypeid;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    @Column(name = "truename")
    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    @Basic
    @Column(name = "provice")
    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "eare")
    public String getEare() {
        return eare;
    }

    public void setEare(String eare) {
        this.eare = eare;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "areaID")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "setdate")
    public Date getSetdate() {
        return setdate;
    }

    public void setSetdate(Date setdate) {
        this.setdate = setdate;
    }

    @Basic
    @Column(name = "logintime")
    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "allmoney")
    public BigDecimal getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(BigDecimal allmoney) {
        this.allmoney = allmoney;
    }

    @Basic
    @Column(name = "nowmoney")
    public BigDecimal getNowmoney() {
        return nowmoney;
    }

    public void setNowmoney(BigDecimal nowmoney) {
        this.nowmoney = nowmoney;
    }

    @Basic
    @Column(name = "livemoney")
    public BigDecimal getLivemoney() {
        return livemoney;
    }

    public void setLivemoney(BigDecimal livemoney) {
        this.livemoney = livemoney;
    }

    @Basic
    @Column(name = "linmoney")
    public BigDecimal getLinmoney() {
        return linmoney;
    }

    public void setLinmoney(BigDecimal linmoney) {
        this.linmoney = linmoney;
    }

    @Basic
    @Column(name = "allpoint")
    public BigDecimal getAllpoint() {
        return allpoint;
    }

    public void setAllpoint(BigDecimal allpoint) {
        this.allpoint = allpoint;
    }

    @Basic
    @Column(name = "nowpoint")
    public BigDecimal getNowpoint() {
        return nowpoint;
    }

    public void setNowpoint(BigDecimal nowpoint) {
        this.nowpoint = nowpoint;
    }

    @Basic
    @Column(name = "LivePoint")
    public BigDecimal getLivePoint() {
        return livePoint;
    }

    public void setLivePoint(BigDecimal livePoint) {
        this.livePoint = livePoint;
    }

    @Basic
    @Column(name = "linpoint")
    public BigDecimal getLinpoint() {
        return linpoint;
    }

    public void setLinpoint(BigDecimal linpoint) {
        this.linpoint = linpoint;
    }

    @Basic
    @Column(name = "GivePoint")
    public BigDecimal getGivePoint() {
        return givePoint;
    }

    public void setGivePoint(BigDecimal givePoint) {
        this.givePoint = givePoint;
    }

    @Basic
    @Column(name = "alljian")
    public BigDecimal getAlljian() {
        return alljian;
    }

    public void setAlljian(BigDecimal alljian) {
        this.alljian = alljian;
    }

    @Basic
    @Column(name = "nowjian")
    public BigDecimal getNowjian() {
        return nowjian;
    }

    public void setNowjian(BigDecimal nowjian) {
        this.nowjian = nowjian;
    }

    @Basic
    @Column(name = "LiveJian")
    public BigDecimal getLiveJian() {
        return liveJian;
    }

    public void setLiveJian(BigDecimal liveJian) {
        this.liveJian = liveJian;
    }

    @Basic
    @Column(name = "linjian")
    public BigDecimal getLinjian() {
        return linjian;
    }

    public void setLinjian(BigDecimal linjian) {
        this.linjian = linjian;
    }

    @Basic
    @Column(name = "AllCustomCoupon")
    public Integer getAllCustomCoupon() {
        return allCustomCoupon;
    }

    public void setAllCustomCoupon(Integer allCustomCoupon) {
        this.allCustomCoupon = allCustomCoupon;
    }

    @Basic
    @Column(name = "CustomCoupon")
    public Integer getCustomCoupon() {
        return customCoupon;
    }

    public void setCustomCoupon(Integer customCoupon) {
        this.customCoupon = customCoupon;
    }

    @Basic
    @Column(name = "PV")
    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "pid2")
    public Integer getPid2() {
        return pid2;
    }

    public void setPid2(Integer pid2) {
        this.pid2 = pid2;
    }

    @Basic
    @Column(name = "FirstUrl")
    public String getFirstUrl() {
        return firstUrl;
    }

    public void setFirstUrl(String firstUrl) {
        this.firstUrl = firstUrl;
    }

    @Basic
    @Column(name = "CorrectingMsg")
    public String getCorrectingMsg() {
        return correctingMsg;
    }

    public void setCorrectingMsg(String correctingMsg) {
        this.correctingMsg = correctingMsg;
    }

    @Basic
    @Column(name = "IsBuy")
    public Byte getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Byte isBuy) {
        this.isBuy = isBuy;
    }

    @Basic
    @Column(name = "fenstatus")
    public Integer getFenstatus() {
        return fenstatus;
    }

    public void setFenstatus(Integer fenstatus) {
        this.fenstatus = fenstatus;
    }

    @Basic
    @Column(name = "LastAttention")
    public Date getLastAttention() {
        return lastAttention;
    }

    public void setLastAttention(Date lastAttention) {
        this.lastAttention = lastAttention;
    }

    @Basic
    @Column(name = "AllRecharges")
    public BigDecimal getAllRecharges() {
        return allRecharges;
    }

    public void setAllRecharges(BigDecimal allRecharges) {
        this.allRecharges = allRecharges;
    }

    @Basic
    @Column(name = "NowRecharges")
    public BigDecimal getNowRecharges() {
        return nowRecharges;
    }

    public void setNowRecharges(BigDecimal nowRecharges) {
        this.nowRecharges = nowRecharges;
    }

    @Basic
    @Column(name = "WX_Code")
    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    @Basic
    @Column(name = "UnionID")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Basic
    @Column(name = "OrderCompleteGivePoint")
    public BigDecimal getOrderCompleteGivePoint() {
        return orderCompleteGivePoint;
    }

    public void setOrderCompleteGivePoint(BigDecimal orderCompleteGivePoint) {
        this.orderCompleteGivePoint = orderCompleteGivePoint;
    }

    @Basic
    @Column(name = "LoginName")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "PassWord")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "IsReg")
    public Byte getIsReg() {
        return isReg;
    }

    public void setIsReg(Byte isReg) {
        this.isReg = isReg;
    }

    @Basic
    @Column(name = "TransactionPassWord")
    public String getTransactionPassWord() {
        return transactionPassWord;
    }

    public void setTransactionPassWord(String transactionPassWord) {
        this.transactionPassWord = transactionPassWord;
    }

    @Basic
    @Column(name = "IsInBlacklist")
    public Integer getIsInBlacklist() {
        return isInBlacklist;
    }

    public void setIsInBlacklist(Integer isInBlacklist) {
        this.isInBlacklist = isInBlacklist;
    }

}
