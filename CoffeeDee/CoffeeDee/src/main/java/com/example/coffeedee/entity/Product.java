package com.example.coffeedee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product", schema = "coffee_dee")
public class Product extends BaseEntity{
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "price")
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;


}
