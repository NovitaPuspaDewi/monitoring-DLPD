/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 *
 * @author NOVITA
 */
public class LihatData_TBT {

    private String mIdpel;
    private String mBlth;
    private String mNama;
    private String mAlamat;
    private String mNoMeter;
    private String mTarif;
    private String mTgl_Bayar;
    private String mStatus_Monitoring;
    private String mTgl_Monitor;
    private String mBulan;
    private String mUnitup;
    private String mVerifikasi;
    private String mKoordinat;
    private String mApprove;
    private String mTgl_Approve;
    private String mPetugas_Upload;
    private String mPetugas_Verifikasi;
    private int mDaya;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        LihatData_TBT.jdbcTemplate = jdbcTemplate;
    }

    public String getmAlamat() {
        return mAlamat;
    }

    public void setmAlamat(String mAlamat) {
        this.mAlamat = mAlamat;
    }

    public String getmApprove() {
        return mApprove;
    }

    public void setmApprove(String mApprove) {
        this.mApprove = mApprove;
    }

    public String getmBlth() {
        return mBlth;
    }

    public void setmBlth(String mBlth) {
        this.mBlth = mBlth;
    }

    public String getmBulan() {
        return mBulan;
    }

    public void setmBulan(String mBulan) {
        this.mBulan = mBulan;
    }

    public int getmDaya() {
        return mDaya;
    }

    public void setmDaya(int mDaya) {
        this.mDaya = mDaya;
    }

    public String getmIdpel() {
        return mIdpel;
    }

    public void setmIdpel(String mIdpel) {
        this.mIdpel = mIdpel;
    }

    public String getmKoordinat() {
        return mKoordinat;
    }

    public void setmKoordinat(String mKoordinat) {
        this.mKoordinat = mKoordinat;
    }

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public String getmNoMeter() {
        return mNoMeter;
    }

    public void setmNoMeter(String mNoMeter) {
        this.mNoMeter = mNoMeter;
    }

    public String getmPetugas_Upload() {
        return mPetugas_Upload;
    }

    public void setmPetugas_Upload(String mPetugas_Upload) {
        this.mPetugas_Upload = mPetugas_Upload;
    }

    public String getmPetugas_Verifikasi() {
        return mPetugas_Verifikasi;
    }

    public void setmPetugas_Verifikasi(String mPetugas_Verifikasi) {
        this.mPetugas_Verifikasi = mPetugas_Verifikasi;
    }

    public String getmStatus_Monitoring() {
        return mStatus_Monitoring;
    }

    public void setmStatus_Monitoring(String mStatus_Monitoring) {
        this.mStatus_Monitoring = mStatus_Monitoring;
    }

    public String getmTarif() {
        return mTarif;
    }

    public void setmTarif(String mTarif) {
        this.mTarif = mTarif;
    }

    public String getmTgl_Approve() {
        return mTgl_Approve;
    }

    public void setmTgl_Approve(String mTgl_Approve) {
        this.mTgl_Approve = mTgl_Approve;
    }

    public String getmTgl_Bayar() {
        return mTgl_Bayar;
    }

    public void setmTgl_Bayar(String mTgl_Bayar) {
        this.mTgl_Bayar = mTgl_Bayar;
    }

    public String getmTgl_Monitor() {
        return mTgl_Monitor;
    }

    public void setmTgl_Monitor(String mTgl_Monitor) {
        this.mTgl_Monitor = mTgl_Monitor;
    }

    public String getmUnitup() {
        return mUnitup;
    }

    public void setmUnitup(String mUnitup) {
        this.mUnitup = mUnitup;
    }

    public String getmVerifikasi() {
        return mVerifikasi;
    }

    public void setmVerifikasi(String mVerifikasi) {
        this.mVerifikasi = mVerifikasi;
    }

    public static class LihatDataRowMapper implements RowMapper<LihatData_TBT> {

        @Override
        public LihatData_TBT mapRow(ResultSet rs, int i) throws SQLException {
            LihatData_TBT.LihatDataExtractor lihatDataExtractor = new LihatData_TBT.LihatDataExtractor();
            return lihatDataExtractor.extractData(rs);
        }
    }

    public static class LihatDataExtractor implements ResultSetExtractor<LihatData_TBT> {

        @Override
        public LihatData_TBT extractData(ResultSet rs) throws SQLException, DataAccessException {
            LihatData_TBT data = new LihatData_TBT();

            data.setmBlth(rs.getString(1));
            data.setmIdpel(rs.getString(2));
            data.setmNoMeter(rs.getString(3));
            data.setmNama(rs.getString(4));
            data.setmAlamat(rs.getString(5));
            data.setmTarif(rs.getString(6));
            data.setmDaya(rs.getInt(7));
            data.setmTgl_Bayar(rs.getString(8));
            data.setmBulan(rs.getString(9));
            data.setmStatus_Monitoring(rs.getString(10));
            data.setmKoordinat(rs.getString(11));
            data.setmPetugas_Upload(rs.getString(12));
            data.setmTgl_Monitor(rs.getString(13));
            data.setmVerifikasi(rs.getString(14));
            data.setmApprove(rs.getString(15));
            data.setmPetugas_Verifikasi(rs.getString(16));
            data.setmTgl_Approve(rs.getString(17));
            data.setmUnitup(rs.getString(18));

            return data;
        }
    }

    public static List<LihatData_TBT> getDataListTBT(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where blth='" + pBlth + "' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDetailPelanggan(String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where idpel='" + pIdpel + "' OR nomor_meter='" + pIdpel + "' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT(String pBlth, String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where blth='" + pBlth + "' AND idpel='" + pIdpel + "' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_blth(String pBlth, String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where blth='" + pBlth + "' AND unitup='" + pUnitup + "' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_lebih6() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='>6' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_kurang6() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='<6' order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_lebih6_sudah_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='>6' AND status_monitoring is not null order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_kurang6_sudah_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='<6' AND status_monitoring is not null order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_lebih6_belum_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='>6' AND status_monitoring is null order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_kurang6_belum_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where bulan='<6' AND status_monitoring is null order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + " order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_sudah_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt where status_monitoring is not null"
                + " order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_belum_cek() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt where status_monitoring is null"
                + " order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_TBT> getDataListTBT_Unitup(String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nomor_meter,nama,alamat,tarif,daya,tgl_bayar,bulan,status_monitoring,koordinat, petugas_upload,"
                + " tgl_monitor, verifikasi, approve, petugas_verifikasi, tgl_approve, unitup "
                + "from tbt "
                + "where unitup='" + pUnitup + "'order by idpel,blth,bulan";

        List<LihatData_TBT> list = jdbcTemplate.query(sql, new LihatData_TBT.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
    
     public static int hitungtbt_sudahapprove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where approve is not null"
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
     
      public static int hitungtbt_sudahapprove(String pBlth) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where approve is not null"
                + " AND blth='" + pBlth + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
     
      public static int hitungtbt_belumapprove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where approve is null"
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
      
      public static int hitungtbt_belumapprove(String pBlth) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where approve is null"
                + " AND blth='" + pBlth + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

   
}
