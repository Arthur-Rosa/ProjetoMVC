package com.exemplo.sabado.sabado.repo;

// Importa a interface JpaRepository do Spring Data JPA, que fornece funcionalidades CRUD para a entidade.
import org.springframework.data.jpa.repository.JpaRepository;
// Importa a classe Invoice, que é a entidade modelo para esta aplicação.

import com.exemplo.sabado.sabado.model.Invoice;

// Define a interface InvoiceRepository, estendendo JpaRepository.
// Isso habilita o uso de métodos CRUD pré-definidos, além de permitir a definição de novos métodos de consulta.
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // Neste ponto, não há necessidade de adicionar quaisquer métodos adicionais.
    // A interface JpaRepository já inclui métodos como save(), findOne(), findAll(), count(), delete() etc.
    // Estes métodos são suficientes para realizar operações básicas de persistência para a entidade Invoice.

    // O tipo genérico <Invoice, Long> especifica que esta interface de repositório lida com a entidade Invoice
    // e que o tipo do seu identificador (ID) é Long.
}
