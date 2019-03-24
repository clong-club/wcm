package com.pavilionking.wcm.dto;

import java.util.Date;

public class WOperateLog {
    private Integer id;

    private Integer visitorId;

    private String operateIp;

    private String operatorName;

    private String operatoModel;

    private Date startTime;

    private String operateMethod;

    private String operateParam;

    private String operateResult;

    private Date endTime;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatoModel() {
        return operatoModel;
    }

    public void setOperatoModel(String operatoModel) {
        this.operatoModel = operatoModel == null ? null : operatoModel.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getOperateMethod() {
        return operateMethod;
    }

    public void setOperateMethod(String operateMethod) {
        this.operateMethod = operateMethod == null ? null : operateMethod.trim();
    }

    public String getOperateParam() {
        return operateParam;
    }

    public void setOperateParam(String operateParam) {
        this.operateParam = operateParam == null ? null : operateParam.trim();
    }

    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult == null ? null : operateResult.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}