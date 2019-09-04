package cn.second.lhj.authority.models;

import java.util.List;

public class MenuVo {
	private Integer id;
	private Integer pId;
	private String name;
	private String pName;
	private String url;
	private Integer status;
	List<MenuVo> menus;
	
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getId() {
		return id;
	}
	public Integer getpId() {
		return pId;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public Integer getStatus() {
		return status;
	}
	public List<MenuVo> getMenus() {
		return menus;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setMenus(List<MenuVo> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "MenuVo [id=" + id + ", pId=" + pId + ", name=" + name + ", pName=" + pName + ", url=" + url
				+ ", status=" + status + ", menus=" + menus + "]";
	}
}
