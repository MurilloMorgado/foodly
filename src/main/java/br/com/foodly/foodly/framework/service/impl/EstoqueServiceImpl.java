package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Estoque;
import br.com.foodly.foodly.framework.repositories.EstoqueRepository;
import br.com.foodly.foodly.framework.service.EstoqueService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;

    @Override
    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }
}
