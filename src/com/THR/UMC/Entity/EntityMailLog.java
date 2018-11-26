package com.THR.UMC.Entity;

import java.util.Date;

public class EntityMailLog {
    private Integer mailLogId;
    private String mailSubject;
    private EntitySecurityLevel mailSecurityLevel;
    private String attachmentInfo;
    private Boolean encrypted;
    private Boolean signed;
    private Date mailLogAddTime;
    private String mailSenderInfo;
    private String mailToInfo;
    private String mailUuId;
    private String description;

    public Integer getMailLogId() {
        return mailLogId;
    }

    public void setMailLogId(Integer mailLogId) {
        this.mailLogId = mailLogId;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public EntitySecurityLevel getMailSecurityLevel() {
        return mailSecurityLevel;
    }

    public void setMailSecurityLevel(EntitySecurityLevel mailSecurityLevel) {
        this.mailSecurityLevel = mailSecurityLevel;
    }

    public String getAttachmentInfo() {
        return attachmentInfo;
    }

    public void setAttachmentInfo(String attachmentInfo) {
        this.attachmentInfo = attachmentInfo;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public Date getMailLogAddTime() {
        return mailLogAddTime;
    }

    public void setMailLogAddTime(Date mailLogAddTime) {
        this.mailLogAddTime = mailLogAddTime;
    }

    public String getMailSenderInfo() {
        return mailSenderInfo;
    }

    public void setMailSenderInfo(String mailSenderInfo) {
        this.mailSenderInfo = mailSenderInfo;
    }

    public String getMailToInfo() {
        return mailToInfo;
    }

    public void setMailToInfo(String mailToInfo) {
        this.mailToInfo = mailToInfo;
    }

    public String getMailUuId() {
        return mailUuId;
    }

    public void setMailUuId(String mailUuId) {
        this.mailUuId = mailUuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
