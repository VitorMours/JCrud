package com.backend.jcrud.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import com.backend.jcrud.services.PaymentService;
import com.backend.jcrud.models.Payment;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    

    @Autowired 
    public PaymentService paymentService;
    


    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping 
    public ResponseEntity<Payment> createPayment(@RequestBody Payment newPayment){
        Payment payment = paymentService.createPayment(newPayment);
        return ResponseEntity.status(201).body(payment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment){
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
