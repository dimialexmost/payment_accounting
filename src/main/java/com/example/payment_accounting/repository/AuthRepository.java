package com.example.payment_accounting.repository;

import com.example.payment_accounting.model.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class AuthRepository {
    private Connection connection;

    public AuthRepository(Connection connection) {
        this.connection = connection;
    }

    public User findAllByUsername(User user){
        User actualUser = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users WHERE username=?");
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                actualUser = new User();
                actualUser.setUsername(resultSet.getString("username"));
                actualUser.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actualUser;

    }
}