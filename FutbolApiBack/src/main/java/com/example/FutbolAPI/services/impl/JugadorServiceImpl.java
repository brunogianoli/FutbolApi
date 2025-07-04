package com.example.FutbolAPI.services.impl;

import com.example.FutbolAPI.DTOs.Get.GetJugadorPorIdDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadorPorRangoDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresActivosDTO;
import com.example.FutbolAPI.DTOs.Get.GetJugadoresDTO;
import com.example.FutbolAPI.DTOs.Post.PostJugadorDTO;
import com.example.FutbolAPI.entities.JugadorEntity;
import com.example.FutbolAPI.repositories.JugadorRepository;
import com.example.FutbolAPI.services.JugadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<GetJugadoresDTO> getAllJugadores() {
        List<JugadorEntity> jugadorEntityList = jugadorRepository.findAll();
        return jugadorEntityList.stream()
                .map(entity -> modelMapper.map(entity, GetJugadoresDTO.class))
                .toList();
    }

    @Override
    public List<GetJugadoresDTO> getAllJugadoresFiltrados(String club, String posicion, String desde, String hasta) {
        List<JugadorEntity> jugadorEntityList = jugadorRepository.findAll();
        return jugadorEntityList.stream()
                .filter( jugador -> !Objects.equals(jugador.getClub().toString(), club))
                .filter(jugador -> !Objects.equals(jugador.getPosicion(), posicion))
                .filter(jugador -> !Objects.equals(jugador.getDebut(), desde))
                .filter(jugador -> !Objects.equals(jugador.getRetiro(), hasta))
                .map(entity -> modelMapper.map(entity, GetJugadoresDTO.class))
                .toList();
    }


    @Override
    public GetJugadorPorIdDTO getJugadorByid(Long id) {
        JugadorEntity jugadorEntity = jugadorRepository.getReferenceById(id);
        return modelMapper.map(jugadorEntity, GetJugadorPorIdDTO.class);
    }


    @Override
    public List<GetJugadoresActivosDTO> getJugadoresActivos() {

        List<JugadorEntity> jugadorEntityList = jugadorRepository.findAll();

        return jugadorEntityList.stream()
                .filter(jugador -> jugador.getRetiro() == null) //Es como un findAll pero se agrega un filtro al retiro
                .map(entity -> modelMapper.map(entity, GetJugadoresActivosDTO.class))
                .toList();
    }

    @Override
    public List<GetJugadorPorRangoDTO> getJugadoresPorRango(String desde, String hasta) {
        List<JugadorEntity> jugadorEntityList = jugadorRepository.findAll();

        return jugadorEntityList.stream()
                .filter(jugador ->
                        jugador.getDebut().compareTo(desde) >= 0
                        && jugador.getDebut().compareTo(hasta) <= 0
                )
                .map(jugador -> modelMapper.map(jugador, GetJugadorPorRangoDTO.class))
                .toList();
    }

    @Override
    public PostJugadorDTO postJugador(PostJugadorDTO jugadorDTO) {
        jugadorRepository.save(modelMapper.map(jugadorDTO, JugadorEntity.class));
        return jugadorDTO;
    }

    @Override
    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);

    }
}


