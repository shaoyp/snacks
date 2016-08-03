package com.snacks.fandiandata.model;

import java.util.Date;

public class Fandiandata {
    private String resourceId;

    private String title;

    private String url;

    private String address;

    private String phone;

    private String meituanvaluate;

    private String elemevaluate;

    private String baiduevaluate;

    private String sales;

    private Date getTime;

    private String province;

    private String city;

    private String lng;

    private String lat;

    private String baidu;

    private String meituan;

    private String eleme;

    private Integer baidusales;

    private Integer meituansales;

    private Integer elemesales;

    private String flg;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMeituanvaluate() {
        return meituanvaluate;
    }

    public void setMeituanvaluate(String meituanvaluate) {
        this.meituanvaluate = meituanvaluate == null ? null : meituanvaluate.trim();
    }

    public String getElemevaluate() {
        return elemevaluate;
    }

    public void setElemevaluate(String elemevaluate) {
        this.elemevaluate = elemevaluate == null ? null : elemevaluate.trim();
    }

    public String getBaiduevaluate() {
        return baiduevaluate;
    }

    public void setBaiduevaluate(String baiduevaluate) {
        this.baiduevaluate = baiduevaluate == null ? null : baiduevaluate.trim();
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales == null ? null : sales.trim();
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getBaidu() {
        return baidu;
    }

    public void setBaidu(String baidu) {
        this.baidu = baidu == null ? null : baidu.trim();
    }

    public String getMeituan() {
        return meituan;
    }

    public void setMeituan(String meituan) {
        this.meituan = meituan == null ? null : meituan.trim();
    }

    public String getEleme() {
        return eleme;
    }

    public void setEleme(String eleme) {
        this.eleme = eleme == null ? null : eleme.trim();
    }

    public Integer getBaidusales() {
        return baidusales;
    }

    public void setBaidusales(Integer baidusales) {
        this.baidusales = baidusales;
    }

    public Integer getMeituansales() {
        return meituansales;
    }

    public void setMeituansales(Integer meituansales) {
        this.meituansales = meituansales;
    }

    public Integer getElemesales() {
        return elemesales;
    }

    public void setElemesales(Integer elemesales) {
        this.elemesales = elemesales;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg == null ? null : flg.trim();
    }
}