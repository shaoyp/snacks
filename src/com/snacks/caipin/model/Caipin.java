package com.snacks.caipin.model;

public class Caipin {
    private String resourceId;

    private String caipinming;

    private String fandianid;

    private String sales;

    private String prince;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getCaipinming() {
        return caipinming;
    }

    public void setCaipinming(String caipinming) {
        this.caipinming = caipinming == null ? null : caipinming.trim();
    }

    public String getFandianid() {
        return fandianid;
    }

    public void setFandianid(String fandianid) {
        this.fandianid = fandianid == null ? null : fandianid.trim();
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales == null ? null : sales.trim();
    }

    public String getPrince() {
        return prince;
    }

    public void setPrince(String prince) {
        this.prince = prince == null ? null : prince.trim();
    }
}