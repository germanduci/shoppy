package com.ar.shoppy.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Data
@Table(name="archivo")
public class Archivo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String archivoId;
    @ManyToOne
    @JoinColumn(name="ordenId")
    private Orden orden;
    private String archivoNombre;
    private String archivoMime;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] archivoByte;
}
