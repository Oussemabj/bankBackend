package jee.iit.tn.bank.mapper;

import jee.iit.tn.bank.dto.ClientDto;
import jee.iit.tn.bank.models.Client;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;


@org.mapstruct.Mapper(componentModel = Mapper.SPRING)
public interface ClientMapper extends Mapper <Client, ClientDto> {

    //@Mapping (source = "cin",target = "cin")
    ClientDto map(Client client);

//    @Override
//    Client map(ClientDto clientDto);
}
