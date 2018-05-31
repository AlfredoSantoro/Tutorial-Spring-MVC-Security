package it.si2001.model;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
// @uniqueConstraint serve a indicare un vincolo di unicità di questa entità indicando le colonne corrispondenti.
//NB questa annotazione jpa non definisce il vincolo nel db, ma è solo un'informaione. Quindi deve essere definita nel db
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname","lastname"})}
)
public class User implements Serializable {

    public static final long serialVersionUID = 1L;
    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false,unique = true)
    private int id;


    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Column(name="password", length=100, nullable=false)
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public String getUsername() {
        return username;
    }

    @Size(max = 150)
    @NotNull
    @NotEmpty

    @Column(name="username", length=150, nullable=false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "userStatus")
    private MaritalStatus status;

    @NotEmpty
    @Size(max = 40)
    @Column(name="firstname", length=40, nullable=false)
    private String firstname;

    @NotEmpty @Size(max = 40)
    @Column(name="lastname", length=40, nullable=false)
    private String lastname;

    @Size(max = 40)
    @NotEmpty
    @Column(name="country", length=40, nullable=true)
    private String country;

    @NotEmpty
    @Size(max = 40)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = { @JoinColumn(name = "iduser")}, inverseJoinColumns = { @JoinColumn(name = "idrole")})
    private Set<Role> roles;

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {

        return roles;
    }

    public User(String fn, String ln, String country, String birthDate, MaritalStatus state) {
        firstname = fn;
        lastname = ln;
        this.country = country;
        this.birthDate = birthDate;
        status = state; }

    public User(String fn, String ln, String country, String birthDate, MaritalStatus state, Set<Skills> Skills){
        firstname = fn;
        lastname = ln;
        this.country = country;
        this.birthDate = birthDate;
        status = state;
        this.skills = Skills; }

    public User(String fn, String ln){
        firstname = fn;
        lastname = ln; }


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


    public MaritalStatus getStatus() { return this.status; }}

