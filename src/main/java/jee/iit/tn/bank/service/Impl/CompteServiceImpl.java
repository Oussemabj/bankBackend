package jee.iit.tn.bank.service.Impl;

import jee.iit.tn.bank.dto.CompteClientDto;
import jee.iit.tn.bank.dto.CompteDto;
import jee.iit.tn.bank.mapper.Mapper;
import jee.iit.tn.bank.models.Compte;

import jee.iit.tn.bank.repositries.CompteRepository;

import jee.iit.tn.bank.service.CompteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional
public class CompteServiceImpl  extends CommonServiceImpl
        <Compte, CompteDto, Long, CompteRepository> implements CompteService {

    CompteServiceImpl(CompteRepository repository, Mapper<Compte, CompteDto> mapper) {
        super (repository, mapper);
    }

    @Override
    @Transactional(readOnly = true)
    public CompteDto getCompteByRib(final String rib) {
        if(rib==null){
            throw new NullPointerException ("Rib est null");
        }
        return mapper.map (repository.findByRib (rib));

    }
    @Override
    @Transactional(readOnly = true)
    public CompteDto getCompteBySolde(Float solde) {
        if(solde==null){
            throw new NullPointerException ("solde est null");
        }
        return mapper.map (repository.findBySolde (solde));
    }

    @Override
    @Transactional
    public CompteDto save(CompteDto compteDto) {
        if(compteDto == null) {
            throw new RuntimeException("this compte is not exist ");
        }
        if(repository.existsByRib (compteDto.getRib ())) {
            throw new RuntimeException("This Rib is already exists.");
        }
        Compte savedCompte =repository.save (mapper.map(compteDto));
        if(savedCompte == null) {
            throw new RuntimeException ("An error has occurred in save this Compte");
        }
        return mapper.map(savedCompte);
    }

    @Override
    public CompteDto update(CompteDto compteDto) {
        return mapper.map (entityManager.merge (mapper.map (compteDto)));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Id is null");
        repository.deleteById(id);
    }

    @Override
    public CompteDto getOne(Long id) {
        return mapper.map(repository.getOne(id));
    }

    @Override
    public List<CompteDto> findComptesByClient_Id(Long client_id)
    {
        return mapper.mapToDtos (repository.findComptesByClient_Id (client_id));
    }

}
