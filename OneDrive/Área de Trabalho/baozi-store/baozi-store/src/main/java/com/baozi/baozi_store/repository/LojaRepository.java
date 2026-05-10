package com.baozibaozi.baozistore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baozibaozi.baozistore.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
    
    // Buscar loja por CNPJ (único)
    Optional<Loja> findByCnpj(String cnpj);
    
    // Buscar lojas por parte do nome (LIKE)
    List<Loja> findByNomeContainingIgnoreCase(String nome);
    
    // Buscar lojas por email
    Optional<Loja> findByEmail(String email);
    
    // Verificar se existe loja com determinado CNPJ
    boolean existsByCnpj(String cnpj);
}