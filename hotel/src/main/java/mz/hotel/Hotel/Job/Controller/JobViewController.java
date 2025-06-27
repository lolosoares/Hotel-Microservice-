package mz.hotel.Hotel.Job.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

import mz.hotel.Hotel.Job.Model.Job;
import mz.hotel.Hotel.Job.Services.JobService;


@RestController
@RequestMapping("/Jobs")
public class JobViewController {

    private final JobService jobService;

    // Preferred annotation for dependency injection
    public JobViewController(JobService jobService) {
        this.jobService = jobService;
    }

    // List all Jobs with error handling
    @Operation(summary = "Search all jobs", 
               description = "all jobs details.")
    @ApiResponse(responseCode = "200", description = "Job found")
    @ApiResponse(responseCode = "404", description = "Job not found")
    @GetMapping("/List")
    public ResponseEntity<List<Job>> listJobs(Model model) {
        List<Job> jobs;
        try {
            jobs = jobService.findAll();
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            // Log the error and handle gracefully
            model.addAttribute("errorMessage", "An error occurred while fetching jobs.");
            jobs = null;  // Prevent potential null pointer exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create a new Job with form validation and error handling
    @Operation(summary = "Create a new job", 
               description = "Creat a new job with given information.")
    @ApiResponse(responseCode = "201", description = "Job created")
    @PostMapping("/Post")
public ResponseEntity<String> createJob(@RequestBody Job job) {
    jobService.createJob(job);
    
    return new ResponseEntity<>("Job created successfully!", HttpStatus.CREATED);
}


    // Delete Job
    @Operation(summary = "Delete a job by id", 
               description = "Delete a jobs.")
    @ApiResponse(responseCode = "200", description = "Job found")
    @ApiResponse(responseCode = "404", description = "Job not found")
    @DeleteMapping("/{id}/Delete")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update Job
    @Operation(summary = "Job Update", 
               description = "Make update of a job.")
    @ApiResponse(responseCode = "200", description = "Job found")
    @ApiResponse(responseCode = "404", description = "Job not found")
    @PutMapping("/{id}")
    public ResponseEntity<String> putJob(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.putJob(id, job);
        if (updated) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
