import java.text.DecimalFormat;
import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        // Lendo os dados de Entrada:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o titular da conta:");
        String titular = scanner.nextLine();
        System.out.println("Informe o número da conta:");
        int numeroConta = scanner.nextInt();
        System.out.println("Informe o saldo inicial da conta:");
        double saldo = scanner.nextDouble();
        System.out.println("Informe a taxa de juros da conta poupança:");
        double taxaJuros = scanner.nextDouble();

        // Criando uma instância de ContaPoupanca
        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, titular, saldo, taxaJuros);

        // Exibindo as informações da conta poupança
        System.out.println("\nConta Poupança:");
        contaPoupanca.exibirInformacoes();

        scanner.close();
    }
}

class ContaBancaria {
    protected int numero;
    protected String titular;
    protected double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void exibirInformacoes() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("Titular: " + titular);
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: R$ " + decimalFormat.format(saldo));
    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double saldo, double taxaJuros) {
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("Taxa de juros: " + decimalFormat.format(taxaJuros) + "% ao ano");
    }
}
