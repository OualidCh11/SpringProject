package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Payment;
import Invincibles.gestionrh.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
        		
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(int id, Payment updatedPayment) {
        Payment existingPayment = getPaymentById(id);

        // Mise à jour des attributs du paiement existant avec les attributs du paiement mis à jour
        existingPayment.setMois(updatedPayment.getMois());
        existingPayment.setMontant_payment(updatedPayment.getMontant_payment());
        existingPayment.setDate_payment(updatedPayment.getDate_payment());
        existingPayment.setStatus(updatedPayment.isStatus());
        existingPayment.setEmploye(updatedPayment.getEmploye());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return paymentRepository.save(existingPayment);
    }

    public void deletePayment(int id) {
        Payment existingPayment = getPaymentById(id);
        paymentRepository.delete(existingPayment);
    }
}
