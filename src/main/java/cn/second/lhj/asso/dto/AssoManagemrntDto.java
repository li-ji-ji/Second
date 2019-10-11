package cn.second.lhj.asso.dto;

import java.io.Serializable;


public class AssoManagemrntDto implements Serializable {
	private Integer id;
	private String assoId;
	private String assoName;
	private Integer assoStatus;
	private Integer assoExamined;
	private Integer assoGuiderId;
	private String assoLeader;
	private String assoAffiliateNo;
	
	
	public AssoManagemrntDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AssoManagemrntDto(Integer id, String assoId, String assoName, Integer assoStatus, Integer assoExamined,
			Integer assoGuiderId, String assoLeader, String assoAffiliateNo) {
		super();
		this.id = id;
		this.assoId = assoId;
		this.assoName = assoName;
		this.assoStatus = assoStatus;
		this.assoExamined = assoExamined;
		this.assoGuiderId = assoGuiderId;
		this.assoLeader = assoLeader;
		this.assoAffiliateNo = assoAffiliateNo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAssoId() {
		return assoId;
	}


	public void setAssoId(String assoId) {
		this.assoId = assoId;
	}


	public String getAssoName() {
		return assoName;
	}


	public void setAssoName(String assoName) {
		this.assoName = assoName;
	}


	public Integer getAssoStatus() {
		return assoStatus;
	}


	public void setAssoStatus(Integer assoStatus) {
		this.assoStatus = assoStatus;
	}


	public Integer getAssoExamined() {
		return assoExamined;
	}


	public void setAssoExamined(Integer assoExamined) {
		this.assoExamined = assoExamined;
	}


	public Integer getAssoGuiderId() {
		return assoGuiderId;
	}


	public void setAssoGuiderId(Integer assoGuiderId) {
		this.assoGuiderId = assoGuiderId;
	}


	public String getAssoLeader() {
		return assoLeader;
	}


	public void setAssoLeader(String assoLeader) {
		this.assoLeader = assoLeader;
	}


	public String getAssoAffiliateNo() {
		return assoAffiliateNo;
	}


	public void setAssoAffiliateNo(String assoAffiliateNo) {
		this.assoAffiliateNo = assoAffiliateNo;
	}


	@Override
	public String toString() {
		return "AssoManagemrntDto [id=" + id + ", assoId=" + assoId + ", assoName=" + assoName + ", assoStatus="
				+ assoStatus + ", assoExamined=" + assoExamined + ", assoGuiderId=" + assoGuiderId + ", assoLeader="
				+ assoLeader + ", assoAffiliateNo=" + assoAffiliateNo + "]";
	}
	
	
	
}
