package jee.iit.tn.bank.controllers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import jee.iit.tn.bank.dto.ClientDto;
import jee.iit.tn.bank.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping(Paths.CLIENT_ROOT_URL)
public class ClientController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;
    /**
     * package-private constructor.
     *
     * @param clientService the {@link ClientService } bean.
     */

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Web Services Client list.
     *
     * @return list of client encapsulated into {@link ResponseEntity}.
     */
    @GetMapping("all")
    public ResponseEntity<List<ClientDto>> getAllClients() {

        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/getOne/{id}")
    public ResponseEntity<ClientDto> getOneClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getOne(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.save(clientDto), HttpStatus.OK);
    }
    @PutMapping(path="/update")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.update (clientDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            clientService.delete(id);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //    @GetMapping(path = "/{nom}")
//    public ResponseEntity<ClientDto> getClientByNom(@PathVariable final String nom) {
//        return new ResponseEntity<>(clientService.getClientByNom (nom), HttpStatus.OK);
//    }
//    @GetMapping(path = "/{adresse}")
//    public ResponseEntity<ClientDto> getClientByAdresse(@PathVariable final String adresse) {
//        return new ResponseEntity<>(clientService.getClientByAdresse (adresse), HttpStatus.OK);
//    }
//    @GetMapping(path = "/{cin}")
//    public ResponseEntity<ClientDto> getClient(@PathVariable final Integer cin) {
//        return new ResponseEntity<>(clientService.getClientByCin (cin), HttpStatus.OK);
//    }
//    @GetMapping(path = "/{prenom}")
//    public ResponseEntity<ClientDto> getClientByPrenom(@PathVariable final String prenom) {
//        return new ResponseEntity<>(clientService.getClientByPrenom (prenom), HttpStatus.OK);
//    }


}
