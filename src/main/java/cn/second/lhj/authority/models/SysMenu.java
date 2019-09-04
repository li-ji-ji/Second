package cn.second.lhj.authority.models;

public class SysMenu {
    private Integer id;

    private Integer pid;

    private String name;

    private Boolean available;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	@Override
	public String toString() {
		return "SysMenu [id=" + id + ", pid=" + pid + ", name=" + name + ", available=" + available + ", url=" + url
				+ ", getId()=" + getId() + ", getPid()=" + getPid() + ", getName()=" + getName() + ", getAvailable()="
				+ getAvailable() + ", getUrl()=" + getUrl() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}