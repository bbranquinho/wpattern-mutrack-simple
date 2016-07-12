package org.wpattern.mutrack.simple.packagee;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.wpattern.mutrack.simple.user.UserEntity;
import org.wpattern.mutrack.simple.utils.BaseEntity;

@Entity
@Table(name = "tb_package")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class PackageeEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201505091506L;

	@NotNull
	@Size(min = 4, max = 60)
	@Column(name = "name", length = 60, nullable = false)
	private String name;

	@Max(20)
	@NotNull
	@Column(name = "code", length = 20, nullable = false)
	private String code;

	@Max(150)
	@Column(name = "description", length = 150, nullable = true)
	private String description;

	@NotNull
	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private UserEntity user;

	public PackageeEntity() {
	}

	public PackageeEntity(String name, String code, String description, Date registerDate, UserEntity user) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.registerDate = registerDate;
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
