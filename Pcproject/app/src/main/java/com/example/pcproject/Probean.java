package com.example.pcproject;

public class Probean {

    String proID; //상품 ID PK
    String proOrder; //상품 주문
    String proCheck; //상품 주문 내역 (했던것들 보기)
    String proPay; //상품의 결제

    String proName; //상품의 이름
    String proPrice; //상품의 가격
    String proAmount; //상품의 수량
    String proCate; //상품의 카테고리
    String proImage; //상품의 이미지가 들어가는곳.

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProOrder() {
        return proOrder;
    }

    public void setProOrder(String proOrder) {
        this.proOrder = proOrder;
    }

    public String getProCheck() {
        return proCheck;
    }

    public void setProCheck(String proCheck) {
        this.proCheck = proCheck;
    }

    public String getProPay() {
        return proPay;
    }

    public void setProPay(String proPay) {
        this.proPay = proPay;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProAmount() {
        return proAmount;
    }

    public void setProAmount(String proAmount) {
        this.proAmount = proAmount;
    }

    public String getProCate() {
        return proCate;
    }

    public void setProCate(String proCate) {
        this.proCate = proCate;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }
}

