package mz.Hotel.JobHunter.JobHunter.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import mz.Hotel.JobHunter.JobHunter.Model.JobHunter;
import mz.Hotel.JobHunter.JobHunter.Repository.JobHunterRepository;
import mz.Hotel.JobHunter.JobHunter.Services.JobHunterService;

@Service
public class JobHunterServicempl implements JobHunterService{
    private JobHunterRepository jobHunterRepository;
    
    public JobHunterServicempl(JobHunterRepository  jobHunterRepository) {
        this.jobHunterRepository = jobHunterRepository;
    }

    @Override
    public List<JobHunter> findAll() {
       return jobHunterRepository.findAll();
    }

    @Override
    public void createJobHunter(@RequestBody JobHunter jobHunter) {
       jobHunterRepository.save(jobHunter);
    }

    @Override
    public JobHunter getJobHunterbyid(Long id) {
        return jobHunterRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobHunter(Long id) {
        try{
            jobHunterRepository.deleteById(id);
            return true;
        }catch(Exception e){
        return false;
     }
        
    }

    @Override
    public boolean putJobHunter(Long id,JobHunter newjJobHunter) {
        Optional<JobHunter> jobHunterroptional=jobHunterRepository.findById(id);
        
            if(jobHunterroptional!=null){
                JobHunter jobHunter=jobHunterroptional.get();
                jobHunter.setName(newjJobHunter.getName());
                jobHunter.setPersonaldescription(newjJobHunter.getPersonaldescription());
                jobHunter.setTecnicaldescription(newjJobHunter.getTecnicaldescription());
                jobHunter.setEmail(newjJobHunter.getEmail());
                jobHunter.setLocation(newjJobHunter.getLocation());
                jobHunterRepository.save(jobHunter);
                return true;
            }
        
        return false;
    }
}
