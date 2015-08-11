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
public class Display_Foto {

    private String mFoto;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    public String getmFoto() {
        return mFoto;
    }

    public void setmFoto(String mFoto) {
        this.mFoto = mFoto;
    }

    public static class LihatDataRowMapper implements RowMapper<Display_Foto> {

        @Override
        public Display_Foto mapRow(ResultSet rs, int i) throws SQLException {
            Display_Foto.LihatDataExtractor lihatDataExtractor = new Display_Foto.LihatDataExtractor();
            return lihatDataExtractor.extractData(rs);
        }
    }

    public static class LihatDataExtractor implements ResultSetExtractor<Display_Foto> {

        @Override
        public Display_Foto extractData(ResultSet rs) throws SQLException, DataAccessException {
            Display_Foto data = new Display_Foto();

            data.setmFoto(rs.getString(1));

            return data;
        }
    }

    public static List<Display_Foto> getFoto_Dpm(String pBlth,String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select foto from dpm "
                + "where blth='" + pBlth + "' and idpel='"+pIdpel+"'";

        List<Display_Foto> list = jdbcTemplate.query(sql, new Display_Foto.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
    
     public static List<Display_Foto> getFoto_Tbt(String pBlth,String pIdpel) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "Select foto from tbt "
                + "where blth='" + pBlth + "' and idpel='"+pIdpel+"'";

        List<Display_Foto> list = jdbcTemplate.query(sql, new Display_Foto.LihatDataRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());

        return list;
    }
}
