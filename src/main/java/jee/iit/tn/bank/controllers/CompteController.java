package jee.iit.tn.bank.controllers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import jee.iit.tn.bank.dto.CompteDto;
import jee.iit.tn.bank.service.ClientService;
import jee.iit.tn.bank.service.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping(Paths.COMPTE_ROOT_URL)
public class CompteController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(CompteController.class);
    private final CompteService compteService;
    private  final ClientService clientService;

    public CompteController(CompteService compteService, ClientService clientService) {
        this.compteService = compteService;
        this.clientService = clientService;
    }
    /**
     * package-private constructor.
     *
     * @param compteService the {@link CompteService } bean.
     */


    /**
     * Web Services compte list.
     *
     * @return list of compte encapsulated into {@link ResponseEntity}.
     */
    @GetMapping("all")
    public ResponseEntity<List<CompteDto>> getAllComptes() {
        return new ResponseEntity<>(compteService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/getOne/{id}")
    public ResponseEntity<CompteDto> getOneCompte(@PathVariable Long id) {
        return new ResponseEntity<>(compteService.getOne (id), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getComptesByClientId(@PathVariable(name = "id") Long id){
//        if (!clientService.exi (id)) {
//            return ResponseEntity
//                    .status (HttpStatus.NOT_FOUND).body ("Client doesn't exist ");
//        }
        return ResponseEntity.ok (compteService.findComptesByClient_Id(id));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CompteDto> save(@RequestBody CompteDto clientDto){
        return new ResponseEntity<>(compteService.save(clientDto), HttpStatus.OK);
    }
    @PutMapping(path="/update")
    public ResponseEntity<CompteDto> update(@RequestBody CompteDto clientDto){
        return new ResponseEntity<>(compteService.update (clientDto), HttpStatus.OK);
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            compteService.delete(id);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
