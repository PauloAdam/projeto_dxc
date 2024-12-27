package com.pauloadam.crud_dxc;

import com.pauloadam.crud_dxc.model.Cliente;
import com.pauloadam.crud_dxc.service.ClienteService;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testCriarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Teste Nome");
        cliente.setEmail("teste@email.com");
        Cliente salvo = clienteService.criarCliente(cliente);
        assertNotNull(salvo);
        assertEquals("Teste Nome", salvo.getNome());
    }

    @Test
    public void testListarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
    }

    @Test
    public void testAtualizarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Nome Original");
        cliente.setEmail("original@email.com");
        Cliente salvo = clienteService.criarCliente(cliente);

        clienteService.atualizarCliente(salvo.getId(), "Nome Alterado", "alterado@email.com");
        List<Cliente> clientes = clienteService.listarClientes();
        assertTrue(clientes.stream().anyMatch(c -> "Nome Alterado".equals(c.getNome())));
    }

    @Test
    public void testExcluirCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Excluir Nome");
        cliente.setEmail("excluir@email.com");
        Cliente salvo = clienteService.criarCliente(cliente);

        clienteService.excluirCliente(salvo.getId());
        List<Cliente> clientes = clienteService.listarClientes();
        assertFalse(clientes.stream().anyMatch(c -> "Excluir Nome".equals(c.getNome())));
    }
}
