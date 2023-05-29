package br.ifsp.projetolp2.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name = "clientes")
@Entity(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    private String name;
    private String location;
    private Integer telephone;

    public Cliente(ClienteRequestDTO data){
        this.gender = data.gender();
        this.name = data.name();
        this.location = data.location();
        this.telephone = data.telephone();
    }
}


