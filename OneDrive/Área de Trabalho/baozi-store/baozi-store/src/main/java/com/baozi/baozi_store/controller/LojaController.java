package com.baozibaozi.baozistore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baozibaozi.baozistore.model.Loja;
import com.baozibaozi.baozistore.repository.LojaRepository;

@RestController
@RequestMapping("/api/lojas")  // Todos os endpoints começam com /api/lojas
@CrossOrigin("*")  // Permite requisições de qualquer origem (Postman, frontend, etc.)
public class LojaController {
    
    @Autowired
    private LojaRepository lojaRepository;
    
    // ============ CREATE ============
    
    /**
     * POST /api/lojas
     * Cadastra uma nova loja
     */
    @PostMapping
    public ResponseEntity<Loja> cadastrarLoja(@RequestBody Loja loja) {
        try {
            // Verifica se já existe loja com esse CNPJ
            if (lojaRepository.existsByCnpj(loja.getCnpj())) {
                return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(null);  // 409 Conflict
            }
            
            Loja novaLoja = lojaRepository.save(loja);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaLoja);  // 201 Created
            
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);  // 500 Internal Server Error
        }
    }
    
    // ============ READ (Todos) ============
    
    /**
     * GET /api/lojas
     * Lista todas as lojas cadastradas
     */
    @GetMapping
    public ResponseEntity<List<Loja>> listarTodasLojas() {
        List<Loja> lojas = lojaRepository.findAll();
        
        if (lojas.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(lojas);  // 204 No Content
        }
        
        return ResponseEntity.ok(lojas);  // 200 OK
    }
    
    // ============ READ (Por ID) ============
    
    /**
     * GET /api/lojas/{id}
     * Busca uma loja pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Loja> buscarLojaPorId(@PathVariable Long id) {
        Optional<Loja> loja = lojaRepository.findById(id);
        
        if (loja.isPresent()) {
            return ResponseEntity.ok(loja.get());  // 200 OK
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);  // 404 Not Found
        }
    }
    
    // ============ READ (Busca por CNPJ) ============
    
    /**
     * GET /api/lojas/cnpj/{cnpj}
     * Busca uma loja pelo CNPJ
     */
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Loja> buscarLojaPorCnpj(@PathVariable String cnpj) {
        Optional<Loja> loja = lojaRepository.findByCnpj(cnpj);
        
        if (loja.isPresent()) {
            return ResponseEntity.ok(loja.get());  // 200 OK
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);  // 404 Not Found
        }
    }
    
    // ============ UPDATE ============
    
    /**
     * PUT /api/lojas/{id}
     * Atualiza os dados de uma loja existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Loja> atualizarLoja(
            @PathVariable Long id, 
            @RequestBody Loja lojaAtualizada) {
        
        Optional<Loja> lojaExistente = lojaRepository.findById(id);
        
        if (lojaExistente.isPresent()) {
            Loja loja = lojaExistente.get();
            
            // Atualiza os campos
            loja.setNome(lojaAtualizada.getNome());
            loja.setEndereco(lojaAtualizada.getEndereco());
            loja.setCnpj(lojaAtualizada.getCnpj());
            loja.setTelefone(lojaAtualizada.getTelefone());
            loja.setEmail(lojaAtualizada.getEmail());
            
            Loja lojaSalva = lojaRepository.save(loja);
            return ResponseEntity.ok(lojaSalva);  // 200 OK
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);  // 404 Not Found
        }
    }
    
    // ============ DELETE ============
    
    /**
     * DELETE /api/lojas/{id}
     * Remove uma loja do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLoja(@PathVariable Long id) {
        Optional<Loja> loja = lojaRepository.findById(id);
        
        if (loja.isPresent()) {
            lojaRepository.deleteById(id);
            return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();  // 204 No Content
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();  // 404 Not Found
        }
    }
    
    // ============ Busca por nome ============
    
    /**
     * GET /api/lojas/busca?nome=Termo
     * Busca lojas por parte do nome
     */
    @GetMapping("/busca")
    public ResponseEntity<List<Loja>> buscarPorNome(
            @RequestParam String nome) {
        
        List<Loja> lojas = lojaRepository.findByNomeContainingIgnoreCase(nome);
        
        if (lojas.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(lojas);  // 204 No Content
        }
        
        return ResponseEntity.ok(lojas);  // 200 OK
    }
}