package com.example.pcproject;

public class paybean {
    String PayId;   // 결재 아이디
    String MemId;   // 회원 아이디
    String PayTime; // 구매 시간
    String PayQty;  // 구매수량
    String PayCate; // 상품카테고리
    String ProName; // 상품 이름
    String Proprice;// 상품 가격

    public String getPayId() {
        return PayId;
    }

    public void setPayId(String payId) {
        PayId = payId;
    }

    public String getMemId() {
        return MemId;
    }

    public void setMemId(String memId) {
        MemId = memId;
    }

    public String getPayTime() {
        return PayTime;
    }

    public void setPayTime(String payTime) {
        PayTime = payTime;
    }

    public String getPayQty() {
        return PayQty;
    }

    public void setPayQty(String payQty) {
        PayQty = payQty;
    }

    public String getPayCate() {
        return PayCate;
    }

    public void setPayCate(String payCate) {
        PayCate = payCate;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public String getProprice() {
        return Proprice;
    }

    public void setProprice(String proprice) {
        Proprice = proprice;
    }


}
