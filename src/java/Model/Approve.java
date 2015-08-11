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
public class Approve {

    private String mBlth;
    private String mNama;
    private String mAlamat;
    private String mTarif;
    private String mStatus;
    private String mIdpel;
    private int mDaya;
    private int mKwhMaks;
    private int mKwhTot;
    private String mPetugas_Upload;
    private String mStatusApprove;
    private String mPetugas_Approve;
    private String mVerifikasi;
    private String mTgl_Monitoring;
    private String mKoordinat;
    private String mUnitup;
    private String mTgl_Approve;
    private String mFoto;
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

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        Approve.jdbcTemplate = jdbcTemplate;
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

    public String getmPetugas_Approve() {
        return mPetugas_Approve;
    }

    public void setmPetugas_Approve(String mPetugas_Approve) {
        this.mPetugas_Approve = mPetugas_Approve;
    }

    public String getmPetugas_Upload() {
        return mPetugas_Upload;
    }

    public void setmPetugas_Upload(String mPetugas_Upload) {
        this.mPetugas_Upload = mPetugas_Upload;
    }

    public String getmStatusApprove() {
        return mStatusApprove;
    }

    public void setmStatusApprove(String mStatusApprove) {
        this.mStatusApprove = mStatusApprove;
    }

    public String getmVerifikasi() {
        return mVerifikasi;
    }

    public void setmVerifikasi(String mVerifikasi) {
        this.mVerifikasi = mVerifikasi;
    }

    public String getmTgl_Monitoring() {
        return mTgl_Monitoring;
    }

    public void setmTgl_Monitoring(String mTgl_Monitoring) {
        this.mTgl_Monitoring = mTgl_Monitoring;
    }

    public String getmKoordinat() {
        return mKoordinat;
    }

    public void setmKoordinat(String mKoordinat) {
        this.mKoordinat = mKoordinat;
    }

    public String getmUnitup() {
        return mUnitup;
    }

    public void setmUnitup(String mUnitup) {
        this.mUnitup = mUnitup;
    }

    public String getmTgl_Approve() {
        return mTgl_Approve;
    }

    public void setmTgl_Approve(String mTgl_Approve) {
        this.mTgl_Approve = mTgl_Approve;
    }

    public String getmFoto() {
        return mFoto;
    }

    public void setmFoto(String mFoto) {
        this.mFoto = mFoto;
    }

    public static class ApproveRowMapper implements RowMapper<Approve> {

        @Override
        public Approve mapRow(ResultSet rs, int i) throws SQLException {
            Approve.ApproveExtractor approveExtractor = new Approve.ApproveExtractor();
            return approveExtractor.extractData(rs);
        }
    }

    public static class ApproveExtractor implements ResultSetExtractor<Approve> {

        @Override
        public Approve extractData(ResultSet rs) throws SQLException, DataAccessException {
            Approve data = new Approve();

            data.setmBlth(rs.getString(1));
            data.setmIdpel(rs.getString(2));
            data.setmNama(rs.getString(3));
            data.setmAlamat(rs.getString(4));
            data.setmTarif(rs.getString(5));
            data.setmDaya(rs.getInt(6));
            data.setmKwhMaks(rs.getInt(7));
            data.setmKwhTot(rs.getInt(8));
            data.setmStatus(rs.getString(9));
            data.setmVerifikasi(rs.getString(10));
            data.setmPetugas_Upload(rs.getString(11));
            data.setmStatusApprove(rs.getString(12));
            data.setmPetugas_Approve(rs.getString(13));
            data.setmTgl_Monitoring(rs.getString(14));
            data.setmKoordinat(rs.getString(15));
            data.setmUnitup(rs.getString(16));
            data.setmTgl_Approve(rs.getString(17));
            data.setmFoto(rs.getString(18));

            return data;
        }
    }

    public static List<Approve> getDataListCekSemua_Kwh0() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDetailApprove_0(String pBlth, String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 and idpel ='" + pIdpel + "' and blth='" + pBlth + "' order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDetailApprove_Maks(String pBlth, String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks and idpel ='" + pIdpel + "' and blth='" + pBlth + "' order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwh0(String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 AND unitup='" + pUnitup + "' order by idpel,blth ";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_KwhMaks(String pUnitup) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks AND unitup='" + pUnitup + "' order by idpel,blth ";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_KwhMaks() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_KwhMaks_belumApprove() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks AND approve is null AND status_monitoring is not null"
                + " order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwh0_belumApprove() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 AND approve is null AND status_monitoring is not null "
                + "order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwh0_belumApprove(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 AND approve is null AND status_monitoring is not null AND blth='" + pBlth + "' "
                + "order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwhmaks_belumApprove(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks AND approve is null AND status_monitoring is not null AND blth='" + pBlth + "' "
                + "order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwh0_SudahApprove() {

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 AND approve is not null "
                + "order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_KwhMaks_SudahApprove() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks AND approve is not null "
                + "order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_Kwh0_SudahApprove(String pBlth) {

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 AND approve is not null AND blth='" + pBlth + "'"
                + "order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekSemua_KwhMaks_SudahApprove(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks AND approve is not null AND blth='" + pBlth + "'"
                + "order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekData_Yang_Sama_Kwh0() {

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where idpel in (select distinct idpel from dpm where approve is not null and totkwh=0)"
                + " and approve is null and totkwh=0 "
                + "order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekData_Yang_Sama_KwhMaks() {

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where idpel in (select distinct idpel from dpm where approve is not null and totkwh>kwh_maks)"
                + " and approve is null and totkwh>kwh_maks "
                + "order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static int hitungKwh0_yangsama() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where "
                + "idpel in (select distinct idpel from dpm where approve is not null AND totkwh=0)"
                + " and approve is null and totkwh=0";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhMaks_yangsama() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where "
                + "idpel in (select distinct idpel from dpm where approve is not null and totkwh>kwh_maks)"
                + " and approve is null and totkwh>kwh_maks";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_belumcek_maks() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_sudahcek_maks() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is not null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_belumcek_0() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_belumcek_sudahmonitor_0() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is null AND status_monitoring is not null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_belumcek_sudahmonitor_maks() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is null AND status_monitoring is not null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_sudahcek_0() {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is not null";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
    //BARU

    public static int hitungApprove_sudahcek_0_unitup(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is not null"
                + " AND unitup='" + pUnitup + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
    //BARU

    public static int hitungApprove_belumcek_0_unitup(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is null"
                + " AND unitup='" + pUnitup + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
    //BARU

    public static int hitungApprove_sudahcek_maks_unitup(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is not null"
                + " AND unitup='" + pUnitup + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    //BARU
    public static int hitungApprove_belumcek_maks_unitup(String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is null"
                + " AND unitup='" + pUnitup + "' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_sudahcek_maks(String pBlth) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks AND approve is not null"
                + " AND tgl_approve LIKE '%" + pBlth + "%' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungApprove_sudahcek_0(String pBlth) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND approve is not null"
                + " AND tgl_approve LIKE '%" + pBlth + "%' ";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

//    public static List<Approve> getDataListCekSemua_kwh0() {
//        //DataSource dataSource = DatabaseConnection.getmDataSource();
//
//        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
//                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat "
//                + "from dpm "
//                + "where totkwh=0";
//
//        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
//
//        return list;
//    }
//
//    public static List<Approve> getDataListCekSemua_kwhMaks() {
//        //DataSource dataSource = DatabaseConnection.getmDataSource();
//
//        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring "
//                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor ,koordinat "
//                + "from dpm "
//                + "where totkwh>kwh_maks";
//
//        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
//
//        return list;
//    }
    public static List<Approve> getDataListCekPelanggan_kwh0(String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 and approve is not null and "
                + "idpel='" + pIdpel + "' order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static List<Approve> getDataListCekPelanggan_kwhMaks(String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks and approve is not null"
                + " and idpel='" + pIdpel + "' order by idpel,blth";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
    //BARU

    public static List<Approve> getDataListCekApprove_blth_kwh0(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh=0 and approve is not null and "
                + "tgl_approve LIKE '%" + pBlth + "%' order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
    //BARU

    public static List<Approve> getDataListCekApprove_blth_kwhMaks(String pBlth) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select blth,idpel,nama,alamat,tarif,daya,kwh_maks,totkwh,status_monitoring, "
                + "verifikasi,petugas_upload,approve,petugas_verifikasi,tgl_monitor,koordinat,unitup,tgl_approve,foto "
                + "from dpm "
                + "where totkwh>kwh_maks and approve is not null and "
                + "tgl_approve LIKE '%" + pBlth + "%' order by tgl_approve desc,idpel";

        List<Approve> list = jdbcTemplate.query(sql, new Approve.ApproveRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }

    public static void Approve_Biasa(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update DPM set PETUGAS_VERIFIKASI=?, approve='OK', tgl_approve=(to_char(sysdate, 'dd-mm-yyyy')) where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmPetugas_Approve(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void Approve_Biasa_TBT(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update tbt set PETUGAS_VERIFIKASI=?, approve='OK', tgl_approve=(to_char(sysdate, 'dd-mm-yyyy')) where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmPetugas_Approve(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void Approve_Langsung(Approve pelanggan) {
        //DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update DPM set PETUGAS_VERIFIKASI=?, approve='OK', status_monitoring='SUDAH MONITORING',"
                + " tgl_monitor=?, petugas_upload=?, verifikasi=?, koordinat=?,foto=?, tgl_approve=(to_char(sysdate, 'dd-mm-yyyy')) where idpel=? and blth=?";

        // JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmPetugas_Approve(),
                    pelanggan.getmTgl_Monitoring(),
                    pelanggan.getmPetugas_Upload(),
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmKoordinat(),
                    pelanggan.getmFoto(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });
        System.out.println("updated");
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void Approve_Langsung_tbt(Approve pelanggan) {
        //DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update TBT set PETUGAS_VERIFIKASI=?, approve='OK', status_monitoring='SUDAH MONITORING',"
                + " tgl_monitor=?, petugas_upload=?, verifikasi=?, koordinat=?, foto=?, tgl_approve=(to_char(sysdate, 'dd-mm-yyyy')) where idpel=? and blth=?";

        // JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmPetugas_Approve(),
                    pelanggan.getmTgl_Monitoring(),
                    pelanggan.getmPetugas_Upload(),
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmKoordinat(),
                    pelanggan.getmFoto(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void sudah_monitor_dpm(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update DPM set status_monitoring='SUDAH MONITORING', tgl_monitor=?,"
                + " petugas_upload=?, verifikasi=?, koordinat=? where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmTgl_Monitoring(),
                    pelanggan.getmPetugas_Upload(),
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmKoordinat(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void sudah_monitor_tbt(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update TBT set status_monitoring='SUDAH MONITORING', tgl_monitor=?,"
                + " petugas_upload=?, verifikasi=?, koordinat=? where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmTgl_Monitoring(),
                    pelanggan.getmPetugas_Upload(),
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmKoordinat(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void simpan_foto_dpm(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update dpm set foto=? where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmFoto(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void simpan_foto_tbt(Approve pelanggan) {
        // DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update tbt set foto=? where idpel=? and blth=?";

        //JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmFoto(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void Batal_Approve(Approve pelanggan) {
        //DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update DPM set approve=null, status_monitoring=null,"
                + " verifikasi=? where idpel=? and blth=?";

        // JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });
        System.out.println("updated");
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }
    
    public static void Batal_Approve_TBT(Approve pelanggan) {
        //DataSource datasorce = DatabaseConnection.getmDataSource();
        String sql = "update TBT set approve=null, status_monitoring=null,"
                + " verifikasi=? where idpel=? and blth=?";

        // JdbcTemplate jdbc = new JdbcTemplate(datasorce);
        jdbcTemplate.update(sql, new Object[]{
                    pelanggan.getmVerifikasi(),
                    pelanggan.getmIdpel(),
                    pelanggan.getmBlth()
                });
        System.out.println("updated");
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }
}
