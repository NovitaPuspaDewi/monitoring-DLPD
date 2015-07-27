/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplo.bioskop.testPackage;

import Model.*;
import java.util.List;
import org.springframework.jdbc.support.JdbcUtils;

/**
 *
 * @author Agustinus Agri
 */
public class TestClass {

    public static void main(String[] args) {

//        DatabaseConnection databaseConnection = new DatabaseConnection();
//
//        int validateLoginCredential = DataPegawai.validateLoginCredential("HERI", "HERI123", "ADMIN","22");
//        
//        System.out.println("LOGIN STATUS : "+validateLoginCredential);

//        int count = Approve.hitungApprove_sudahcek_0("07-2015");
       // System.out.println(count);
        System.out.print(Dashboard.hitungtbt("201506", "22500")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22500")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22500")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22500")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22500"));

        System.out.print(Dashboard.hitungtbt("201506", "22510")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22510")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22510")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22510")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22510"));

        System.out.print(Dashboard.hitungtbt("201506", "22520")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22520")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22520")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22520")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22520"));
        
        System.out.print(Dashboard.hitungtbt("201506", "22530")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22530")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22530")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22530")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22530"));

        System.out.print(Dashboard.hitungtbt("201506", "22540")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22540")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22540")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22540")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22540"));

        System.out.print(Dashboard.hitungtbt("201506", "22550")+" ");
        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22550")+" ");
        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22550")+" ");
        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22550")+" ");
        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22550"));

      //  query4List();


        //   query4List();

//        List<DataPegawai> dataList = DataPegawai.getDataList();
//        
//        for (int i = 0; i < dataList.size(); i++) {
//            System.out.println(dataList.get(i).getmNamaPegawai()+" ");
//        }
    }

    public static void query4List() {
        List<Unitup> list = Model.Unitup.getDataList_Unitup_tbt();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getpUnitup() + " ");
            System.out.print(Dashboard.hitungtbt("201506", list.get(i).getpUnitup()) + " ");
            System.out.print(Dashboard.hitungtbt_belumcek("201506", list.get(i).getpUnitup()) + " ");
            System.out.print(Dashboard.hitungtbt_sudahcek("201506", list.get(i).getpUnitup()) + " ");
            System.out.print(Dashboard.hitungtbt_belumapprove("201506", list.get(i).getpUnitup()) + " ");
            System.out.print(Dashboard.hitungtbt_sudahapprove("201506", list.get(i).getpUnitup()));
            System.out.println("");
            //JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        }
//        System.out.println(list.size());
//        System.out.println(Approve.hitungKwh0_yangsama());
    }
}
