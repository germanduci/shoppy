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
    private String name;
    @OneToOne
    private Client client;
    @OneToMany
    private List<File> files;
    @Temporal(value=TemporalType.DATE)
    private Date orderDate = new Date();
    private Date endDate;
    private String requirements;
    @Enumerated
    private orderStatus status;
}
