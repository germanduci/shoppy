package com.ar.shoppy.models;

import com.ar.shoppy.enums.orderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate orderDate = LocalDate.now();
    private LocalDate orderEndDate;
    private String orderRequirements;
    @Enumerated
    private orderStatus orderStatus;
}
