package br.com.foodly.foodly.framework.service.impl;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.repositories.PessoaRepository;
import br.com.foodly.foodly.framework.service.PessoaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
}
