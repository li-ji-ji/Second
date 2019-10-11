package cn.second.lhj.stuinfo.po;

import java.util.Date;

public class StuInfo {
    private String stuId;

    private Double stuIntegral;

    private Double lastIntegral;

    private Date writeTime;

    private Date lastLoginTime;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Double getStuIntegral() {
        return stuIntegral;
    }

    public void setStuIntegral(Double stuIntegral) {
        this.stuIntegral = stuIntegral;
    }

    public Double getLastIntegral() {
        return lastIntegral;
    }

    public void setLastIntegral(Double lastIntegral) {
        this.lastIntegral = lastIntegral;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}