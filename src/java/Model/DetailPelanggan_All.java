/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 *
 * @author NOVITA
 */
public class DetailPelanggan_All {

    private String mBlth;
    private String mNama;
    private String mAlamat;
    private String mTarif;
    private String mStatus;
    private String mIdpel;
    private int mDaya;
    private int mKwhMaks;
    private int mKwhTot;
    private String mKoordinat;
    private String mTgl_Monitoring;
    private String mVerifikasi;
    private String mUnitup;
    private String mApprove;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    public String getmAlamat() {
        return mAlamat;
    }

    public void setmAlamat(String mAlamat) {
        this.mAlamat = mAlamat;
    }

    public String getmBlth() {
        return mBlth;
    }

    public void setmBlth(String mBlth) {
        this.mBlth = mBlth;
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

    public int getmKwhMaks() {
        return mKwhMaks;
    }

    public void setmKwhMaks(int mKwhMaks) {
        this.mKwhMaks = mKwhMaks;
    }

    public int getmKwhTot() {
        return mKwhTot;
    }

    public void setmKwhTot(int mKwhTot) {
        this.mKwhTot = mKwhTot;
    }

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmTarif() {
        return mTarif;
    }

    public void setmTarif(String mTarif) {
        this.mTarif = mTarif;
    }

    public String getmKoordinat() {
        return mKoordinat;
    }

    public void setmKoordinat(String mKoordinat) {
        this.mKoordinat = mKoordinat;
    }

    public String getmTgl_Monitoring() {
        return mTgl_Monitoring;
    }

    public void setmTgl_Monitoring(String mTgl_Monitoring) {
        this.mTgl_Monitoring = mTgl_Monitoring;
    }

    public String getmVerifikasi() {
        return mVerifikasi;
    }

    public void setmVerifikasi(String mVerifikasi) {
        this.mVerifikasi = mVerifikasi;
    }

    public String getmUnitup() {
        return mUnitup;
    }

    public void setmUnitup(String mUnitup) {
        this.mUnitup = mUnitup;
    }

    public String getmApprove() {
        return mApprove;
    }

    public void setmApprove(String mApprove) {
        this.mApprove = mApprove;
    }
                
    public static class DetailRowMapper implements RowMapper<DetailPelanggan_All> {

        @Override
        public DetailPelanggan_All mapRow(ResultSet rs, int i) throws SQLException {
            DetailPelanggan_All.DetailExtractor detailExtractor = new DetailPelanggan_All.DetailExtractor();
            return detailExtractor.extractData(rs);
        }
    }

    public static class DetailExtractor implements ResultSetExtractor<DetailPelanggan_All> {

        @Override
        public DetailPelanggan_All extractData(ResultSet rs) throws SQLException, DataAccessException {
            DetailPelanggan_All data = new DetailPelanggan_All();

            data.setmBlth(rs.getString(1));
            data.setmIdpel(rs.getString(2));
            data.setmNama(rs.getString(3));
            data.setmAlamat(rs.getString(4));
            data.setmTarif(rs.getString(5));
            data.setmDaya(rs.getInt(6));
            data.setmKwhMaks(rs.getInt(7));
            data.setmKwhTot(rs.getInt(8));
            data.setmStatus(rs.getString(9));
            data.setmKoordinat(rs.getString(10));
            data.setmVerifikasi(rs.getString(11));
            data.setmTgl_Monitoring(rs.getString(12));
            data.setmUnitup(rs.getString(13));
            data.setmApprove(rs.getString(14));

            return data;
        }
    }
    
     public static List<DetailPelanggan_All> getDataListPelanggan(String pIDPEL) {
       // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,koordinat,verifikasi,tgl_monitor,unitup,approve "
                + "from dpm "
                + "where idpel='" + pIDPEL + "' order by idpel,blth";

        List<DetailPelanggan_All> list = jdbcTemplate.query(sql, new DetailPelanggan_All.DetailRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<DetailPelanggan_All> getDataListKwh0(String pIDPEL) {
       // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,koordinat,verifikasi,tgl_monitor,unitup,approve  "
                + "from dpm "
                + "where totkwh=0 AND idpel='" + pIDPEL + "' order by idpel,blth";

        List<DetailPelanggan_All> list = jdbcTemplate.query(sql, new DetailPelanggan_All.DetailRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<DetailPelanggan_All> getDataListKwhMaks(String pIDPEL) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,koordinat,verifikasi,tgl_monitor,unitup,approve  "
                + "from dpm "
                + "where totkwh>kwh_maks AND idpel='" + pIDPEL + "' order by idpel,blth";

        List<DetailPelanggan_All> list = jdbcTemplate.query(sql, new DetailPelanggan_All.DetailRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<DetailPelanggan_All> getDataListKwh0_perbulan(String pIDPEL, String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,koordinat,verifikasi,tgl_monitor,unitup,approve  "
                + "from dpm "
                + "where totkwh=0 AND blth='" + pBlth + "' AND idpel='" + pIDPEL + "' order by idpel,blth";

        List<DetailPelanggan_All> list = jdbcTemplate.query(sql, new DetailPelanggan_All.DetailRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<DetailPelanggan_All> getDataListKwhMaks_perbulan(String pIDPEL, String pBlth) {
       // DataSource dataSource = DatabaseConnection.getmDataSource();
        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,koordinat,verifikasi,tgl_monitor,unitup,approve  "
                + "from dpm "
                + "where totkwh>kwh_maks AND blth='" + pBlth + "' AND idpel='" + pIDPEL + "' order by idpel,blth";

        List<DetailPelanggan_All> list = jdbcTemplate.query(sql, new DetailPelanggan_All.DetailRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
}
