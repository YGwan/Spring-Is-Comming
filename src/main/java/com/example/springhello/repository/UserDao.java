package com.example.springhello.repository;

import java.sql.*;

public class UserDao {

    private final Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public User selectById(Long id) throws SQLException {
        String sql = "SELECT * FROM PERSON WHERE id = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();

        Long idValue = rs.getLong("id");
        String name = rs.getString("name");
        Integer age = rs.getInt("age");
        pstmt.close();
        return new User(idValue, name, age);
    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO PERSON VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setInt(3, user.getAge());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM PERSON WHERE ID=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void updateById(Long id, User user) throws SQLException {
        String sql = "UPDATE PERSON SET NAME = ?, AGE =? WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setLong(2, user.getAge());
        pstmt.setLong(3, id);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
