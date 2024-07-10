import java.util.Scanner;

public class MainContaBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o saldo inicial da conta:");
        double saldoInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(saldoInicial);

        System.out.println("Informe o valor do depósito:");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        System.out.println("Informe o valor do saque:");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        scanner.close();
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito feito.");
        imprimirSaldo();
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            System.out.println("Saque feito.");
        } else {
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
        imprimirSaldo();
    }

    private void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}
