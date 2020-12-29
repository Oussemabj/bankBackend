package jee.iit.tn.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteClientDto extends IdentifiableDto<Long> {
    private static final long serialVersionUID = 1L;
    private Float solde;
    private String rib;


}
