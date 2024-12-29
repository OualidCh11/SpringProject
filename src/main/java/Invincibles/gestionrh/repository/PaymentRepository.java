package Invincibles.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Invincibles.gestionrh.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p WHERE p.id = :id")
    Payment getPaymentById(@Param("id") int id);

    @Query("SELECT p FROM Payment p")
    List<Payment> getAllPayments();
}
