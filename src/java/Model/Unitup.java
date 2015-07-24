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
public class Unitup {

    private String pUnitup;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    public String getpUnitup() {
        return pUnitup;
    }

    public void setpUnitup(String pUnitup) {
        this.pUnitup = pUnitup;
    }
    
    public static class LihatDataRowMapper implements RowMapper<Unitup> {

        @Override
        public Unitup mapRow(ResultSet rs, int i) throws SQLException {
            Unitup.LihatDataExtractor lihatDataExtractor = new Unitup.LihatDataExtractor();
            return lihatDataExtractor.extractData(rs);
        }
    }

    public static class LihatDataExtractor implements ResultSetExtractor<Unitup> {

        @Override
        public Unitup extractData(ResultSet rs) throws SQLException, DataAccessException {
            Unitup data = new Unitup();

            data.setpUnitup(rs.getString(1));
           
            return data;
        }
    }

    public static List<Unitup> getDataList_Unitup_tbt() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select distinct unitup from tbt order by unitup asc";

        List<Unitup> list = jdbcTemplate.query(sql, new Unitup.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
    }

    public static List<Unitup> getDataList_Unitup_dpm() {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select distinct unitup from dpm order by unitup asc";

        List<Unitup> list = jdbcTemplate.query(sql, new Unitup.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
    }
  
}
