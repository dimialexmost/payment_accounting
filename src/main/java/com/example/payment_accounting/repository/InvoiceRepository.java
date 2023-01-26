package com.example.payment_accounting.repository;

import com.example.payment_accounting.model.Payment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceRepository {

    private Connection connection;

    public InvoiceRepository(Connection connection) {
        this.connection = connection;
    }
    public void save(Payment payment, String username){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into invoices values (default, ?,?,?,?,?,?)");
            preparedStatement.setString(2, payment.getTitle());
            preparedStatement.setDate(3, payment.getDate());
            preparedStatement.setString(4, payment.getDescription());
            preparedStatement.setString(1, payment.getCategory());
            preparedStatement.setDouble(5, payment.getSum());
            preparedStatement.setString(6, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Payment> findAllByUsername(String username){
        List<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from invoices WHERE author=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("id"));
                payment.setCategory(resultSet.getString("category"));
                payment.setTitle(resultSet.getString("title"));
                payment.setDate(resultSet.getDate("date"));
                payment.setDescription(resultSet.getString("description"));
                payment.setSum(resultSet.getDouble("sum"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return payments;

    }
}
