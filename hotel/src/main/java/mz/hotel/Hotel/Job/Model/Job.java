package mz.hotel.Hotel.Job.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String maxsalary;
    private String minsalary;
    private String location;

    public Job() {
    }

    public Job(Long id, String title, String description, String maxsalary, String minsalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.maxsalary = maxsalary;
        this.minsalary = minsalary;
        this.location = location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMaxsalary() {
        return maxsalary;
    }
    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }
    public String getMinsalary() {
        return minsalary;
    }
    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
}
