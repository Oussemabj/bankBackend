package jee.iit.tn.bank.models;

import lombok.*;
//import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Identifiable<Long> {

    private static final long serialVersionUID = 1L;
    @Column(length = 128, nullable = false)
    private String nom;
    @Column(length = 128, nullable = false)
    private String prenom;
    @Column(length = 128, nullable = false)
    private String adresse;
    @Column(length = 128, nullable = false)
    private String cin;

}
