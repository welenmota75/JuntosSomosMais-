package br.ifsp.projetolp2.cliente;

public record ClienteResponseDTO (Long id, String gender, String name, String location, Integer telephone) {

    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(), cliente.getGender(), cliente.getName(), cliente.getLocation(), cliente.getTelephone());

    }
}
