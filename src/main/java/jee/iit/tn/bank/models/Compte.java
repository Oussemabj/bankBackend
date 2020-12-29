package jee.iit.tn.bank.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compte extends Identifiable<Long> {
    private static final long serialVersionUID = 1L;

    @Column(length = 128, nullable = false)
    private Float solde;
    @Column(length = 128, nullable = false)
    private String rib;
    @ManyToOne
    private Client client;


}
