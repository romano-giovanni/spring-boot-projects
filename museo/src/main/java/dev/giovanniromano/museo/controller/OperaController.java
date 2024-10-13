package dev.giovanniromano.museo.controller;

import dev.giovanniromano.museo.api.ApiUtil;
import dev.giovanniromano.museo.api.OpereApi;
import dev.giovanniromano.museo.model.OperaDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperaController implements OpereApi {

    public ResponseEntity<List<OperaDto>> opereGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OperaDto> opereIdOperaGet(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Integer idOpera
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OperaDto> opereIdOperaPut(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Integer idOpera,
            @Parameter(name = "OperaDto", description = "Dati aggiornati dell'opera", required = true) @Valid @RequestBody OperaDto operaDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> operePost(
            @Parameter(name = "OperaDto", description = "Dati della nuova opera", required = true) @Valid @RequestBody OperaDto operaDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
