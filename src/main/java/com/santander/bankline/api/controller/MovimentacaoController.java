package com.santander.bankline.api.controller;

import com.santander.bankline.api.domain.Movimentacao;
import com.santander.bankline.api.dto.MovimentacaoDTO;
import com.santander.bankline.api.repository.MovimentacaoRepository;
import com.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentaçoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacaoDTO) {
        movimentacaoService.save(movimentacaoDTO);
    }
}
