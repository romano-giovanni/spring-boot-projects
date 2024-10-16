package dev.giovanniromano.anagrafica.controller;

import dev.giovanniromano.anagrafica.api.AnagraficaApi;
import dev.giovanniromano.anagrafica.model.AnagraficaDTO;
import dev.giovanniromano.anagrafica.service.AnagraficaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagraficaController implements AnagraficaApi {

    Logger logger = LoggerFactory.getLogger(AnagraficaController.class);

    @Autowired
    AnagraficaService service;

    @Override
    public ResponseEntity<AnagraficaDTO> createAnagrafica(
            @Parameter(name = "AnagraficaDTO", description = "Crea una nuova Anagrafica", required = true) @Valid @RequestBody AnagraficaDTO anagraficaDTO
    ) {
        AnagraficaDTO result = service.save(anagraficaDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteAnagrafica(@Parameter(name = "idAnagrafica",description = "ID dell'anagrafica da eliminare",required = true,in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {
        String result = service.delete(idAnagrafica);
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<AnagraficaDTO> findAnagraficaById(@Parameter(name = "idAnagrafica",description = "ID dell'anagrafica da cercare",required = true,in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {
        AnagraficaDTO result = service.findById(idAnagrafica);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AnagraficaDTO>> getAllAnagrafica() {
        List<AnagraficaDTO> result = service.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AnagraficaDTO> updateAnagrafica(
            @Parameter(name = "idAnagrafica", description = "ID dell'anagrafica da aggiornare", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica,
            @Parameter(name = "AnagraficaDTO", description = "I nuovi dati dell'Anagrafica", required = true) @Valid @RequestBody AnagraficaDTO anagraficaDTO
    ) {
        AnagraficaDTO result = service.update(idAnagrafica, anagraficaDTO);
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);

    }
}
