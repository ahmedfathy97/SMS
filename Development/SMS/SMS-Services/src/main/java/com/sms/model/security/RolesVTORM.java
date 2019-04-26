package com.sms.model.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RolesVTORM implements org.springframework.jdbc.core.RowMapper  {
    @Override
    public Object mapRow(ResultSet rs, int rowindex) throws SQLException {
        RolesVTO rolesVTO =new RolesVTO() ;
        rolesVTO.setRoleID(rs.getInt("id"));
        rolesVTO.setRoleName(rs.getString("label_ar"));
        return rolesVTO ;
    }
}
