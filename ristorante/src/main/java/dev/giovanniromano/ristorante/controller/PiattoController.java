package dev.giovanniromano.ristorante.controller;

import dev.giovanniromano.ristorante.api.MenuApi;
import dev.giovanniromano.ristorante.model.PiattoDto;
import dev.giovanniromano.ristorante.service.PiattoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PiattoController implements MenuApi {

    @Autowired
    PiattoService service;

    @Override
    public ResponseEntity<PiattoDto> createPiatto(
            @Parameter(name = "PiattoDto", description = "", required = true) @Valid @RequestBody PiattoDto piattoDto
    ) {
        PiattoDto dto = service.save(piattoDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<PiattoDto>> getPiattiByTipologia(
            @NotNull @Parameter(name = "tipologia", description = "La tipologia del piatto (es. Primo, Secondo, Dolce, etc.)", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "tipologia", required = true) String tipologia
    ) {
        List<PiattoDto> dtoList = service.searchByType(PiattoDto.TipologiaEnum.fromValue(tipologia));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PiattoDto> getPiattoById(
            @Parameter(name = "idPiatto", description = "L'ID del piatto", required = true, in = ParameterIn.PATH) @PathVariable("idPiatto") Integer idPiatto
    ) {
        PiattoDto dto = service.getById(idPiatto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
