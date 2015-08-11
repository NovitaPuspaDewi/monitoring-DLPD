/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplo.bioskop.testPackage;

import Model.*;
import java.util.List;
import java.util.Date;
import org.springframework.jdbc.support.JdbcUtils;

/**
 *
 * @author Agustinus Agri
 */
public class TestClass {

    public static void main(String[] args) {
        
        System.out.println(new Date().toString());
              
                  //        DatabaseConnection databaseConnection = new DatabaseConnection();
                  //
                  //        int validateLoginCredential = DataPegawai.validateLoginCredential("HERI", "HERI123", "ADMIN","22");
                  //        
                  //        System.out.println("LOGIN STATUS : "+validateLoginCredential);

                  //        int count = LihatData_TBT.hitungtbt_belumapprove_unitup("22520");
                  //        System.out.println(count);
                  //        System.out.print(Dashboard.hitungtbt("201506", "22500")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22500")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22500")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22500")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22500"));
                  //
                  //        System.out.print(Dashboard.hitungtbt("201506", "22510")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22510")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22510")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22510")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22510"));
                  //
                  //        System.out.print(Dashboard.hitungtbt("201506", "22520")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22520")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22520")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22520")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22520"));
                  //        
                  //        System.out.print(Dashboard.hitungtbt("201506", "22530")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22530")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22530")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22530")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22530"));
                  //
                  //        System.out.print(Dashboard.hitungtbt("201506", "22540")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22540")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22540")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22540")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22540"));
                  //
                  //        System.out.print(Dashboard.hitungtbt("201506", "22550")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumcek("201506", "22550")+" ");
                  //        System.out.print(Dashboard.hitungtbt_sudahcek("201506", "22550")+" ");
                  //        System.out.print(Dashboard.hitungtbt_belumapprove("201506", "22550")+" ");
                  //        System.out.println(Dashboard.hitungtbt_sudahapprove("201506", "22550"));
                  //
                          //query4List();
                  //
                  //
                  //        //   query4List();
                  //
                  ////        List<DataPegawai> dataList = DataPegawai.getDataList();
                  ////        
                  ////        for (int i = 0; i < dataList.size(); i++) {
                  ////            System.out.println(dataList.get(i).getmNamaPegawai()+" ");
                  ////        }
    }

    public static void query4List() {
//        String blth = "201410";
        String idpel = "225700127909";
        String nama = null, alamat = null, tarif = null, koordinat = null, tgl_upload = null,
                verifikasi = null, petugas_upload = null, foto = null, blth_copy = null;
        int daya = 0, kwh_maks = 0, totkwh = 0;

        List<LihatData_TBT> data = LihatData_TBT.cek_pelanggan(idpel);
        for (int i = 0; i < data.size(); i++) {
            if (i == data.size() - 1) {
//                tgl_upload = data.get(i).getmTgl_Monitoring();
                verifikasi = data.get(i).getmVerifikasi();
                petugas_upload = data.get(i).getmPetugas_Upload();
                koordinat = data.get(i).getmKoordinat();
                nama = data.get(i).getmNama();
                alamat = data.get(i).getmAlamat();
                tarif = data.get(i).getmTarif();
                daya = data.get(i).getmDaya();
//                kwh_maks = data.get(i).getmKwhMaks();
//                totkwh = data.get(i).getmKwhTot();
                foto = data.get(i).getmFoto();
                blth_copy = data.get(i).getmBlth();

                System.out.println(idpel + " " + blth_copy + " " + foto);

            }

        }
//        Approve app = new Approve();
//                app.setmPetugas_Approve("HERI");
//                app.setmIdpel(idpel);
//                app.setmBlth(blth);
//                app.setmTgl_Monitoring(tgl_upload);
//                app.setmVerifikasi(verifikasi);
//                app.setmPetugas_Upload(petugas_upload);
//                app.setmKoordinat(koordinat);
//                app.setmFoto(foto);
//
//                Approve.Approve_Langsung(app);
    }
//        System.out.println(list.size());
//        System.out.println(Approve.hitungKwh0_yangsama());
}
