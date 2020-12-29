package jee.iit.tn.bank.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Class for identify objects.
 *
 * @param <T> the primary key type.
 * @author Oussema Ben Jmeaa
 */
@MappedSuperclass
@EqualsAndHashCode
@Getter
@Setter
public abstract class Identifiable<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected T id;

}