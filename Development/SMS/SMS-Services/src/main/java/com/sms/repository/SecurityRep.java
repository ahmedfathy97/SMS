package com.sms.repository;

import com.sms.model.security.RegisterDTO;
import com.sms.model.security.RolesVTO;
import com.sms.model.security.RolesVTORM;
import com.sms.model.user.UserVTO;
import com.sms.model.user.rm.UserVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SecurityRep {

    private NamedParameterJdbcTemplate parameterJdbc;

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert userInsert;

    @Autowired
    public SecurityRep(JdbcTemplate jdbc, NamedParameterJdbcTemplate parameterJdbc, DataSource dataSource){
        this.jdbc = jdbc;
        this.parameterJdbc = new NamedParameterJdbcTemplate(dataSource);
        this.userInsert = new SimpleJdbcInsert(dataSource).withTableName("auth_user").usingGeneratedKeyColumns("id");
    }

    public void insertUser(RegisterDTO data){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", data.getUsername());
        parameters.put("user_password", data.getPassword());
        parameters.put("is_active", 1);
        parameters.put("created_on", "15-05-2019");

        int id = this.userInsert.executeAndReturnKey(parameters).intValue();

        String sql = "INSERT INTO user_detail (user_id, first_name, last_name, email ,birth_date ,gender ,phone) " +
                "VALUES (?, ?, ?, ? ,?,?,?)";
        this.jdbc.update(sql, id,data.getFirstName(), data.getLastName(), data.getEmail(),data.getBirthDate() ,data.getGender() ,data.getPhone());

        String sql2 = "INSERT INTO auth_user_role (user_id, role_id) values (?,?);";
        this.jdbc.update(sql2, id , data.getRoleID());

        List<Integer> roleViews =this.getRoleViews(data.getRoleID()) ;
        List<Integer> roleActions =this.getRoleActions(data.getRoleID()) ;

         for ( int  roleView :roleViews )
         {
             String sql3 = "INSERT INTO auth_user_view (user_id ,view_id) values (?,?);";
             this.jdbc.update(sql3, id ,roleView);
         }

        for(int roleAction :roleActions)
        {
            String sql4 = "INSERT INTO auth_user_action (user_id , action_id) values (?,?);";
            this.jdbc.update(sql4, id ,roleAction);
        }



    }


    public UserVTO selectByUserName(String username){
        String sql = "SELECT auth.id, det.first_name, det.last_name, auth.username, auth.user_password, " +
                "det.email " +
                "FROM auth_user auth " +
                "LEFT JOIN user_detail det ON auth.id = det.user_id " +
                "where auth.username = ?";
        List<UserVTO> list = this.jdbc.query(sql, new UserVTORM(), username);

        return (list.size() == 0) ? null: list.get(0);
    }

    public List<Integer> findUserRoles(int userID){
        String sql = "SELECT role_id FROM auth_user_role where user_id = ?";
        List<Integer> list = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("role_id");
            }
        }, userID);

        return list;
    }

    public boolean isUserHasView(int userID, List<Integer> viewIDs){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("userID", userID);
        parameters.addValue("viewIDs", viewIDs);

        String sql = "SELECT user_id FROM auth_user_view WHERE user_id = :userID AND view_id IN (:viewIDs)";

        List result = this.parameterJdbc.query(sql, parameters, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object();
            }
        });

        return result.size() != 0;
    }

    public boolean isUserHasAction(int userID, List<Integer> actionIDs){
        String actionIDsStr = Integer.toString(actionIDs.get(0));
        for (int i=1; i<actionIDs.size(); i++)
            actionIDsStr += ", " + Integer.toString(actionIDs.get(i));

        String sql = "SELECT user_id FROM auth_user_action WHERE user_id = ? AND action_id IN (?)";

        List result = this.jdbc.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Object();
            }
        }, userID, actionIDsStr);

        return result.size() != 0;
    }

    public List<Integer> getUserViews(int userID){
        String sql = "SELECT view_id FROM auth_user_view WHERE user_id = ?";
        List<Integer> result = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("view_id");
            }
        }, userID);

        return result;
    }
    public List<Integer> getUserActions(int userID){
        String sql = "SELECT action_id FROM auth_user_action WHERE user_id = ?";
        List<Integer> result = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("action_id");
            }
        }, userID);

        return result;
    }


    public List<Integer> getRoleViews(int roleID){
        String sql = "SELECT view_id FROM auth_role_view WHERE role_id = ?;";
        List<Integer> result = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("view_id");
            }
        }, roleID);

        return result;
    }


    public List<Integer> getRoleActions(int roleID){
        String sql = "SELECT action_id FROM sms.auth_role_action where role_id =? ;";
        List<Integer> result = this.jdbc.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("action_id");
            }
        }, roleID);

        return result;
    }


    public List<RolesVTO> getAllRoles() throws Exception {
        String sql = "SELECT id ,label_ar  FROM auth_role ";
        List<RolesVTO> rolesVTOList =this.jdbc.query(sql ,new RolesVTORM());
        return  rolesVTOList ;
    }
}
