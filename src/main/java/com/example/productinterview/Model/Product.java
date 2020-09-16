package com.example.productinterview.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 15)
    private String name;
    @Column(nullable = false, unique = true)
    private Date date;
    @Column(nullable = false)
    private Double price;

}
