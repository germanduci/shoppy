package com.ar.shoppy.domain;

import com.ar.shoppy.enums.orderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="orden")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String orderId;
    private String orderName;
    @OneToOne
    private Client orderClient;
    @OneToMany
    private List<File> orderFiles;
    @Temporal(value=TemporalType.DATE)
    private Date orderDate = new Date();
    private Date orderEndDate;
    private String orderRequirements;
    @Enumerated
    private orderStatus orderStatus;
}