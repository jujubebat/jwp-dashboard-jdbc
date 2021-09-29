package com.techcourse.dao;

import com.techcourse.domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class InsertJdbcTemplate extends JdbcTemplate {

    private final DataSource dataSource;
    private User user;

    public InsertJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected DataSource getDatasource() {
        return dataSource;
    }

    @Override
    protected String createQuery() {
        return "insert into users (account, password, email) values (?, ?, ?)";
    }

    @Override
    protected void setValues(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, user.getAccount());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getEmail());
    }

    public void setInsertUser(User user) {
        this.user = user;
    }

    @Override
    protected Object mapRow(ResultSet rs) {
        return null;
    }
}
