package org.wpattern.mutrack.simple.packagee;

import org.wpattern.mutrack.simple.user.UserBean;

import java.util.Date;

public class PackageeBean {

    private String name;

    private String code;

    private String description;

    private Date registerDate;

    private UserBean user;

    public PackageeBean() {
    }

    public PackageeBean(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public PackageeBean(String name, String code, String description, Date registerDate, UserBean user) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.registerDate = registerDate;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
