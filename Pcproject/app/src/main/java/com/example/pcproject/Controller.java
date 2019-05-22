package com.example.pcproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Controller extends AppCompatActivity {
    MemberDAO memberDAO;
    ProductDAO productDAO;
    SeatDAO seatDAO;
    SQLiteDatabase db, db1, db2;
    ImageView imgs;
    public String intentid;
    public String intentpw;
    public String UpdateItPw;
    public String UpdateItPh;
    public String UpdateItBr;
    public Memberbeen mybean;
    public Probean probean;
    Activity mainAct;
    Dialogs dlg = new Dialogs();
    static Controller controller;
    Listsetting listset, prolistset;
    ArrayList<Memberbeen> allmem;
    ArrayList<Seatbean> allseat;
    ArrayList<Probean> allpro;
    int imgpho;
    ArrayList<Productorder> allorder;
    public String time;
    Listsetting.ProductAdapterSet productAdapterSet;
    private Controller() {

    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }//인스턴스 불러오기

    public void setActivity(Activity act) {
        mainAct = act;
    }//액티비티저장

    public void sub(Activity activity, String state) {
        memberDAO = new MemberDAO(activity);
        seatDAO = new SeatDAO(activity);
        productDAO = new ProductDAO(activity);
        db = memberDAO.getWritableDatabase();
        db1 = seatDAO.getWritableDatabase();
        db2 = productDAO.getWritableDatabase();
        if (state.equals("login")) {
            Intent loginOpen = new Intent("com.example.pcproject.login");
            activity.startActivity(loginOpen);
        }//로그인 화면 띄우기
        if (state.equals("myinfo")) {
            Intent myinfoOpen = new Intent("com.example.pcproject.myinfo");
            myinfoOpen.putExtra("OBJECT", mybean);
            activity.startActivity(myinfoOpen);
        }//내정보창 띄우기
        if (state.equals("selLogin")) {
            int count = memberDAO.selectLogin(db, intentid, intentpw);
            switch (count) {
                case 0:
                    Toast.makeText(activity, "아이디및 비밀번호 오류입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    mybean = memberDAO.selectID(db, intentid);
                    if (mybean.getId().equals("admin")) {
                        sub(activity, "adminLogin");

                    } else {
                        sub(activity, "ClearLogin");
                    }
                    break;
            }
        }//로그인 처리
        if (state.equals("ClearLogin")) {
            ((MainActivity) mainAct).MyMember = mybean;
            activity.finish();

        }//로그인 완료
        if (state.equals("signup")) {
            Intent signupOpen = new Intent("com.example.pcproject.memberadd");
            activity.startActivity(signupOpen);
        }//회원가입 화면 띄우기
        if (state.equals("signing")) {
            String id = ((memberadd) activity).joinid.getText().toString();
            int se = memberDAO.seletoverlap(db, id);
            Memberbeen nemem = null;
            if (se != 0) {
                Toast.makeText(activity, "아이디가 중복되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                nemem = ((memberadd) activity).memberbeen;
                memberDAO.insertMember(db, nemem);
                activity.finish();
                Toast.makeText(activity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
            if(mainAct instanceof membermanagment){
                allmem.add(nemem);
                ((membermanagment)mainAct).adapterSet.notifyDataSetChanged();

            }
        }//회원가입처리
        if (state.equals("myinfoupdate")) {
            dlg.myinfoDialog(activity);
        }//내정보 수정처리
        if (state.equals("myinfoupdating")) {
            memberDAO.updateUser(db, mybean.getId(), dlg.infopw, dlg.infohp, dlg.infobr);
            mybean.setPass(dlg.infopw);
            mybean.setPhone(dlg.infohp);
            mybean.setBirth(dlg.infobr);
            ((myinfo) activity).tvPw.setText(dlg.infopw);
            ((myinfo) activity).tvHp.setText(dlg.infohp);
            ((MainActivity) mainAct).MyMember = mybean;
            ((myinfo) activity).memberbeen = mybean;

        }//내정보 수정처리
        if (state.equals("myremove")) {
            dlg.removeDialog(activity);
        }//삭제여부화면 띄우기
        if (state.equals("myremoving")) {
            memberDAO.deleteMember(db, mybean.getId());
            ((MainActivity) mainAct).MyMember = null;
            ((MainActivity) mainAct).MyMember = new Memberbeen();
            activity.finish();
            Toast.makeText(activity, "회원 탈퇴 되었습니다잉", Toast.LENGTH_SHORT).show();
        }//삭제처리
        if (state.equals("seatdata")) {
            Intent seatdataOpen = new Intent("com.example.pcproject.seatdata");
            seatDAO.onCreate(db1);
            int[] ss = seatDAO.selectstate(db1);
            seatdataOpen.putExtra("좌석", ss);
            activity.startActivity(seatdataOpen);

        }//좌석화면 띄우기
        if (state.equals("addtime")) {
            dlg.addTimeDialog(activity);
        }//적립시간추가화면띄우기
        if (state.equals("addtimefinal")) {
            mybean = ((myinfo) activity).memberbeen;
            memberDAO.updateTime(db, mybean.getId(), mybean.getRetime());
            ((MainActivity)mainAct).MyMember = ((myinfo) activity).memberbeen;
            Toast.makeText(activity, "시간이 충전되었습니다.", Toast.LENGTH_SHORT).show();
            ((myinfo) activity).tvTime.setText(mybean.getRetime());
        }//적립시간추가처리
        if (state.equals("adminLogin")) {
            Intent membermanagmentOpen = new Intent("com.example.pcproject.membermanagment");
            activity.finish();
            mainAct.finish();
            activity.startActivity(membermanagmentOpen);

        }//admin로그인
        if (state.equals("listset")) {
            allmem = memberDAO.selectAll(db);
            listset = new Listsetting(allmem , 1);
            ((membermanagment) activity).adapterSet = listset.memberListSetting();
        }//membermanagment리스트셋팅
        if (state.equals("productlist")) {
            Intent productlistOpen = new Intent("com.example.pcproject.productmanagment");
            activity.startActivity(productlistOpen);
            activity.finish();
        }//콘텍스트 메뉴에서 상품관리 눌렀을때
        if (state.equals("productlistset")){
            allpro = productDAO.selectAll(db2);
            prolistset = new Listsetting(allpro,2);
            ((productmanagment) activity).proAdapterset = prolistset.productListSetting();

        }//상품관리의 리스트셋팅을 보여줄때.
        if (state.equals("seatmanager")) {
            Intent seatmanagerOpen = new Intent("com.example.pcproject.seatmanager");
            activity.startActivity(seatmanagerOpen);
            activity.finish();
        }//좌석상태 화면 띄우기
        if (state.equals("seatreve")) {
            //내가 로그인 -> 적립시간의 유무에 따라 분기
            String retime = ((MainActivity) mainAct).MyMember.getRetime();
            int getreveid = seatDAO.selectreserve(db1,mybean.getId());
            if(getreveid == 1){
                dlg.moveDialog(activity);
            }else {
                if (retime.equals("0:00") || retime.equals("00:00")) {
                    // 내가 적립시간 X
                    Toast.makeText(activity, "적립 시간이 없어 예약 할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    dlg.reserveDialog(activity);
                }
            }

        }
        if (state.equals("Finalreve")){
            seatDAO.updatestate(db1,((seatdata)activity).item,"1",time,mybean.getId());
            ((seatdata)activity).btn[((seatdata)activity).item].setBackground(((seatdata)activity).btn2.getBackground());
            ((seatdata)activity).seat[((seatdata)activity).item] = 1;
            Toast.makeText(activity, "예약이 되었습니다.", Toast.LENGTH_SHORT).show();
        }
        if (state.equals("userdel")){
            Memberbeen mem = new Memberbeen();
            mem = allmem.get(((membermanagment)mainAct).itemnum);
            memberDAO.deleteMember(db,mem.getId());
            allmem.remove(((membermanagment)mainAct).itemnum);
            ((membermanagment)mainAct).adapterSet.notifyDataSetChanged();
        }
        if (state.equals("memberinfoupdate")){
            dlg.memberUpdateDailog(activity);
        }
        if (state.equals("updateinfo")){
            memberDAO.updateUser(db,allmem.get(((membermanagment)mainAct).itemnum).getId(),
                    allmem.get(((membermanagment)mainAct).itemnum).getPass(),
                    allmem.get(((membermanagment)mainAct).itemnum).getPhone(),
                    allmem.get(((membermanagment)mainAct).itemnum).getBirth());
            ((membermanagment)mainAct).adapterSet.notifyDataSetChanged();
        }
        if (state.equals("adminproadd")){
            Intent adminproaddOpen = new Intent("com.example.pcproject.productadd");
            productAdapterSet = ((productmanagment)activity).proAdapterset;
            activity.startActivity(adminproaddOpen);
        }
        if (state.equals("adminprodeldi")){
            dlg.removeProductDialog(activity);
        }
        if (state.equals("adminprodel")){
            Probean pro = new Probean();
            pro = allpro.get(((productmanagment)activity).proitemsel);
            productDAO.deleteProduct(db2,pro.getProID());
            allpro.remove(((productmanagment)mainAct).proitemsel);
            (((productmanagment)activity)).proAdapterset.notifyDataSetChanged();
        }
        if (state.equals("prophotoadd")){
            Intent prophotoaddOpen = new Intent("com.example.pcproject.photoadd");
            imgs = ((productadd)activity).proaddImV;
            activity.startActivity(prophotoaddOpen);
        }
        if (state.equals("photoopen")){
            listset = new Listsetting(((photoadd)activity).Photo);
            ((photoadd)activity).myPhotoAdapter = listset.photoListsetting();
        }
        if (state.equals("photoadd")){
            imgpho = ((photoadd)activity).Photo[((photoadd)activity).pos];
            imgs.setImageResource(((photoadd)activity).Photo[((photoadd)activity).pos]);
            activity.finish();
        }
        if (state.equals("proaddlistadd")){
            ((productadd)activity).probean.setProImage(imgpho+"");
            productDAO.insertProduct(db2,((productadd)activity).probean);
            Toast.makeText(activity, "상품이 추가 되었습니다.", Toast.LENGTH_SHORT).show();
            allpro.add(((productadd)activity).probean);
            productAdapterSet.notifyDataSetChanged();
            activity.finish();
        }
        if (state.equals("seatreserve")){
            String id = ((MainActivity) mainAct).MyMember.getId();
            int a = seatDAO.selectreserve(db1,id);
            if(a == 0){
                Toast.makeText(activity, "이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.", Toast.LENGTH_SHORT).show();
            }else if(a != 0 ){
                dlg.deleteDialog(activity);
            }
        }
        if (state.equals("mydelete")){
            seatDAO.updatedelete(db1,((seatdata)activity).item,"0",mybean.getId());
            ((seatdata)activity).btn[((seatdata)activity).item].setBackground(((seatdata)activity).btn1.getBackground());
            ((seatdata)activity).seat[((seatdata)activity).item] = 0;
            Toast.makeText(activity, "예약이 취소 되었습니다잉", Toast.LENGTH_SHORT).show();
        }
        if (state.equals("moving")){
            int prev =seatDAO.selectprev(db1,mybean.getId());
            seatDAO.updatedelete(db1,((seatdata)activity).item,"0",mybean.getId());
            ((seatdata)activity).btn[prev].setBackground(((seatdata)activity).btn1.getBackground());
            ((seatdata)activity).seat[prev] = 0;
            sub(activity,"seatreve");

        }
        if (state.equals("seatListset")){
            allseat = seatDAO.selectall(db1);
            listset = new Listsetting(allseat , 3);
            ((seatmanager)activity).seatAdapterSet = listset.seatListSetting();
        }
        if (state.equals("order")){
            Intent orderOpen = new Intent("com.example.pcproject.productorder");
            activity.startActivity(orderOpen);
        }
        if (state.equals("ordercate")){

            allorder = productDAO.selectCate(db2,((Productorder)activity).cate);
            listset = new Listsetting(allorder,2);
            ((Productorder)activity).productAdapterSet = listset.productListSetting();
            ((Productorder)activity).grid.setAdapter(((Productorder)activity).productAdapterSet);




        }
        if (state.equals("orderhistory")){
            Intent orderhistoryOpen = new Intent("com.example.pcproject.productcheck");
            activity.startActivity(orderhistoryOpen);
        }
        if (state.equals("orderpay")){
            Intent orderpayOpen = new Intent("com.example.pcproject.pay");
            activity.startActivity(orderpayOpen);
        }
    }
}




