package com.example.payment_accounting.controller;

import com.example.payment_accounting.model.Payment;
import com.example.payment_accounting.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String showInvoiceTable(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/home";
        } else {
            List<Payment> payments = invoiceService.getAllPayments(username);
            model.addAttribute("payments", payments);
            return "InvoicePage";
        }
    }

    @GetMapping("/new")
    public String createPayment(@ModelAttribute("payment") Payment payment, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/home";
        } else {
            return "PaymentPage";
        }

    }

    @PostMapping("/new")
    public String addPayment(HttpSession session, @ModelAttribute("payment") Payment payment) {
        String username = (String) session.getAttribute("username");

        invoiceService.registerPayment(payment, username);

        return "redirect:/invoice";
    }
}
