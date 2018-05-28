package it.si2001.model;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
// @uniqueConstraint serve a indicare un vincolo di unicità di questa entità indicando le colonne corrispondenti.
//NB questa annotazione jpa non definisce il vincolo nel db, ma è solo un'informaione. Quindi deve essere definita nel db
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname","lastname"})}
)
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false,unique = true)
    private int id;


    @ManyToOne
    @JoinColumn(name = "userStatus")
    private MaritalStatus status;

    @Column(name="firstname", length=40, nullable=false)
    private String firstname;

    @Column(name="lastname", length=40, nullable=false)
    private String lastname;

    @Column(name="country", length=40, nullable=true)
    private String country;

    @Column(name="birthDate", length=40, nullable=true)
    private String birthDate;

    public void setSkills(Set<it.si2001.model.Skills> skills) {
        this.skills = skills;
    }

    public Set<it.si2001.model.Skills> getSkills() {

        return skills;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recordings" , joinColumns = { @JoinColumn(name = "user_id")}, inverseJoinColumns = { @JoinColumn(name = "idSkills")})
    private Set<Skills> skills;

    public User(String fn, String ln, String country, String birthDate, MaritalStatus state) {
        firstname = fn;
        lastname = ln;
        this.country = country;
        this.birthDate = birthDate;
        status = state;
    }

    public User(String fn, String ln, String country, String birthDate, MaritalStatus state, Set<Skills> Skills){
        firstname = fn;
        lastname = ln;
        this.country = country;
        this.birthDate = birthDate;
        status = state;
        this.skills = Skills;
    }

    public User(String fn, String ln){
        firstname = fn;
        lastname = ln;
    }


    public String getBirthDate(){return birthDate;}

    public void setBirthDate(String birthDate){this.birthDate = birthDate;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public void setStatus(MaritalStatus status) {
        this.status = status;
    }


    public MaritalStatus getStatus() {
        return this.status;

    }
}

