package jee.iit.tn.bank.service;

import jee.iit.tn.bank.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto getClientByNom (String nom);
    ClientDto getClientByPrenom(String prenom);
    ClientDto getClientByAdresse(String adresse);

    ClientDto getClientByCin(String cin);

    ClientDto save(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    void delete(Long id);

    List<ClientDto> getAll();
    ClientDto getOne(Long id);

}
