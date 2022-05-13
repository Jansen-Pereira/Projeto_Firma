package entidades;

import java.io.Serializable;


public abstract class Empregado implements Calculos, Constantes, Serializable {
    private String nome, matricula;
    private double salario;

    //construtor comum
    public Empregado(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    //construtor padrão
    public Empregado() { }
    
    @Override
    public double calc() {
        return salario * DESCONTO;
    }
    
   
    
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public double getSalario() { return salario; }
    public void setNome(String nome) { this.nome = nome; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setSalario(double salario) { this.salario = salario; }
    
}