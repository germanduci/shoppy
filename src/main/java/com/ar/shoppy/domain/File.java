package com.ar.shoppy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="archivo")
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String fileId;
    @ManyToOne
    private Client fileClient;
    private String fileName;
    private String fileMime;
    @Basic(fetch = FetchType.LAZY)
    private byte[] fileByte;
}
