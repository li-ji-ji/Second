package cn.second.lhj.applykind.po;

public class ApplyKind {
    private Integer id;

    private String kindName;

    private Integer pId;

    private String pName;

    private Integer status;

    private Double kindIntegral;

    private String kindIntro;

    private Integer needSuppDoc;

    private Integer needSuppFile;

    private Integer needCheck;

    private Integer checkKind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getKindIntegral() {
        return kindIntegral;
    }

    public void setKindIntegral(Double kindIntegral) {
        this.kindIntegral = kindIntegral;
    }

    public String getKindIntro() {
        return kindIntro;
    }

    public void setKindIntro(String kindIntro) {
        this.kindIntro = kindIntro == null ? null : kindIntro.trim();
    }

    public Integer getNeedSuppDoc() {
        return needSuppDoc;
    }

    public void setNeedSuppDoc(Integer needSuppDoc) {
        this.needSuppDoc = needSuppDoc;
    }

    public Integer getNeedSuppFile() {
        return needSuppFile;
    }

    public void setNeedSuppFile(Integer needSuppFile) {
        this.needSuppFile = needSuppFile;
    }

    public Integer getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(Integer needCheck) {
        this.needCheck = needCheck;
    }

    public Integer getCheckKind() {
        return checkKind;
    }

    public void setCheckKind(Integer checkKind) {
        this.checkKind = checkKind;
    }
}