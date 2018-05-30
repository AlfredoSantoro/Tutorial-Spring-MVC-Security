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
    private Integer idSkills;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Skills))
            return false;
        Skills other = (Skills) o;
        if (idSkills == null) {
            if (other.idSkills != null)
                return false;
        } else if (!idSkills.equals(other.idSkills))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idSkills == null) ? 0 : idSkills.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result; }

    @Override
    public String toString() {
        return "Skill [id=" + idSkills + ", skill=" + name + "]";
    }
}
