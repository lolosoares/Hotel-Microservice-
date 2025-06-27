package mz.Hotel.Freeller.Freeler.Controller;

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
import mz.Hotel.Freeller.Freeler.Model.Freeller;
import mz.Hotel.Freeller.Freeler.Services.FreellerServcice;

@RestController
public class FreellerController {
     private FreellerServcice freellerServcice;

    public FreellerController(FreellerServcice freellerServcice) {
        this.freellerServcice = freellerServcice;
    }

    @GetMapping("/freellers")
    public ModelAndView findAll(Model model) {
        List<Freeller> freellers = freellerServcice.findAll();
        if (freellers == null || freellers.isEmpty()) {
            freellers = Collections.emptyList(); // Garante que a lista nunca seja null
        }
        model.addAttribute("freellers", freellers);
        System.out.print(freellers);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-freeller");
        return modelAndView;
    }
    
    @PostMapping("/freellers/new")
    public ModelAndView createFreeller( Freeller freeller) {
        freellerServcice.createFreeller(freeller);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/freellers");
        return modelAndView;
    }
    
    @GetMapping("/freellers/{id}")
    public ResponseEntity<Freeller> getFreellerbyid(@PathVariable Long id) {
        
        Freeller freeller=freellerServcice.getFreellerbyid(id);
        if(freeller!=null)
            return new ResponseEntity<>(freeller,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/freellers/{id}/delete")
    public ModelAndView deleteFreellers(@PathVariable Long id){
        boolean deleted=freellerServcice.deleteFreeller(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/freellers");
        if(deleted){
            return modelAndView;
        }else{
            System.out.println("Freeller Not found");
            return modelAndView;
        }
           
    }

    //Metodo Put
    @PostMapping("/freellerss/{id}")
    public ModelAndView updateJob(@PathVariable Long id, @RequestBody Freeller freeller) {
    // Aqui você deve ter a lógica para atualizar o trabalho
    boolean updated = freellerServcice.putFreeler(id, freeller);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/freellers");

    return modelAndView;
}

}
