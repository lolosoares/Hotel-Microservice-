package mz.Hotel.Freeller.Freeler.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mz.Hotel.Freeller.Freeler.Model.Freeller;
import mz.Hotel.Freeller.Freeler.Services.FreellerServcice;

import java.util.List;




@RestController
@RequestMapping("/Freellers")
public class FreellerViewController {

    private final FreellerServcice freellerServcice;

    // Preferred annotation for dependency injection
    public FreellerViewController(FreellerServcice freellerServcice) {
        this.freellerServcice = freellerServcice;
    }

    
    @Operation(summary = "Search all freellers", 
               description = "all freellers details.")
    @ApiResponse(responseCode = "200", description = "Freeller found")
    @ApiResponse(responseCode = "404", description = "Freeller not found")
    @GetMapping("/List")
    public ResponseEntity<List<Freeller>> listFreellers(Model model) {
        List<Freeller> freellers;
        try {
            freellers = freellerServcice.findAll();
            return new ResponseEntity<>(freellers, HttpStatus.OK);
        } catch (Exception e) {
            // Log the error and handle gracefully
            model.addAttribute("errorMessage", "An error occurred while fetching jobs.");
            freellers = null;  // Prevent potential null pointer exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @Operation(summary = "Create a new freeller", 
               description = "Creat a new freeler with given information.")
    @ApiResponse(responseCode = "201", description = "Freeller created")
    @PostMapping("/Post")
public ResponseEntity<String> createFreeller(@RequestBody Freeller freeller) {
    freellerServcice.createFreeller(freeller);
    
    return new ResponseEntity<>("Freeler created successfully!", HttpStatus.CREATED);
}

    @Operation(summary = "Delete a freeller by id", 
               description = "Delete a freelancer.")
    @ApiResponse(responseCode = "200", description = "Freeller found")
    @ApiResponse(responseCode = "404", description = "Freeller not found")
    @DeleteMapping("/{id}/Delete")
    public ResponseEntity<String> deleteFreeller(@PathVariable Long id) {
        boolean deleted = freellerServcice.deleteFreeller(id);
        if (deleted) {
            return new ResponseEntity<>("Freeller deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Freeller Update", 
               description = "Make update of a freellencer.")
    @ApiResponse(responseCode = "200", description = "Freeller found")
    @ApiResponse(responseCode = "404", description = "Freeller not found")
    @PutMapping("/{id}")
    public ResponseEntity<String> putJob(@PathVariable Long id, @RequestBody Freeller freeller) {
        boolean updated = freellerServcice.putFreeler(id, freeller);
        if (updated) {
            return new ResponseEntity<>("Freeller updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
