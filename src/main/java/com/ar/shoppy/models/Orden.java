package com.ar.shoppy.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name="orden")
public class Orden {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String ordenId;
    private String ordenNombre;
    @OneToOne
    @JoinColumn(name="clienteId")
    private Cliente cliente;
    @OneToMany
    @JoinColumn(name="ordenId")
    private List<Archivo> ordenArchivo;
    private String ordenRequerimiento;
    @Enumerated
    private com.ar.shoppy.enums.orderStatus orderEstado;
}
