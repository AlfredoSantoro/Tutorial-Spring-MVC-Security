package it.si2001.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "skills")
public class Skills implements Serializable {

    public static final long serialVersionUID = 1L;
    public Skills(){}

    public Skills(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSkills", nullable = false, unique = true)
    private int idSkills;

    @Column(name="name", length=45, nullable=false)
    private String name;

    public void setIdSkills(int idSkills) {
        this.idSkills = idSkills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdSkills() {

        return idSkills;
    }

    public String getName() {
        return name;
    }
}
