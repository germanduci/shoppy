package com.ar.shoppy.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String clientId;
    private String name;
    private String email;
    private String phone;
    private List <Order> order;

}
