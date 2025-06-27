package mz.hotel.Hotel.Job.Services;
import java.util.List;

import mz.hotel.Hotel.Job.Model.Job;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobbyid(Long id);
    boolean deleteJob(Long id);
    boolean putJob(Long id,Job job);

}
