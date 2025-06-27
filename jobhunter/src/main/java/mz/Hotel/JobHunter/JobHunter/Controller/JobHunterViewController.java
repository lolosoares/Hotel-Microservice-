package mz.Hotel.JobHunter.JobHunter.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mz.Hotel.JobHunter.JobHunter.Model.JobHunter;
import mz.Hotel.JobHunter.JobHunter.Services.JobHunterService;

import java.util.List;




@RestController
@RequestMapping("/JobHunters")
public class JobHunterViewController {
    private final JobHunterService jobHunterService;

    // Preferred annotation for dependency injection
    public JobHunterViewController(JobHunterService jobHunterService) {
        this.jobHunterService = jobHunterService;
    }

    
    @Operation(summary = "Search all jobHunters", 
               description = "all jobhunters details.")
    @ApiResponse(responseCode = "200", description = "JobHunter found")
    @ApiResponse(responseCode = "404", description = "JobHunter not found")
    @GetMapping("/List")
    public ResponseEntity<List<JobHunter>> listJobHunters(Model model) {
        List<JobHunter> jobHunters;
        try {
            jobHunters = jobHunterService.findAll();
            return new ResponseEntity<>(jobHunters, HttpStatus.OK);
        } catch (Exception e) {
            // Log the error and handle gracefully
            model.addAttribute("errorMessage", "An error occurred while fetching jobs.");
            jobHunters = null;  // Prevent potential null pointer exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @Operation(summary = "Create a new JobHunter", 
               description = "Creat a new JobHunter with given information.")
    @ApiResponse(responseCode = "201", description = "JobHunter created")
    @PostMapping("/Post")
public ResponseEntity<String> createJobHunter(@RequestBody JobHunter jobHunter) {
    jobHunterService.createJobHunter(jobHunter);
    
    return new ResponseEntity<>("JobHunter created successfully!", HttpStatus.CREATED);
}

    @Operation(summary = "Delete a JobHunter by id", 
               description = "Delete a jobhunter.")
    @ApiResponse(responseCode = "200", description = "JobHunter found")
    @ApiResponse(responseCode = "404", description = "JobHunter not found")
    @DeleteMapping("/{id}/Delete")
    public ResponseEntity<String> deleteJobHunter(@PathVariable Long id) {
        boolean deleted = jobHunterService.deleteJobHunter(id);
        if (deleted) {
            return new ResponseEntity<>("JobHunter deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "JobHunter Update", 
               description = "Make update of a jobhunter.")
    @ApiResponse(responseCode = "200", description = "JobHunter found")
    @ApiResponse(responseCode = "404", description = "JobHunter not found")
    @PutMapping("/{id}")
    public ResponseEntity<String> putJobHunter(@PathVariable Long id, @RequestBody JobHunter jobHunter) {
        boolean updated = jobHunterService.putJobHunter(id, jobHunter);
        if (updated) {
            return new ResponseEntity<>("JobHunter updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
}
