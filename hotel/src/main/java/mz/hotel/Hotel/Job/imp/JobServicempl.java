package mz.hotel.Hotel.Job.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import mz.hotel.Hotel.Job.Model.Job;
import mz.hotel.Hotel.Job.Repository.JobRepository;
import mz.hotel.Hotel.Job.Services.JobService;

@Service
public class JobServicempl implements JobService{
    
    private JobRepository jobRepository;
    
    public JobServicempl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
       return jobRepository.findAll();
    }

    @Override
    public void createJob(@RequestBody Job job) {
       jobRepository.save(job);
    }

    @Override
    public Job getJobbyid(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
        return false;
     }
        
    }

    @Override
    public boolean putJob(Long id,Job newJob) {
        Optional<Job> joboptional=jobRepository.findById(id);
        
            if(joboptional!=null){
                Job job=joboptional.get();
                job.setDescription(newJob.getDescription());
                job.setTitle(newJob.getTitle());
                job.setMaxsalary(newJob.getMaxsalary());
                job.setMinsalary(newJob.getMinsalary());
                job.setLocation(newJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        
        return false;
    }
    
}
