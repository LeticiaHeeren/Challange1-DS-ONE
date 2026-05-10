package com.baozibaozi.baozistore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.baozibaozi.baozistore.model.Loja;
import com.baozibaozi.baozistore.repository.LojaRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private LojaRepository lojaRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Só insere se o banco estiver vazio
        if (lojaRepository.count() == 0) {
            
            Loja loja1 = new Loja(
                "BaoZi Store - Centro",
                "Rua das Flores, 123 - Centro",
                "12.345.678/0001-90"
            );
            loja1.setTelefone("(11) 99999-0001");
            loja1.setEmail("centro@baozistore.com");
            
            Loja loja2 = new Loja(
                "BaoZi Store - Shopping",
                "Av. Principal, 456 - Loja 10",
                "98.765.432/0001-10"
            );
            loja2.setTelefone("(11) 99999-0002");
            loja2.setEmail("shopping@baozistore.com");
            
            Loja loja3 = new Loja(
                "BaoZi Store - Online",
                "E-commerce",
                "55.555.555/0001-55"
            );
            loja3.setTelefone("0800-123-456");
            loja3.setEmail("online@baozistore.com");
            
            lojaRepository.save(loja1);
            lojaRepository.save(loja2);
            lojaRepository.save(loja3);
            
            System.out.println("✅ Dados iniciais inseridos com sucesso!");
            System.out.println("📦 " + lojaRepository.count() + " lojas cadastradas.");
        } else {
            System.out.println("📦 Banco já possui " + lojaRepository.count() + " lojas.");
        }
    }
}