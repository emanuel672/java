import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o saldo atual da conta: ");
        double saldo = scanner.nextDouble();

        System.out.print("Digite o valor do saque desejado: ");
        double saque = scanner.nextDouble();

        // Define um limite para o cheque especial
        double limiteChequeEspecial = 500;

        // Verifica se o saque ultrapassa o saldo disponível
        if (saque <= saldo) {
            System.out.println("Transação realizada com sucesso.");
        } else {
            // Verifica se o saque ultrapassa o limite do cheque especial
            if (saque - saldo > limiteChequeEspecial) {
                System.out.println("Transação não realizada. Limite do cheque especial excedido.");
            } else {
                System.out.println("Transação realizada com sucesso utilizando o cheque especial.");
            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
