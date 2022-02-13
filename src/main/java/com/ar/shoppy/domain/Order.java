package com.ar.shoppy.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String orderId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "client_client_id")
    private Client client;
    private List<File> files;
    private Date orderDate = new Date();
    private Date endDate;
    private String requirements;
    private String status;
}
