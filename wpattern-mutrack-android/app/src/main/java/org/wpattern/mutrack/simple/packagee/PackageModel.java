package org.wpattern.mutrack.simple.packagee;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

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

    public PackageModel() {
        super();
    }

    public PackageModel(String name, String code, String description) {
        super();
        this.name = name;
        this.code = code;
        this.description = description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PackageModel> findAll() {
        return new Select().from(PackageModel.class).execute();
    }

}
