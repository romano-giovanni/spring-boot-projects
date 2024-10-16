package dev.giovanniromano.portale.mapper;

import dev.giovanniromano.portale.client.model.AnagraficaClient;
import dev.giovanniromano.portale.server.model.AnagraficaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToClient {
    AnagraficaClient anagrafica (AnagraficaDTO dto);
    List<AnagraficaClient> anagraficaList(List<AnagraficaDTO> dtoList);
}
