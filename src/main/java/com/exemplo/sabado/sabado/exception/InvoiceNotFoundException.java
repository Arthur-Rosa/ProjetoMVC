package com.exemplo.sabado.sabado.exception;

// Define uma classe de exceção personalizada que estende RuntimeException.
// Esta exceção é específica para situações em que uma fatura não é encontrada no sistema.
public class InvoiceNotFoundException extends RuntimeException {

    // Um identificador de versão único para a classe Serializable.
    // É usado durante a desserialização para verificar que o remetente e o receptor de um objeto serializado
    // tenham carregado classes para esse objeto que são compatíveis em relação à serialização.
    private static final long serialVersionUID = 1L;

    // Construtor padrão que invoca o construtor da superclasse (RuntimeException),
    // criando uma exceção sem mensagem de erro.
    public InvoiceNotFoundException() {
        super();
    }

    // Construtor que aceita uma mensagem personalizada como parâmetro.
    // Esta mensagem é passada para o construtor da superclasse (RuntimeException),
    // permitindo que a exceção contenha uma mensagem específica de erro.
    public InvoiceNotFoundException(String customMessage) {
        super(customMessage);
    }
}
