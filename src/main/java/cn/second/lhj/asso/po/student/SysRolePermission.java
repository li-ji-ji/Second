package cn.second.lhj.asso.po.student;

public class SysRolePermission {
	private Integer id;

	private Integer roleId;

	private Integer permissionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "SysRolePermission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}

}