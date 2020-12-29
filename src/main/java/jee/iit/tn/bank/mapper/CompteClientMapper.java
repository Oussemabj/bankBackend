package jee.iit.tn.bank.mapper;

import jee.iit.tn.bank.dto.CompteClientDto;
import jee.iit.tn.bank.dto.CompteDto;
import jee.iit.tn.bank.models.Compte;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@org.mapstruct.Mapper(componentModel = Mapper.SPRING)
public interface CompteClientMapper extends Mapper <Compte, CompteClientDto>  {
    @Override
    CompteClientDto map(Compte compte);
    //mseddi
}
