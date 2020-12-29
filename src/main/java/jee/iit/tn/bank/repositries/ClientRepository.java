package jee.iit.tn.bank.repositries;

import jee.iit.tn.bank.dto.ClientDto;
import jee.iit.tn.bank.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByNom(String nom);

    Client findByPrenom(String prenom);

    Client findByAdresse(String adresse);
    Client findByCin(String cin);

    boolean existsByCin(String cin);

}
