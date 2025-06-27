package mz.Hotel.JobHunter.JobHunter.Controller;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import mz.Hotel.JobHunter.JobHunter.Model.JobHunter;
import mz.Hotel.JobHunter.JobHunter.Services.JobHunterService;

@RestController
public class JobHunterController {
    private JobHunterService jobHunterService;

    public JobHunterController(JobHunterService jobHunterService) {
        this.jobHunterService = jobHunterService;
    }

    @GetMapping("/jobhunters")
    public ModelAndView findAll(Model model) {
        List<JobHunter> jobHunters = jobHunterService.findAll();
        if (jobHunters == null || jobHunters.isEmpty()) {
            jobHunters = Collections.emptyList(); // Garante que a lista nunca seja null
        }
        model.addAttribute("jobhunters", jobHunters);
        System.out.print(jobHunters);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-jobhunter");
        return modelAndView;
    }
    
    @PostMapping("/jobhunters/new")
    public ModelAndView createJobHubter( JobHunter jobHunter) {
        jobHunterService.createJobHunter(jobHunter);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/jobhunters");//
        return modelAndView;
    }
    
    @GetMapping("/jobhunters/{id}")
    public ResponseEntity<JobHunter> getJobHunterbyid(@PathVariable Long id) {
        
        JobHunter jobHunter=jobHunterService.getJobHunterbyid(id);
        if(jobHunter!=null)
            return new ResponseEntity<>(jobHunter,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobhunters/{id}/delete")
    public ModelAndView deleteJobHunters(@PathVariable Long id){
        boolean deleted=jobHunterService.deleteJobHunter(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/jobhunters");
        if(deleted){
            return modelAndView;
        }else{
            System.out.println("JobHunter Not found");
            return modelAndView;
        }
           
    }

    //Metodo Put
    @PostMapping("/jobhunters/{id}")
    public ModelAndView updateJobHunters(@PathVariable Long id, @RequestBody JobHunter jobHunter) {
    // Aqui você deve ter a lógica para atualizar o trabalho
    boolean updated = jobHunterService.putJobHunter(id, jobHunter);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/jobhunters");

    return modelAndView;
}
}
