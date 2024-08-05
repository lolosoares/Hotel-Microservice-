package Hotel.Microservice.Robson.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import javax.persistence.Id;

@Entity
@Table(name = User.Table_Name)
public class User {
    public interface CreateUser {
    }

    public interface UpdateUser {
    }

    public static final String Table_Name = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(groups = CreateUser.class)
    private String username;

    @Column(name = "gender")
    private char gender;

    @Column(name = "birthday", nullable = false)
    @NotBlank(groups = CreateUser.class)
    private String birthday;

    @Column(name = "address", nullable = false, length = 30)
    @NotBlank(groups = { CreateUser.class, UpdateUser.class })
    private String adress;

    @Column(name = "contact", nullable = false, length = 13)
    @NotBlank(groups = { CreateUser.class, UpdateUser.class })
    @Size(groups = { CreateUser.class, UpdateUser.class }, min = 9)
    private String contact;

    public User() {
    }

    public User(Long id, String username, char gender, String birthday, String adress, String contact) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.adress = adress;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
        this.id=id;
    }
    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + gender;
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((adress == null) ? 0 : adress.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (gender != other.gender)
            return false;
        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;
        if (adress == null) {
            if (other.adress != null)
                return false;
        } else if (!adress.equals(other.adress))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        return true;
    }

}
