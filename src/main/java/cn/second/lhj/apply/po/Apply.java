package cn.second.lhj.apply.po;

import java.util.Date;

public class Apply {
    private Integer id;

    private Integer kindId;

    private String stuId;

    private Integer status;

    private Integer checkStatus;

    private String supportDoc;

    private String supportFile;

    private Date applyTime;

    private Double integral;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getSupportDoc() {
        return supportDoc;
    }

    public void setSupportDoc(String supportDoc) {
        this.supportDoc = supportDoc == null ? null : supportDoc.trim();
    }

    public String getSupportFile() {
        return supportFile;
    }

    public void setSupportFile(String supportFile) {
        this.supportFile = supportFile == null ? null : supportFile.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }
}