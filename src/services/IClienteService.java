package services;

import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;

public interface IClienteService {
    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);
    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
