package banco;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public class ContaDTO {

    private int numero;
    private double saldo;
    
    public ContaDTO(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta: "+numero+"  Saldo: R$ "+saldo;
    }


}
