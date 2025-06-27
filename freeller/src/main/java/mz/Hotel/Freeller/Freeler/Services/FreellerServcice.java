package mz.Hotel.Freeller.Freeler.Services;

import java.util.List;

import mz.Hotel.Freeller.Freeler.Model.Freeller;

public interface FreellerServcice {
    List<Freeller> findAll();
    void createFreeller(Freeller freeller);
    Freeller getFreellerbyid(Long id);
    boolean deleteFreeller(Long id);
    boolean putFreeler(Long id,Freeller freeller);
    
    
}
