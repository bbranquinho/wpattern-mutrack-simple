package org.wpattern.mutrack.simple.packagee;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.wpattern.mutrack.simple.user.UserModel;

import java.util.Date;

@Table(name = "Packages")
public class PackageModel extends Model {

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private String code;

    @Column(name = "Description")
    private String description;

    @Column(name = "RegisterDate")
    private Date registerDate;

    @Column(name = "User")
    private UserModel user;

    public PackageModel() {
        super();
    }

    public PackageModel(String name, String code, String description) {
        super();
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public PackageModel(String name, String code, String description, Date registerDate, UserModel user) {
        super();
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
