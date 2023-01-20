package app.Rest.RestFullApiExample.InventoryData.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
