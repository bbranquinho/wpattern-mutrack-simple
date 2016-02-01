package org.wpattern.mutrack.simple.userpermission;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.wpattern.mutrack.simple.utils.BaseEntity;

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 201602010251L;

}