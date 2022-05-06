package com.santander.bankline.api.repository;

import com.santander.bankline.api.domain.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
