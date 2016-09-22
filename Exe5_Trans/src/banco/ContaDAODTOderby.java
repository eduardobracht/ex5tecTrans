package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public class ContaDAODTOderby implements ContaDAO {

    @Override
    public List<ContaDTO> buscarTodos() throws Exception {
        List<ContaDTO> list = new ArrayList();
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "select * from CONTAS";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultados = comando.executeQuery()) {
                    while (resultados.next()) {
                        list.add(new ContaDTO(
                                resultados.getInt("NUMERO"),
                                resultados.getDouble("SALDO")));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void inserir(ContaDTO conta) throws Exception {
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "insert into CONTAS(NUMERO,SALDO) values (?,?)";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {

                comando.setInt(1, conta.getNumero());
                comando.setDouble(2, conta.getSaldo());

                if (comando.executeUpdate() > 0) {
                    System.out.println("Inserção efetuada com sucesso");
                } else {
                    System.out.println("Falha na inserção");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ContaDTO buscarPorNumero(int pid) throws Exception {
        ContaDTO conta = null;
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "select * from CONTAS where NUMERO = ?";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, pid);
                try (ResultSet resultados = comando.executeQuery()) {
                    resultados.next();
                    conta = new ContaDTO(
                            resultados.getInt("NUMERO"),
                            resultados.getDouble("SALDO"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conta;
    }

    //Não implementado
    @Override
    public void alterar(ContaDTO conta) throws Exception {
    }

}
