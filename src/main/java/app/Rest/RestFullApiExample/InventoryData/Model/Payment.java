package app.Rest.RestFullApiExample.InventoryData.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (getId() != null ? !getId().equals(payment.getId()) : payment.getId() != null) return false;
        if (getAmount() != null ? !getAmount().equals(payment.getAmount()) : payment.getAmount() != null) return false;
        if (getPaymentDate() != null ? !getPaymentDate().equals(payment.getPaymentDate()) : payment.getPaymentDate() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(payment.getCustomer()) : payment.getCustomer() != null)
            return false;
        if (getStaff() != null ? !getStaff().equals(payment.getStaff()) : payment.getStaff() != null) return false;
        return getRental() != null ? getRental().equals(payment.getRental()) : payment.getRental() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getPaymentDate() != null ? getPaymentDate().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getStaff() != null ? getStaff().hashCode() : 0);
        result = 31 * result + (getRental() != null ? getRental().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
