package it.si2001.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "maritalstatus")
public class MaritalStatus implements Serializable {

    public static final long serialVersionUID = 1L;
    public MaritalStatus(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId", nullable = false, unique = true)
    private int id;

    @Column(name = "status", nullable = false, length = 40)
    private String status;

    public MaritalStatus(String status){
        this.status = status;
    }

    public void setStatus(String status) { this.status = status;  }



    public String getStatus() {return this.status; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.status.equals(((MaritalStatus) o).getStatus()); }
}

