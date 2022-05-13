
package entidades;

import java.text.NumberFormat;


public class Vendedor extends Empregado{
    private double comissao;
 

    public Vendedor(String m, String n, double s, double c) {
        super(m, n, s);
        this.comissao = c;
    }

    @Override
    public double calc() {
        return super.calc() * (1 + this.comissao / 100);
    }
    
    //super.calc() retorna salario*0.85 (da superclasse)
    
   
    
    //método padrão toString() para imprimir atributos
    @Override
    public String toString() {
        //formatação moeda
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        NumberFormat percentual = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        
        return "Vendedor: "+getNome() + " - Matricula: "+ getMatricula()+
                " - Salário: "+ nf.format( calc() ) +  " (já incluída a comissão de: "
                + percentual.format(getComissao()) + ")\n";
    }
    
//getters & setters

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    
}