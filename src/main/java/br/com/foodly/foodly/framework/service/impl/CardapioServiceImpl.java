package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Cardapio;
import br.com.foodly.foodly.framework.repositories.CardapioRepository;
import br.com.foodly.foodly.framework.service.CardapioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CardapioServiceImpl implements CardapioService {

    private final CardapioRepository cardapioRepository;

    @Override
    public List<Cardapio> listarCardapio() {

        return cardapioRepository.findAll();
    }

}
