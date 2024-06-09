package Aulab;
import java.time.LocalDate;

public class Pessoa {
    private int id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
 
    // Construtor
    public Pessoa(int id, String nome, String sexo, LocalDate dataNascimento, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }
 
    public Pessoa(String nome, String sexo, LocalDate dataNascimento, String endereco, String telefone) {
        this(0, nome, sexo, dataNascimento, endereco, telefone);
    }
 
    // Getters e Setters
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getSexo() {
        return sexo;
    }
 
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
 
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
 
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
 
    public String getEndereco() {
        return endereco;
    }
 
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
 
    public String getTelefone() {
        return telefone;
    }
 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + '\'' + ", sexo='" + sexo + '\'' + ", dataNascimento=" + dataNascimento + ", endereco='" + endereco + '\'' + ", telefone='" + telefone + '\'' + '}';
    }
}