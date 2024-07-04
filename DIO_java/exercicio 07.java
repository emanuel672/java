import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o saldo inicial da conta: ");
        double saldo = scanner.nextDouble();

        System.out.print("Digite a quantidade de transacoes que deseja realizar: ");
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            System.out.print("Digite o tipo da transacao (D para deposito ou S para saque): ");
            char tipoTransacao = scanner.next().charAt(0);

            System.out.print("Digite o valor da transacao: ");
            double valorTransacao = scanner.nextDouble();

            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);

            // Atualiza o saldo da conta com base no tipo de transacao
            if (tipoTransacao == 'D') {
                saldo += valorTransacao;
            } else if (tipoTransacao == 'S') {
                saldo -= valorTransacao;
            }
        }

        System.out.println("\nSaldo: " + saldo);
        System.out.println("\nTransacoes:");
        transacoes.stream()
                .map(transacao -> transacao.getTipo() + " de " + transacao.getValor())
                .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
