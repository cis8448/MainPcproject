package com.example.pcproject;

public class Seatbean {
    String sPcname; //PC이름 : PK
    String sPcstate; //PC상태(사용중,빈좌석,예약중)
    String sUsestate; //사용상태(뭘하고있는지)
    String sMemstate; //회원상태(0,1)
    String sUserid; //사용자 ID
    String sUnmem; //비회원


    public String getsPcname() {
        return sPcname;
    }

    public void setsPcname(String sPcname) {
        this.sPcname = sPcname;
    }

    public String getsPcstate() {
        return sPcstate;
    }

    public void setsPcstate(String sPcstate) {
        this.sPcstate = sPcstate;
    }

    public String getsUsestate() {
        return sUsestate;
    }

    public void setsUsestate(String sUsestate) {
        this.sUsestate = sUsestate;
    }

    public String getsMemstate() {
        return sMemstate;
    }

    public void setsMemstate(String sMemstate) {
        this.sMemstate = sMemstate;
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
