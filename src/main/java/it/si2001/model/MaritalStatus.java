package it.si2001.model;

import javax.persistence.*;

@Entity
@Table(name = "maritalstatus")
public class MaritalStatus {


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

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {

        return id;
    }

    public String getStatus() {

        return status;
    }
}

