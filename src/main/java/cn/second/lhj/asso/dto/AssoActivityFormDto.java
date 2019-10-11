package cn.second.lhj.asso.dto;

import java.io.Serializable;
import java.util.List;

import cn.second.lhj.asso.po.CspAssoActivity;
import cn.second.lhj.asso.po.CspAssoManagement;
import cn.second.lhj.asso.po.CspAssoStudent;


public class AssoActivityFormDto extends CspAssoActivity implements Serializable  {
	
   
    
    private List<CspAssoStudent> assoStuList;
    private List<CspAssoManagement> assoList;
    
	public AssoActivityFormDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssoActivityFormDto(List<CspAssoStudent> assoStuList, List<CspAssoManagement> assoList) {
		super();
		this.assoStuList = assoStuList;
		this.assoList = assoList;
	}

	public List<CspAssoStudent> getAssoStuList() {
		return assoStuList;
	}

	public void setAssoStuList(List<CspAssoStudent> assoStuList) {
		this.assoStuList = assoStuList;
	}

	public List<CspAssoManagement> getAssoList() {
		return assoList;
	}

	public void setAssoList(List<CspAssoManagement> assoList) {
		this.assoList = assoList;
	}

	@Override
	public String toString() {
		return "AssoActivityFormDto [assoStuList=" + assoStuList + ", assoList=" + assoList + "]";
	}
    
    
}
