package dev.giovanniromano.portale.service.impl;

import dev.giovanniromano.portale.client.api.AnagraficaApi;
import dev.giovanniromano.portale.client.model.AnagraficaClient;
import dev.giovanniromano.portale.mapper.ClientToDto;
import dev.giovanniromano.portale.server.model.AnagraficaDTO;
import dev.giovanniromano.portale.service.AnagraficaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaClientServiceImpl implements AnagraficaClientService {

    @Autowired
    AnagraficaApi anagrafricaApiClient;

    @Autowired
    ClientToDto clientToDto;

    @Override
    public List<AnagraficaDTO> getAll() {
        List<AnagraficaClient> res = anagrafricaApiClient.getAllAnagrafica();
        return clientToDto.anagraficaList(res);
    }

    @Override
    public AnagraficaDTO getById(Long id) {
        AnagraficaClient res = anagrafricaApiClient.findAnagraficaById(id);
        return clientToDto.anagrafica(res);
    }
}
