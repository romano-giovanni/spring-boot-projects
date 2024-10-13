package dev.giovanniromano.museo.controller;

import dev.giovanniromano.museo.api.OpereApi;
import dev.giovanniromano.museo.model.OperaDto;
import dev.giovanniromano.museo.service.OperaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OperaController implements OpereApi {

    @Autowired
    OperaService service;

    public ResponseEntity<List<OperaDto>> opereGet() {
        List<OperaDto> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<OperaDto> opereIdOperaGet(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Integer idOpera
    ) {
        return new ResponseEntity<>(service.findById(idOpera), HttpStatus.OK);
    }

    public ResponseEntity<OperaDto> opereIdOperaPut(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Integer idOpera,
            @Parameter(name = "OperaDto", description = "Dati aggiornati dell'opera", required = true) @Valid @RequestBody OperaDto operaDto
    ) {
        OperaDto dto = service.update(idOpera, operaDto);
        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> operePost(
            @Parameter(name = "OperaDto", description = "Dati della nuova opera", required = true) @Valid @RequestBody OperaDto operaDto
    ) {
        service.save(operaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> opereIdOperaDelete(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Integer idOpera
    ) {
        service.deleteById(idOpera);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
