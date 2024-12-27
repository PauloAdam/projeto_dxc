package com.pauloadam.crud_dxc.repository;

import com.pauloadam.crud_dxc.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM clientes WHERE nome = :nome", nativeQuery = true)
    List<Cliente> buscarPorNome(String nome);

    @Modifying
    @Query(value = "UPDATE clientes SET nome = :nome, email = :email WHERE id = :id", nativeQuery = true)
    void atualizarCliente(Long id, String nome, String email);

    @Modifying
    @Query(value = "DELETE FROM clientes WHERE id = :id", nativeQuery = true)
    void excluirCliente(Long id);
}
