package com.ar.shoppy.domain;

import com.ar.shoppy.enums.orderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="cliente")
public class Client {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    @OneToMany
    private List <Order> clientOrders;
    @Enumerated
    private orderStatus clientOrderStatus;
}
