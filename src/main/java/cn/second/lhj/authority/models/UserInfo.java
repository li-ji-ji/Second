package cn.second.lhj.authority.models;

import java.util.List;

public class UserInfo {
	private Integer uid;

	private String name;

	private String password;

	private String salt;

	private Byte state;

	private String username;

	private List<SysRole> roleList;// 一个用户具有多个角色

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * 密码盐.
	 * 
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username + this.salt;
	}
	// 重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
	
	
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", name=" + name + ", password=" + password + ", salt=" + salt + ", state="
				+ state + ", username=" + username + ", roleList=" + roleList + "]";
	}

}