package com.example.pcproject;

public class Seatbean {
    String sPcname; //PC이름 : PK
    String sState; //상태
    String sUserid; //사용자 ID
    String sUnmem; //비회원

    public String getsPcname() {
        return sPcname;
    }

    public void setsPcname(String sPcname) {
        this.sPcname = sPcname;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getsUserid() {
        return sUserid;
    }

    public void setsUserid(String sUserid) {
        this.sUserid = sUserid;
    }

    public String getsUnmem() {
        return sUnmem;
    }

    public void setsUnmem(String sUnmem) {
        this.sUnmem = sUnmem;
    }
}
