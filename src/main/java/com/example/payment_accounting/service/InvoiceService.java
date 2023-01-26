package com.example.payment_accounting.service;

import com.example.payment_accounting.model.Payment;
import com.example.payment_accounting.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void registerPayment(Payment payment, String username){
        invoiceRepository.save(payment, username);
    }
    public List<Payment> getAllPayments(String username){
        return invoiceRepository.findAllByUsername(username);

    }
}
