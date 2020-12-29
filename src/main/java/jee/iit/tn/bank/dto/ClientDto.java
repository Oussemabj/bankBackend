package jee.iit.tn.bank.dto;

import jee.iit.tn.bank.models.Compte;
import jee.iit.tn.bank.models.Identifiable;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto extends IdentifiableDto<Long> {
    private static final long serialVersionUID = 1L;
    private String nom;
    private String prenom;
    private String adresse;
    private String cin;
}
