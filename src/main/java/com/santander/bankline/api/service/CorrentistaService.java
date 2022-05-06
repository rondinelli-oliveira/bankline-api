package com.santander.bankline.api.service;

import com.santander.bankline.api.domain.Conta;
import com.santander.bankline.api.domain.Correntista;
import com.santander.bankline.api.dto.CorrentistaDTO;
import com.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(CorrentistaDTO correntistaDTO) {
        Correntista correntista = new Correntista();
        correntista.setNome(correntista.getNome());
        correntista.setCpf(correntista.getCpf());

        Conta conta = new Conta();
        conta.setSaldo(0.00);
        //utilizado para simular a geração da conta do um dado do tipo Long
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
    }
}
