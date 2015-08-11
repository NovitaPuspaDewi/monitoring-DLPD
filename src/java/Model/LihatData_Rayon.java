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
public class LihatData_Rayon {

    private String mBlth;
    private String mNama;
    private String mAlamat;
    private String mTarif;
    private String mStatus;
    private String mIdpel;
    private String mUnitup;
    private int mDaya;
    private int mKwhMaks;
    private int mKwhTot;
    private String mApprove;
    private String mVerifikasi;
    private String mKoordinat;
    private String mTglMonitor;
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

    public String getmKoordinat() {
        return mKoordinat;
    }

    public void setmKoordinat(String mKoordinat) {
        this.mKoordinat = mKoordinat;
    }

    public String getmTglMonitor() {
        return mTglMonitor;
    }

    public void setmTglMonitor(String mTglMonitor) {
        this.mTglMonitor = mTglMonitor;
    }

    public String getmVerifikasi() {
        return mVerifikasi;
    }

    public void setmVerifikasi(String mVerifikasi) {
        this.mVerifikasi = mVerifikasi;
    }
        
    public static class LihatDataRowMapper implements RowMapper<LihatData_Rayon> {

        @Override
        public LihatData_Rayon mapRow(ResultSet rs, int i) throws SQLException {
            LihatData_Rayon.LihatDataExtractor lihatDataExtractor = new LihatData_Rayon.LihatDataExtractor();
            return lihatDataExtractor.extractData(rs);
        }
    }

    public static class LihatDataExtractor implements ResultSetExtractor<LihatData_Rayon> {

        @Override
        public LihatData_Rayon extractData(ResultSet rs) throws SQLException, DataAccessException {
            LihatData_Rayon data = new LihatData_Rayon();

            data.setmBlth(rs.getString(1));
            data.setmIdpel(rs.getString(2));
            data.setmNama(rs.getString(3));
            data.setmAlamat(rs.getString(4));
            data.setmTarif(rs.getString(5));
            data.setmDaya(rs.getInt(6));
            data.setmKwhMaks(rs.getInt(7));
            data.setmKwhTot(rs.getInt(8));
            data.setmStatus(rs.getString(9));
            data.setmUnitup(rs.getString(10));
            data.setmApprove(rs.getString(11));
            data.setmVerifikasi(rs.getString(12));
            data.setmKoordinat(rs.getString(13));
            data.setmTglMonitor(rs.getString(14));

            return data;
        }
    }

    public static List<LihatData_Rayon> getDataListKwh0(String pBlth, String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND blth='" + pBlth + "' AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_Rayon> getDataListKwh0_Semua(String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_Rayon> getDataListKwhMaks_Semua(String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_Rayon> getDataListKwhMaks(String pBlth, String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND blth='" + pBlth + "' AND unitup= '" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_Rayon> getDataList_ByUsername_kwhMaks(String pIdpel) {
        //  DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND idpel='" + pIdpel + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<LihatData_Rayon> getDataList_ByUsername_kwh0(String pIdpel) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND idpel='" + pIdpel + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    public static List<LihatData_Rayon> getDataList_ByUsername_belumcek_kwh0(String pIdpel, String pBlth) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND idpel='" + pIdpel + "' AND blth='" + pBlth + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    public static List<LihatData_Rayon> getDataList_ByUsername_belumcek_kwhmaks(String pIdpel, String pBlth) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND idpel='" + pIdpel + "' AND blth='" + pBlth + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    public static List<LihatData_Rayon> getDataList_kwh0_belum_cek(String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND status_monitoring is null AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    public static List<LihatData_Rayon> getDataList_kwhmaks_belum_cek(String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND status_monitoring is null AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    public static int hitungKwh0(String pBlth, String pUnitup) {
        //DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhMaks(String pBlth, String pUnitup) {
        //  DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks and blth=? AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, pBlth);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhMaks_semua(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks and unitup=?";
        // JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, pUnitup);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_semua(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 and unitup=?";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, pUnitup);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_belumcek(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND status_monitoring is null and unitup=?";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, pUnitup);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhmaks_belumcek(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND status_monitoring is null and unitup=?";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, pUnitup);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    //baru
    public static List<LihatData_Rayon> getDataList_kwhmaks_sudah_cek(String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND status_monitoring is not null AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }
    //baru

    public static List<LihatData> getDataList_kwhmaks_sudah_cek(String pBlth, String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh>kwh_maks AND status_monitoring is not null AND blth='" + pBlth + "' AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData> list = jdbcTemplate.query(sql, new LihatData.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    //baru
    public static List<LihatData_Rayon> getDataList_kwh0_sudah_cek(String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND status_monitoring is not null AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData_Rayon> list = jdbcTemplate.query(sql, new LihatData_Rayon.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    //baru
    public static List<LihatData> getDataList_kwh0_sudah_cek(String pBlth, String pUnitup) {
        // DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring,unitup,approve,verifikasi,koordinat,tgl_monitor  "
                + "from dpm "
                + "where totkwh=0 AND status_monitoring is not null AND blth='" + pBlth + "' AND unitup='" + pUnitup + "' order by idpel,blth";

        List<LihatData> list = jdbcTemplate.query(sql, new LihatData.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;

    }

    //baru
    public static int hitungKwh0_belumcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND status_monitoring is null"
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

    public static int hitungKwhmaks_belumcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND status_monitoring is null"
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

    public static int hitungKwh0_sudahcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND status_monitoring is not null"
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

    public static int hitungKwhmaks_sudahcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND status_monitoring is not null"
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
    
    public static int hitungKwh0_sudahcek(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND status_monitoring is not null"
                + " AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhmaks_sudahcek( String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND status_monitoring is not null"
                + " AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_belumApprove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is null"
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

    public static int hitungKwhmaks_belumApprove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is null"
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

    public static int hitungKwh0_sudahAprrove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is not null"
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

    public static int hitungKwhmaks_sudahApprove(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is not null"
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
}
