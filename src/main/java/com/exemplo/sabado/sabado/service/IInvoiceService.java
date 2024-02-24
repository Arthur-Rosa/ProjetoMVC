package com.exemplo.sabado.sabado.service;

import java.util.List;
// Importa a classe Invoice do pacote com.exemplo.sabado.sabado.model.

import com.exemplo.sabado.sabado.model.Invoice;

// Define a interface IInvoiceService, que especifica os serviços relacionados às faturas que devem ser implementados.
public interface IInvoiceService {

    // Método para salvar uma nova fatura no sistema. Recebe um objeto Invoice e retorna o mesmo objeto, possivelmente com alterações (como um ID atribuído).
    public Invoice saveInvice(Invoice invoice);

    // Método para recuperar uma lista de todas as faturas presentes no sistema. Não recebe nenhum parâmetro e retorna uma lista de objetos Invoice.
    public List<Invoice> getAllInvoices();

    // Método para buscar uma fatura específica pelo seu ID. Recebe o ID da fatura como parâmetro e retorna o objeto Invoice correspondente.
    public Invoice getInvoiceById(Long id);

    // Método para deletar uma fatura do sistema pelo seu ID. Recebe o ID da fatura a ser deletada e não retorna nada.
    public void deleteInvoiceById(Long id);

    // Método para atualizar uma fatura existente no sistema. Recebe um objeto Invoice com as alterações e não retorna nada. Assume que o objeto Invoice já contém um ID válido.
    public void updateInvoice(Invoice invoice);

}
