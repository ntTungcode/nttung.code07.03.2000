package com.example.coffeedee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "category", schema = "coffee_dee")
public class Category extends BaseEntity{
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @Basic
    @Column(name = "description")
    private String description;
}
