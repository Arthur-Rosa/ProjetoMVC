package com.exemplo.sabado.sabado.model;

// Importações das anotações do Jakarta Persistence, que são usadas para mapeamento objeto-relacional (ORM).
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// Importações das anotações do Lombok, que fornecem uma maneira sucinta de criar beans Java com menos boilerplate.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Anotação que indica que esta classe é uma entidade JPA. Isso significa que objetos desta classe podem ser mapeados para linhas em uma tabela de banco de dados.
@Data // Anotação do Lombok que gera automaticamente getters, setters, toString, equals e hashCode para todos os campos da classe.
@NoArgsConstructor // Anotação do Lombok que gera um construtor sem argumentos. Necessário para JPA.
@AllArgsConstructor // Anotação do Lombok que gera um construtor que recebe um argumento para cada campo na classe. Útil para criação de instâncias com todas as propriedades inicializadas.
public class Invoice {

    @Id // Anotação que indica que o campo abaixo é o identificador único da entidade.
    @GeneratedValue // Anotação que especifica que o valor do ID deve ser gerado automaticamente pelo provedor de persistência, ou seja, o banco de dados.
    private Long id; // Campo que armazena o identificador único da fatura.

    private String name; // Campo que armazena o nome associado à fatura. Não é necessário anotação específica, pois será mapeado como uma coluna com o mesmo nome.
    private String location; // Campo que armazena a localização associada à fatura. Mapeado automaticamente para uma coluna chamada 'location'.
    private Double amount; // Campo que armazena o valor monetário da fatura. Mapeado automaticamente para uma coluna chamada 'amount'.
}
