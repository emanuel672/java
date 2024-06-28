import java.util.Scanner;

public class VerificadorNumeroConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o número da conta (8 dígitos): ");
            String numeroConta = scanner.nextLine();

            verificarNumeroConta(numeroConta);

            // Se chegou aqui, significa que o número de conta é válido
            System.out.println("Número de conta válido.");
        } catch (IllegalArgumentException e) {
            // Captura a exceção caso o número de conta seja inválido
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fechar o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    private static void verificarNumeroConta(String numeroConta) {
        if (numeroConta.length() != 8) {
            throw new IllegalArgumentException("Número de conta inválido. Digite exatamente 8 dígitos.");
        }

        // Se não houver exceção lançada, o número de conta é válido
    }
}
