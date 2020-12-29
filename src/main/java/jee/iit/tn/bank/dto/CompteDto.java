package jee.iit.tn.bank.dto;

import jee.iit.tn.bank.models.Client;
import jee.iit.tn.bank.models.Compte;
import jee.iit.tn.bank.models.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteDto extends IdentifiableDto<Long> {
    private static final long serialVersionUID = 1L;
    private Float solde;
    private String rib;
//    private Client client;
    private Long clientId;


}
