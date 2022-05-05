package com.ar.shoppy.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String clienteId;
    private String clienteNombre;
    private String clienteMail;
    private String clienteTelef;
    @OneToMany
    @JoinColumn(name="clientId")
    private List<Orden> clienteOrden;
}
