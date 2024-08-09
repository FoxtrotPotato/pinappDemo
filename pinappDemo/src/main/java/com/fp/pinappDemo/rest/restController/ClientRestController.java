package com.fp.pinappDemo.rest.restController;

import com.fp.pinappDemo.dto.ClientDTO;
import com.fp.pinappDemo.entity.AgeStatistics;
import com.fp.pinappDemo.entity.Client;
import com.fp.pinappDemo.rest.restService.ClientRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
@Tag(name = "Clientes", description = "API para la gestión de clientes")

public class ClientRestController {

    private final ClientRestService clientRestService;

    @Autowired
    public ClientRestController(ClientRestService theClientRestService){
        clientRestService = theClientRestService;
    }

    @GetMapping("/listclientes")
    @Operation(summary = "Obtener listado de clientes", description = "Obtiene un listado de clientes ordenados alfabéticamente por apellido")
    public ResponseEntity<List<ClientDTO>> listClients() {
        List<ClientDTO> clientsList = clientRestService.findAll();
        if (clientsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientsList, HttpStatus.OK);
    }



    @GetMapping("/kpideclientes")
    @Operation(summary = "Obtener estadísticas de edad", description = "Obtiene el promedio y la desviación estándar de las edades de los clientes")
    public ResponseEntity<AgeStatistics> getAgeStatistics(){
        AgeStatistics ageStatistics = clientRestService.getAgeStatistics();
        return new ResponseEntity<>(ageStatistics, HttpStatus.OK);
    }


    @PostMapping(value = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Crear un nuevo cliente", description = "Crea un nuevo cliente con los detalles proporcionados")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client theClient = clientRestService.createClient(client);
        return new ResponseEntity<>(theClient, HttpStatus.CREATED);
    }

}

