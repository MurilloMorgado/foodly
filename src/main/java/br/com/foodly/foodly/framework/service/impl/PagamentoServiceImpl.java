package br.com.foodly.foodly.framework.service.impl;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.repositories.PagamentosRepository;
import br.com.foodly.foodly.framework.service.PagamentosService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PagamentoServiceImpl implements PagamentosService {

    private final PagamentosRepository pagamentosRepository;
}
