package com.snacks.codeArea.model;

public class CodeArea {
    private String resourceId;

    private String areaName;

    private String orderId;

    private String isEnable;

    private String areaAbba;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    public String getAreaAbba() {
        return areaAbba;
    }

    public void setAreaAbba(String areaAbba) {
        this.areaAbba = areaAbba == null ? null : areaAbba.trim();
    }
}