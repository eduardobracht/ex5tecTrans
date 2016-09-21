package banco;

import java.util.List;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public interface ContaDAO {

    List<ContaDTO> buscarTodos() throws Exception;

    ContaDTO buscarPorNumero(int numero) throws Exception;

    void inserir(ContaDTO conta) throws Exception;

    void alterar(ContaDTO conta) throws Exception;
}
