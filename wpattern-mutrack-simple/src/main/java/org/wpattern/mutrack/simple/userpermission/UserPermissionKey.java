package org.wpattern.mutrack.simple.userpermission;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.wpattern.mutrack.simple.utils.BaseKey;

@Embeddable
public class UserPermissionKey extends BaseKey {

	private static final long serialVersionUID = 201602010536L;

	@Column(name = "permission_id", length = 11, nullable = false)
	private Long permissionId;

	@Column(name = "user_id", length = 11, nullable = false)
	private Long userId;

	public UserPermissionKey() {
	}

	public UserPermissionKey(Long permissionId, Long userId) {
		super();
		this.permissionId = permissionId;
		this.userId = userId;
	}

	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
