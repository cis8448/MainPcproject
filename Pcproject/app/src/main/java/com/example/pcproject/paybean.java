package com.example.pcproject;

public class paybean {
    String PayId;   // 결재 아이디
    String MemId;   // 회원 아이디
    String PayTime; // 구매 시간
    String PayQty;  // 구매수량
    String PayCate; // 상품카테고리
    String ProName; // 상품 이름
    String Proprice;// 상품 가격
    int imgid; // 상품이미지 경로

//    String proOrder; //상품 주문
//    String proCheck; //상품 주문 내역 (했던것들 보기)
//    String proPay; //상품의 결제
    //pay 에 있어야 할것들이 pro에 있었음
    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }



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
