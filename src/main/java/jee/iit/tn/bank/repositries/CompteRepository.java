package jee.iit.tn.bank.repositries;

import jee.iit.tn.bank.models.Client;
import jee.iit.tn.bank.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {
    Compte findByRib(String rib);
    Compte findBySolde(Float solde);
    boolean existsByRib(String rib);
    void deleteComptesByClientId(Long client_id);
    List<Compte> findComptesByClient_Id(Long client_id);
}
