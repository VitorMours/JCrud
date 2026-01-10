package com.backend.jcrud.services;

import java.util.List;
import com.backend.jcrud.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.jcrud.repositories.PaymentRepository;


@Service
public class PaymentService {

    @Autowired 
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    public Payment getPaymentById(Long id){
        Payment payment = paymentRepository.findById(id).orElse(null);
        return payment;
    }

    public Payment createPayment(Payment newPayment){
        Payment payment = paymentRepository.save(newPayment);
        return payment;
    }

    public Payment updatePayment(Long id, Payment paymentBody){
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null){
            payment.setMoment(paymentBody.getMoment());
            paymentRepository.save(payment);
            return payment;
        }
        return null;
    }

    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
    }
}
