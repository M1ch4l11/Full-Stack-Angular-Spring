package com.MajkGroup.MajkAPP.DB.Mapper;

import com.MajkGroup.MajkAPP.Domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setLogName(rs.getString("LogName"));
        user.setFullName(rs.getString("FullName"));
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
