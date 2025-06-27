package mz.Hotel.Freeller.Freeler.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Freeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String personaldescription;
    private String tecnicaldescription;
    private String email;
    private String location;

    public Freeller() {
    }
    public Freeller(Long id, String name, String personaldescription, String tecnicaldescription, String email,
            String location) {
        this.id = id;
        this.name = name;
        this.personaldescription = personaldescription;
        this.tecnicaldescription = tecnicaldescription;
        this.email = email;
        this.location = location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPersonaldescription() {
        return personaldescription;
    }
    public void setPersonaldescription(String personaldescription) {
        this.personaldescription = personaldescription;
    }
    public String getTecnicaldescription() {
        return tecnicaldescription;
    }
    public void setTecnicaldescription(String tecnicaldescription) {
        this.tecnicaldescription = tecnicaldescription;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
