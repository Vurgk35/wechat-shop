package cn.blbsz.shop.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lenovo on 2017/3/28.
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private Long code;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "none"))
    private UserEntity parent;
    private Integer leftId;
    private Integer rightId;
    private Integer level;
    private String nickName;
    private String headImgUrl;
    private String weixinCode;
    private String pstr;
    private Integer flag;
    private Integer flagId;
    private String daiCode;
    private Integer dTypeId;
    private String sex;
    private String email;
    private String qq;
    private String mobile;
    private String tel;
    private String trueName;
    private String provice;
    private String city;
    private String eare;
    private String street;
    private String addr;
    private Integer areaId;
    private Date setDate;
    private Date loginTime;
    private BigDecimal allMoney;
    private BigDecimal nowMoney;
    private BigDecimal liveMoney;
    private BigDecimal linMoney;
    private BigDecimal allPoint;
    private BigDecimal nowPoint;
    private BigDecimal livePoint;
    private BigDecimal linPoint;
    private BigDecimal givePoint;
    private BigDecimal allJian;
    private BigDecimal nowJian;
    private BigDecimal liveJian;
    private BigDecimal linJian;
    private Integer allCustomCoupon;
    private Integer customCoupon;
    private Integer pv;
    private String ip;
    private String firstUrl;
    private String correctingMsg;
    private Byte isBuy;
    private Integer fenStatus;
    private Date lastAttention;
    private BigDecimal allRecharges;
    private BigDecimal nowRecharges;
    private String wxCode;
    private String unionId;
    private BigDecimal orderCompleteGivePoint;
    private String loginName;
    private String password;
    private Byte isReg;
    private String transactionPassWord;
    private Integer isInBlacklist;
}
