package com.santander.bankline.api.service;

import com.santander.bankline.api.domain.Correntista;
import com.santander.bankline.api.domain.Movimentacao;
import com.santander.bankline.api.domain.TipoMovimentacao;
import com.santander.bankline.api.dto.MovimentacaoDTO;
import com.santander.bankline.api.repository.CorrentistaRepository;
import com.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDTO movimentacaoDTO) {
        Movimentacao movimentacao = new Movimentacao();

//        Double valor = movimentacaoDTO.getTipoMovimentacao()== TipoMovimentacao.RECEITA ?
//                movimentacaoDTO.getValor() : movimentacaoDTO.getValor() * -1;

        Double valor = movimentacaoDTO.getValor();
        if (movimentacaoDTO.getTipoMovimentacao() == TipoMovimentacao.DESPESA)
            valor = valor * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(movimentacaoDTO.getDescricao());
        movimentacao.setIdConta(movimentacaoDTO.getIdConta());
        movimentacao.setTipoMovimentacao(movimentacaoDTO.getTipoMovimentacao());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(movimentacaoDTO.getIdConta())
                .orElse(null);
        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }
}
