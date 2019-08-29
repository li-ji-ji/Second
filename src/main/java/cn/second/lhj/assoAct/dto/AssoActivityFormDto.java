package cn.second.lhj.assoAct.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.second.lhj.assoAct.po.CspAssoActivity;
import cn.second.lhj.assoAct.po.CspAssoManagement;
import cn.second.lhj.assoAct.po.CspAssoStudent;


public class AssoActivityFormDto extends CspAssoActivity implements Serializable  {
	
    
    private List<CspAssoStudent> assoStuList;
    private List<CspAssoManagement> assoList;
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
    
    
}
