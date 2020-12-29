package jee.iit.tn.bank.service;

import jee.iit.tn.bank.dto.CompteClientDto;
import jee.iit.tn.bank.dto.CompteDto;

import java.util.List;

public interface CompteService {

    CompteDto getCompteByRib(String rib);
    CompteDto getCompteBySolde(Float solde);

    CompteDto save(CompteDto compteDto);

    CompteDto update(CompteDto compteDto);

    void delete(Long id);

    List<CompteDto> getAll();
    CompteDto getOne(Long id);
    List<CompteDto> findComptesByClient_Id(Long client_id);
}
