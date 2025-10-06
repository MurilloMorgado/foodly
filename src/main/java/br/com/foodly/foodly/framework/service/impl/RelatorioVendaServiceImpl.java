package br.com.foodly.foodly.framework.service.impl;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.repositories.RelatorioVendaRepository;
import br.com.foodly.foodly.framework.service.RelatorioVendaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RelatorioVendaServiceImpl implements RelatorioVendaService {

    private final RelatorioVendaRepository relatorioVendaRepository;
}
