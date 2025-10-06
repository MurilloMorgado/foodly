package br.com.foodly.foodly.framework.service.impl;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.repositories.PromocaoRepository;
import br.com.foodly.foodly.framework.service.PromocaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PromocaoServiceImpl implements PromocaoService {

    private final PromocaoRepository promocaoRepository;
}
