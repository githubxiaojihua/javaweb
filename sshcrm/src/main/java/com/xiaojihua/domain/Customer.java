package com.xiaojihua.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * customer表
 */
@Entity
@Table(name="cst_customer")
public class Customer {
    @Id
    @Column(name="cust_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cust_id;// '客户编号(主键)',
    @Column(name="cust_name")
    private String cust_name;// '客户名称(公司名称)',
    @Column(name="cust_phone")
    private String cust_phone;// '固定电话',
    @Column(name="cust_mobile")
    private String cust_mobile;//'移动电话',
    public Integer getCust_id() {
        return cust_id;
    }

    //三个外键对象，多对一，对应到字典表
    @ManyToOne(targetEntity=BaseDict.class)
    @JoinColumn(name="cust_source",referencedColumnName="dict_id")
    private BaseDict cust_source;// '客户信息来源',
    @ManyToOne(targetEntity=BaseDict.class)
    @JoinColumn(name="cust_industry",referencedColumnName="dict_id")
    private BaseDict cust_industry;// '客户所属行业',
    @ManyToOne(targetEntity=BaseDict.class)
    @JoinColumn(name="cust_level",referencedColumnName="dict_id")
    private BaseDict cust_level;// '客户级别',

    //客户联系人集合，需要将集合new出来
    //mappedBy指的是在对方类中维护外键的属性名
    @OneToMany(targetEntity=Linkman.class,mappedBy="customer")
    Set<Linkman> linkmanSet = new HashSet<>();


    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public BaseDict getCust_source() {
        return cust_source;
    }

    public void setCust_source(BaseDict cust_source) {
        this.cust_source = cust_source;
    }

    public BaseDict getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(BaseDict cust_industry) {
        this.cust_industry = cust_industry;
    }

    public BaseDict getCust_level() {
        return cust_level;
    }

    public void setCust_level(BaseDict cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_phone() {
        return cust_phone;
    }
    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }
    public String getCust_mobile() {
        return cust_mobile;
    }
    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }
    @Override
    public String toString() {
        return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
                + ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_phone=" + cust_phone
                + ", cust_mobile=" + cust_mobile + "]";
    }
}
