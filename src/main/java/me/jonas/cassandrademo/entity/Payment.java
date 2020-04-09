package me.jonas.cassandrademo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalTime;
import java.util.UUID;

@Table
public class Payment {
    @PrimaryKey
    private UUID paymentId = UUID.randomUUID();
    private String total;

    private String customer;
    private String merchant;
    private LocalTime created = LocalTime.now();

    public Payment() {
    }

    public Payment(String total, String customer, String merchant) {
        this.total = total;
        this.customer = customer;
        this.merchant = merchant;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public LocalTime getCreated() {
        return created;
    }

    public void setCreated(LocalTime created) {
        this.created = created;
    }
}
