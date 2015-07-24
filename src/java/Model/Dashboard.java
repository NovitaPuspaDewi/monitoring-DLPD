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
public class Dashboard {

    private String pBlth;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    public String getpBlth() {
        return pBlth;
    }

    public void setpBlth(String pBlth) {
        this.pBlth = pBlth;
    }

    public static class LihatDataRowMapper implements RowMapper<Dashboard> {

        @Override
        public Dashboard mapRow(ResultSet rs, int i) throws SQLException {
            Dashboard.LihatDataExtractor lihatDataExtractor = new Dashboard.LihatDataExtractor();
            return lihatDataExtractor.extractData(rs);
        }
    }

    public static class LihatDataExtractor implements ResultSetExtractor<Dashboard> {

        @Override
        public Dashboard extractData(ResultSet rs) throws SQLException, DataAccessException {
            Dashboard data = new Dashboard();

            data.setpBlth(rs.getString(1));
           
            return data;
        }
    }

    public static List<Dashboard> cari_bulan_terakhir() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select max(blth) from tbt";

        List<Dashboard> list = jdbcTemplate.query(sql, new Dashboard.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
    }

    public static List<Dashboard> cari_bulan_terakhir_dpm() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select max(blth) from dpm";

        List<Dashboard> list = jdbcTemplate.query(sql, new Dashboard.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_sudahcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 AND status_monitoring is not null"
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
//          JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhmaks_sudahapprove(String pBlth, String pUnitup) {
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_sudahapprove(String pBlth, String pUnitup) {
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwhmaks_belumapprove(String pBlth, String pUnitup) {
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungKwh0_belumapprove(String pBlth, String pUnitup) {
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungtbt_belumcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where status_monitoring is null"
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

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
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungtbt_sudahcek(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where status_monitoring is not null"
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitungtbt(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from tbt where "
                + "blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitung_kwh0(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh=0 "
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }

    public static int hitung_kwhmaks(String pBlth, String pUnitup) {
        // DataSource datasource = DatabaseConnection.getmDataSource();
        int count;

        String sql = "select count(idpel) from dpm where totkwh>kwh_maks "
                + " AND blth='" + pBlth + "' AND unitup='" + pUnitup + "'";
        //  JdbcTemplate jdbc = new JdbcTemplate(datasource);

        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception ex) {
            count = 0;
        }
//        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return count;

    }
}
