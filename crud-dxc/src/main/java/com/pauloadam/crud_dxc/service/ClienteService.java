package com.pauloadam.crud_dxc.service;

import com.pauloadam.crud_dxc.model.Cliente;
import com.pauloadam.crud_dxc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM clientes";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            return cliente;
        });
    }

    @Transactional
    public void atualizarCliente(Long id, String nome, String email) {
        clienteRepository.atualizarCliente(id, nome, email);
    }

    @Transactional
    public void excluirCliente(Long id) {
        clienteRepository.excluirCliente(id);
    }
}
