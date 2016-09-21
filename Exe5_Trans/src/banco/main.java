package banco;

import java.util.List;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 * 
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Criando DB
        System.out.println("Criando Database...");
        try {
            StartDBDataSource.criarBd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ContaDAODTOderby dao = new ContaDAODTOderby();

        //Inserindo elementos no DB
        System.out.println("Inserindo dados na tabela...");
        try {
            for(int i=1;i<=50;i++) 
                dao.inserir(new ContaDTO(i,5000.00));            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Listando todas as contas
        System.out.println();
        System.out.println("Listando todas as contas da tabela:");
        try {
            List<ContaDTO> list = dao.buscarTodos();
            for (ContaDTO conta : list) {
                System.out.println(conta.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Buscar por PID = 1
        System.out.println();
        System.out.println("Listando conta com PID = 1:");
        try {
            ContaDTO instrumento = dao.buscarPorNumero(1);
            System.out.println(instrumento.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
