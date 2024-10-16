package dev.giovanniromano.portale.controller;

import dev.giovanniromano.portale.server.api.AnagraficaApi;
import dev.giovanniromano.portale.server.api.ApiUtil;
import dev.giovanniromano.portale.server.model.AnagraficaDTO;
import dev.giovanniromano.portale.service.AnagraficaClientService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagraficaClientController implements AnagraficaApi {

    @Autowired
    AnagraficaClientService service;

    @Override
    public ResponseEntity<AnagraficaDTO> findAnagraficaById(
            @Parameter(name = "idAnagrafica", description = "ID dell'anagrafica da cercare", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica
    ) {
        return new ResponseEntity<>(service.getById(idAnagrafica), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AnagraficaDTO>> getAllAnagrafica(

    ) {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}
