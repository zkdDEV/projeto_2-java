import dao.ClienteDAO;
import dao.ClienteDAOMock;
import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(1234567891L);
        cliente.setNome("Matheus");
        cliente.setCidade("Curitiba");
        cliente.setEndereco("end");
        cliente.setEstado("Paraná");
        cliente.setNumero(123);
        cliente.setTel(1234567891L);
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean resultado = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(resultado);
    }

    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Matheus Reichemback Stang");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Matheus Reichemback Stang", cliente.getNome());
    }

}
