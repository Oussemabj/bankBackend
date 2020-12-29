package jee.iit.tn.bank.mapper;

import jee.iit.tn.bank.dto.ClientDto;
import jee.iit.tn.bank.dto.CompteDto;

import jee.iit.tn.bank.models.Compte;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = Mapper.SPRING)
public interface CompteMapper extends Mapper <Compte, CompteDto>  {
    @Override
        @Mapping(source = "client.id",target = "clientId")
    CompteDto map(Compte compte);

    @Override
    @Mapping(source = "clientId",target = "client.id")
    Compte map(CompteDto compteDto) ;

}
