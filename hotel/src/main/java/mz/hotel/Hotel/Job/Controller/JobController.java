package mz.hotel.Hotel.Job.Controller;
//import java.util.List;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mz.hotel.Hotel.Job.Model.Job;
import mz.hotel.Hotel.Job.Services.JobService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



//@RequestMapping("/jobs") for create a base URL
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ModelAndView findAll(Model model) {
        List<Job> jobs = jobService.findAll();
        if (jobs == null || jobs.isEmpty()) {
            jobs = Collections.emptyList(); // Garante que a lista nunca seja null
        }
        model.addAttribute("jobs", jobs);
        //return "list-job";
        //changes
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-job");
        return modelAndView;
    }
    
    //testing
    @GetMapping("/greeting")
    public ModelAndView greeting() {
         ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/jobs/new")//re para dar uma resposta adaequada da api
    public ModelAndView createJob( Job job) {
        jobService.createJob(job);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/jobs");//
        return modelAndView;
    }
    
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobbyid(@PathVariable Long id) {
        
        Job job=jobService.getJobbyid(id);
        if(job!=null)
            return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}/delete")
    public ModelAndView deleteJob(@PathVariable Long id){
        boolean deleted=jobService.deleteJob(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/jobs");
        if(deleted){
            return modelAndView;
        }else{
            System.out.println("Job Not found");
            return modelAndView;
        }
           
    }

    //Metodo Put
    @PostMapping("/jobss/{id}")
    public ModelAndView updateJob(@PathVariable Long id, @RequestBody Job job) {
    // Aqui você deve ter a lógica para atualizar o trabalho
    boolean updated = jobService.putJob(id, job);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/jobs");

    return modelAndView;
}

    
}
