package it.si2001.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Role implements Serializable {

    public static final long serialVersionUID = 1L;
    public Role(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private int id;


    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public int getId() { return id; }

    public String getName() { return name; }

    @NotEmpty
    @NotNull
    @Size(max = 100)
    @Column(name="name", length=100, nullable=false)
    private String name;}
