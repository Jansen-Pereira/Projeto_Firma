
package entidades;


import java.text.NumberFormat;

public class Engenheiro extends Empregado {
    private String titulo;
    

    //construtor herança
    public Engenheiro(String m, String n, double s, String t) {
        super(m, n, s);
        this.titulo = t;
    }
    
    
    
    
     //método padrão toString() para imprimir atributos
    @Override
    public String toString() {
        //formatação moeda
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        
        return "Engenheiro(a) "+ getTitulo()+": "+getNome() + " - Matricula: "+ getMatricula()+
                " - Salário: "+ nf.format( calc() )+ "\n";
    }
    

    
//getters & setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
