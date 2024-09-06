package com.example.testeJunior.service;

import com.example.testeJunior.entity.Cliente;
import com.example.testeJunior.repository.ClienteRepository;
import com.example.testeJunior.util.ValidadorCPF;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        if (!ValidadorCPF.CPFValido(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return clienteRepository.save(cliente);
    }
    @Transactional
    public Cliente atualizar(Long id,Cliente cliente) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        if (!ValidadorCPF.CPFValido(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setSobrenome(cliente.getSobrenome());
        clienteExistente.setIdade(cliente.getIdade());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setEndereco(cliente.getEndereco());

        return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
