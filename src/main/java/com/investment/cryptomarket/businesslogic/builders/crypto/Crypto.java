package com.investment.cryptomarket.businesslogic.builders.crypto;

import javax.persistence.*;

@Entity
@Table(name = "crypto")
public class Crypto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "currency", nullable = false, unique = true)
    private Double currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crypto product = (Crypto) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        return currency != null ? currency.equals(product.currency) : product.currency == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
