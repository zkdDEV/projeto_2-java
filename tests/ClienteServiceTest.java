import dao.ClienteDAOMock;
import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ClienteService;
import services.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(1234567891L);
        cliente.setNome("Matheus");
        cliente.setCidade("Curitiba");
        cliente.setEndereco("end");
        cliente.setEstado("Paraná");
        cliente.setNumero(123);
        cliente.setTel(1234567891L);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean resultado = clienteService.salvar(cliente);
        Assert.assertTrue(resultado);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Matheus Reichemback Stang");
        clienteService.alterar(cliente);

        Assert.assertEquals("Matheus Reichemback Stang", cliente.getNome());
    }
}
