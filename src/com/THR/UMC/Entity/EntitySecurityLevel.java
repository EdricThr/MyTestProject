package com.THR.UMC.Entity;

public class EntitySecurityLevel {
    private Integer securityLevelId;
    private String securityLevelName;
    private String securityLevelColor;
    private String securityLevelDesc;
    public Integer getSecurityLevelId() {
        return securityLevelId;
    }

    public void setSecurityLevelId(Integer securityLevelId) {
        this.securityLevelId = securityLevelId;
    }

    public String getSecurityLevelName() {
        return securityLevelName;
    }

    public void setSecurityLevelName(String securityLevelName) {
        this.securityLevelName = securityLevelName;
    }

    public String getSecurityLevelColor() {
        return securityLevelColor;
    }

    public void setSecurityLevelColor(String securityLevelColor) {
        this.securityLevelColor = securityLevelColor;
    }

    public String getSecurityLevelDesc() {
        return securityLevelDesc;
    }

    public void setSecurityLevelDesc(String securityLevelDesc) {
        this.securityLevelDesc = securityLevelDesc;
    }
}
