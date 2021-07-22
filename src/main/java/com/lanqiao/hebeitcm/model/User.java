package com.lanqiao.hebeitcm.model;

import java.util.*;

import com.lanqiao.hebeitcm.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表
 * @TableName user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class User implements UserDetails {
    /**
     *
     */
    private Integer itemid;

    /**
     * 唯一标识UUID
     */
    private String itemcode;

    /**
     * 机构id(关联organization表中的itemID）
     */
    private String orgCode;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 身份证件类型
     */
    private String idcardType;

    /**
     * 证件号码
     */
    private String idcardNo;

    /**
     * email
     */
    private String email;

    /**
     *
     */
    private String state;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话号码
     */
    private String mobilephone;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date itemcreateat;

    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    private Date itemupdateat;

    /**
     * 地级机构id
     */
    private String cityid;

    /**
     * 类型（0：普通，1：管理员）
     */
    private Integer type;

    /**
     * 肖像
     */
    private byte[] portrait;

    private static final long serialVersionUID = 1L;
    private Collection<? extends GrantedAuthority> authorities;
    /**
     * 获取某个用户所具备的权限的集合
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    /**
     * 返回true:  账号未过期.
     * 返回false: 账号过期.
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 返回true:  账号未锁定.
     * 返回false: 账号锁定.
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 返回true:  凭证未过期.
     * 返回false: 凭证过期.
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 返回true: 账号可用.
     * 返回false: 账号不可用.
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}