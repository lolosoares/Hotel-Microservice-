package mz.hotel.Hotel.Job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.hotel.Hotel.Job.Model.Job;

public interface JobRepository extends JpaRepository<Job,Long>{
    
}
