package mz.Hotel.JobHunter.JobHunter.Services;

import java.util.List;

import mz.Hotel.JobHunter.JobHunter.Model.JobHunter;

public interface JobHunterService {
    List<JobHunter> findAll();
    void createJobHunter(JobHunter jobHunter);
    JobHunter getJobHunterbyid(Long id);
    boolean deleteJobHunter(Long id);
    boolean putJobHunter(Long id,JobHunter jobHunter);
}
