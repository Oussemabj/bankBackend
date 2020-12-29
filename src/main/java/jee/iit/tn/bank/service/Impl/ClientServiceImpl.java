package jee.iit.tn.bank.service.Impl;

import jee.iit.tn.bank.dto.ClientDto;
import jee.iit.tn.bank.mapper.ClientMapper;
import jee.iit.tn.bank.models.Client;
import jee.iit.tn.bank.repositries.ClientRepository;
import jee.iit.tn.bank.repositries.CompteRepository;
import jee.iit.tn.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl extends CommonServiceImpl
        <Client, ClientDto, Long, ClientRepository> implements ClientService {

    @Autowired
            private CompteRepository compteRepository;

    ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {

        super (repository, mapper);
        System.out.println (mapper.map (new Client ()));
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto getClientByNom(final String nom) {
        if(nom==null){
            throw new NullPointerException ("Nom du client est null");
        }
        return mapper.map (repository.findByNom (nom));

    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto getClientByPrenom(String prenom) {
        if(prenom==null){
            throw new NullPointerException ("Prenom du client est null");
        }
        return mapper.map (repository.findByPrenom(prenom));

    }

    @Override
    public ClientDto getClientByAdresse(String adresse) {
        if(adresse==null){
            throw new NullPointerException ("Adresse du client est null");
        }
        return mapper.map (repository.findByAdresse (adresse));
    }

    @Override
    public ClientDto getClientByCin(String cin) {
        if(cin==null){
            throw new NullPointerException ("cin du client est null");
        }
        return mapper.map (repository.findByCin (cin));

    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        if(clientDto == null) {
            throw new RuntimeException("this client is not exist ");
        }
        if(repository.existsByCin (clientDto.getCin())) {
            throw new RuntimeException("This CIN  is already exists.");
        }
        System.out.println (clientDto);
        Client savedClient =repository.save(mapper.map(clientDto));
        if(savedClient == null) {
            throw new RuntimeException ("An error has occurred in save this CIN");
        }
        return mapper.map(savedClient);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
       return mapper.map (entityManager.merge (mapper.map (clientDto)));

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Assert.notNull(id, "Id is null");
        compteRepository.deleteComptesByClientId (id);
        repository.deleteById(id);
    }

    @Override
    public List<ClientDto> getAll() {

        return mapper.mapToDtos(repository.findAll());
    }

    @Override
    public ClientDto getOne(Long id) {

        return mapper.map(repository.getOne(id));
    }


}









