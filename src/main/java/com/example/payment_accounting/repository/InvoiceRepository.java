package com.example.payment_accounting.repository;

import com.example.payment_accounting.model.Payment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

@Component
public class InvoiceRepository {

    private Connection connection;

    public InvoiceRepository(Connection connection) {
        this.connection = connection;
    }
    public void save(Payment payment){

    }
    public List<Payment> findAllByUsername(){
        return null;
    }
}
