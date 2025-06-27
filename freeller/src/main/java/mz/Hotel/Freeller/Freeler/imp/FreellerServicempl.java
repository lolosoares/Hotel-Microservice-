package mz.Hotel.Freeller.Freeler.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import mz.Hotel.Freeller.Freeler.Model.Freeller;
import mz.Hotel.Freeller.Freeler.Repository.FreelerRepository;
import mz.Hotel.Freeller.Freeler.Services.FreellerServcice;

@Service
public class FreellerServicempl implements FreellerServcice{
    private FreelerRepository freellerRepository;
    
    public FreellerServicempl(FreelerRepository  freelerRepository) {
        this.freellerRepository = freelerRepository;
    }

    @Override
    public List<Freeller> findAll() {
       return freellerRepository.findAll();
    }

    @Override
    public void createFreeller(@RequestBody Freeller freeller) {
       freellerRepository.save(freeller);
    }

    @Override
    public Freeller getFreellerbyid(Long id) {
        return freellerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteFreeller(Long id) {
        try{
            freellerRepository.deleteById(id);
            return true;
        }catch(Exception e){
        return false;
     }
        
    }

    @Override
    public boolean putFreeler(Long id,Freeller newfreeller) {
        Optional<Freeller> freelleroptional=freellerRepository.findById(id);
        
            if(freelleroptional!=null){
                Freeller freeller=freelleroptional.get();
                freeller.setName(newfreeller.getName());
                freeller.setPersonaldescription(newfreeller.getPersonaldescription());
                freeller.setTecnicaldescription(newfreeller.getTecnicaldescription());
                freeller.setEmail(newfreeller.getEmail());
                freeller.setLocation(newfreeller.getLocation());
                freellerRepository.save(freeller);
                return true;
            }
        
        return false;
    }
}
