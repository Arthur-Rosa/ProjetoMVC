package com.exemplo.sabado.sabado.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Importações necessárias para utilizar as classes relacionadas a exceção customizada, modelo, repositório e interface de serviço.

import com.exemplo.sabado.sabado.exception.InvoiceNotFoundException;
import com.exemplo.sabado.sabado.model.Invoice;
import com.exemplo.sabado.sabado.repo.InvoiceRepository;
import com.exemplo.sabado.sabado.service.IInvoiceService;

@Service // Anotação que indica que esta classe é um serviço Spring e pode ser injetado em outros componentes.
public class InvoiceServiceImpl implements IInvoiceService{ // Implementação da interface IInvoiceService, definindo os métodos para manipulação de faturas.

    @Autowired // Injeção de dependência automática do Spring para o repositório de faturas.
    private InvoiceRepository repo;

    @Override // Sobrescreve o método da interface para salvar uma fatura no banco de dados.
    public Invoice saveInvice(Invoice invoice) {
       return repo.save(invoice);
    }

    @Override // Sobrescreve o método da interface para recuperar todas as faturas do banco de dados.
    public List<Invoice> getAllInvoices() {
       return repo.findAll();
    }

    @Override // Sobrescreve o método da interface para buscar uma fatura pelo seu ID.
    public Invoice getInvoiceById(Long id) {
       Optional<Invoice> opt = repo.findById(id); // Busca a fatura pelo ID, que pode ou não existir.
       if(opt.isPresent()) { // Verifica se a fatura foi encontrada.
           return opt.get(); // Retorna a fatura encontrada.
       } else {
           throw new InvoiceNotFoundException("Invoice with Id : "+id+" Not Found"); // Lança uma exceção se a fatura não for encontrada.
       }
    }

    @Override // Sobrescreve o método da interface para deletar uma fatura pelo seu ID.
    public void deleteInvoiceById(Long id) {
       repo.delete(getInvoiceById(id)); // Utiliza o método getInvoiceById para buscar a fatura e depois deletá-la.
    }

    @Override // Sobrescreve o método da interface para atualizar uma fatura existente.
    public void updateInvoice(Invoice invoice) {
       repo.save(invoice); // Salva a fatura, atualizando-a se já existir ou criando uma nova se não existir.
    }
}
