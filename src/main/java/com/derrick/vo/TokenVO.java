package com.derrick.vo;

import java.util.Date;

/**
 * Created by ccc on 2016/7/11.
 */
public class TokenVO {

    private String branchCode;

    private String userCode;

    private Date expTime;

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    @Override
    public String toString() {
        return "TokenVO{" +
                "branchCode='" + branchCode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", expTime=" + expTime +
                '}';
    }
}
