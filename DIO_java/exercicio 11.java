import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Método de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Físico", "Chave");
    }

}

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o tipo de cofre
        System.out.println("Digite o tipo de cofre (digital ou físico):");
        String tipoCofre = scanner.nextLine();

        // Verifica o tipo de cofre escolhido
        if (tipoCofre.equalsIgnoreCase("digital")) {
            // Para cofre digital, solicita a senha e confirmação da senha
            System.out.println("Digite a senha do cofre digital:");
            int senha = scanner.nextInt();
            System.out.println("Confirme a senha do cofre digital:");
            int confirmacaoSenha = scanner.nextInt();

            // Cria o cofre digital com a senha fornecida
            CofreDigital cofreDigital = new CofreDigital(senha);

            // Valida a senha
            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                cofreDigital.imprimirInformacoes();
            } else {
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equalsIgnoreCase("físico")) {
            // Cria o cofre físico
            CofreFisico cofreFisico = new CofreFisico();
            cofreFisico.imprimirInformacoes();
        } else {
            System.out.println("Tipo de cofre inválido. Escolha entre digital ou físico.");
        }

        scanner.close();
    }
}
