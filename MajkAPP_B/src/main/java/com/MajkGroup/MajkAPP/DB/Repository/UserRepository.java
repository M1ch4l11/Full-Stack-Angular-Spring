package com.MajkGroup.MajkAPP.DB.Repository;

import com.MajkGroup.MajkAPP.DB.Mapper.UserRowMapper;
import com.MajkGroup.MajkAPP.Domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper = new UserRowMapper();

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(int id){
        final String sql = "SELECT * FROM user WHERE id = " + id;
        try{
            return jdbcTemplate.queryForObject(sql, userRowMapper);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<User> getAll(){
        final String sql = "SELECT * FROM user";
        return  jdbcTemplate.query(sql, userRowMapper);
    }

    public Integer add(User user){
        final String sql = "INSERT INTO user(FullName,LogName,password,email) values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getFullName());
            preparedStatement.setString(2,user.getLogName());
            if(user.getEmail() != null) preparedStatement.setString(4, user.getEmail());
            else preparedStatement.setNull(4, Types.VARCHAR);
            preparedStatement.setString(3,user.getPassword());
             return preparedStatement;
            }
        }, keyHolder);
        if(keyHolder!=null){
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public Integer delete(int id){
        final String sql = "DELETE FROM user WHERE id = ?";
        int value = jdbcTemplate.update(sql, id);
        return value;
    }
}
