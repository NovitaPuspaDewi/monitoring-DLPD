/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 *
 * @author Agustinus Agri
 */
public class DataPegawai {

    private String mUsernamePegawai;
    private String mPaswordPegawai;
    private String mRolePegawai;
    private String mTingkat;
    private String mKode;
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DatabaseConnection.getmDataSource());

    /**
     * 1 : OPERATOR 2 : ADMIN
     */
    public static class Role {

        public static final String OPERATOR = "OPERATOR";
        public static final String ADMIN = "ADMIN";
    }

    public static class Kode {

        public static final String Kapuas = "22500";
        public static final String PP = "22510";
        public static final String Buntok = "22520";
        public static final String TL = "22530";
        public static final String MT = "22540";
        public static final String PC = "22550";
        public static final String Area = "22";
    }

    public String getmUsernamePegawai() {
        return mUsernamePegawai;
    }

    public void setmUsernamePegawai(String mUsernamePegawai) {
        this.mUsernamePegawai = mUsernamePegawai;
    }

    public String getmPaswordPegawai() {
        return mPaswordPegawai;
    }

    public void setmPaswordPegawai(String mPaswordPegawai) {
        this.mPaswordPegawai = mPaswordPegawai;
    }

    public String getmRolePegawai() {
        return mRolePegawai;
    }

    public void setmRolePegawai(String mRolePegawai) {
        this.mRolePegawai = mRolePegawai;
    }

    public String getmKode() {
        return mKode;
    }

    public void setmKode(String mKode) {
        this.mKode = mKode;
    }

    public String getmTingkat() {
        return mTingkat;
    }

    public void setmTingkat(String mTingkat) {
        this.mTingkat = mTingkat;
    }

    public static void simpanData(DataPegawai pPegawai) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO USER_LOGIN VALUES(?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                new Object[]{
                    pPegawai.getmUsernamePegawai(),
                    pPegawai.getmPaswordPegawai(),
                    pPegawai.getmRolePegawai(),
                    pPegawai.getmTingkat(),
                    pPegawai.getmKode()
                });
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static List<DataPegawai> getDataList() {
        // DataSource dataSource = DatabaseConnection.getmDataSource();
        // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "Select * from user_login";

        List<DataPegawai> list = jdbcTemplate.query(sql, new DataPegawai.PegawaiRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
    }

    public static List<DataPegawai> getDataListByUsername(String pUsername) {
        //  DataSource dataSource = DatabaseConnection.getmDataSource();
        // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "Select * from user_login where username='" + pUsername + "'";

        List<DataPegawai> list = jdbcTemplate.query(sql, new DataPegawai.PegawaiRowMapper());
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return list;
    }

    /**
     * Memvalidasi login user, akan mengembalikan nilai int sesuai dengan hasil
     * validasi
     *
     * @param pUsername username yang diinputkan user
     * @param pPassword password yang diinputkan user
     * @return 0 - unregistered username; 1 - wrong username/password; 2 - login
     * as PEGAWAI accepted; 3 - login as ADMIN accepted;
     */
    public static int validateLoginCredential(String pUsername, String pPassword, String pRole, String pKode_Unit) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "SELECT * FROM USER_LOGIN WHERE username = \'" + pUsername + "\'";

        //   JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<DataPegawai> pegawaiList = jdbcTemplate.query(sql, new DataPegawai.PegawaiRowMapper());

        if (!pegawaiList.isEmpty()) {
            String username = pegawaiList.get(0).getmUsernamePegawai();
            String password = pegawaiList.get(0).getmPaswordPegawai();
            String role = pegawaiList.get(0).getmRolePegawai();
            String tingkat = pegawaiList.get(0).getmTingkat();
            String kode = pegawaiList.get(0).getmKode();

            if (pUsername.equalsIgnoreCase(username) && pPassword.equals(password) && pRole.equals(role) && pKode_Unit.equals(kode)) {
                System.out.println("ROLE : " + role);
                System.out.println("TINGKAT : " + tingkat);
                System.out.println("KODE : " + kode);
                if (kode.equals(Kode.Area)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 2;
                    } else if (role.equals(Role.ADMIN)) {
                        return 3;
                    }
                } else if (kode.equals(Kode.Kapuas)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 30;
                    } else if (role.equals(Role.ADMIN)) {
                        return 20;
                    }
                } else if (kode.equals(Kode.PP)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 31;
                    } else if (role.equals(Role.ADMIN)) {
                        return 21;
                    }
                } else if (kode.equals(Kode.Buntok)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 32;
                    } else if (role.equals(Role.ADMIN)) {
                        return 22;
                    }
                } else if (kode.equals(Kode.TL)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 33;
                    } else if (role.equals(Role.ADMIN)) {
                        return 23;
                    }
                } else if (kode.equals(Kode.MT)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 34;
                    } else if (role.equals(Role.ADMIN)) {
                        return 24;
                    }
                } else if (kode.equals(Kode.PC)) {
                    if (role.equals(Role.OPERATOR)) {
                        return 35;
                    } else if (role.equals(Role.ADMIN)) {
                        return 25;
                    }
                }
            } else {
                System.out.println("WRONG USERNAME/PASSWORD/ROLE");
                return 1;
            }
        } else {
            System.out.println("UNREGISTERED USERNAME");
            return 0;
        }

        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
        return -1;

    }

    public static void updateData(DataPegawai pPegawai) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "UPDATE user_login SET "
                + "username = ?, "
                + "password = ?, "
                + "priviledge = ?,"
                + "tingkat= ?,"
                + "kode_unit=? "
                + "WHERE username = ?";
        // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql,
                new Object[]{
                    pPegawai.getmUsernamePegawai(),
                    pPegawai.getmPaswordPegawai(),
                    pPegawai.getmRolePegawai(),
                    pPegawai.getmTingkat(),
                    pPegawai.getmKode()
                });
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static void deleteData(String pUsername) {
        //DataSource dataSource = DatabaseConnection.getmDataSource();

        String sql = "DELETE FROM USER_LOGIN WHERE username = \'" + pUsername + "\'";
        // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
        JdbcUtils.closeConnection(DatabaseConnection.getmConnection());
    }

    public static class PegawaiRowMapper implements RowMapper<DataPegawai> {

        @Override
        public DataPegawai mapRow(ResultSet rs, int i) throws SQLException {
            PegawaiExtractor pegawaiExtractor = new PegawaiExtractor();
            return pegawaiExtractor.extractData(rs);
        }
    }

    public static class PegawaiExtractor implements ResultSetExtractor<DataPegawai> {

        @Override
        public DataPegawai extractData(ResultSet rs) throws SQLException, DataAccessException {
            DataPegawai pegawai = new DataPegawai();

            pegawai.setmUsernamePegawai(rs.getString(1));
            pegawai.setmPaswordPegawai(rs.getString(2));
            pegawai.setmRolePegawai(rs.getString(3));
            pegawai.setmTingkat(rs.getString(4));
            pegawai.setmKode(rs.getString(5));
            return pegawai;
        }
    }
}
