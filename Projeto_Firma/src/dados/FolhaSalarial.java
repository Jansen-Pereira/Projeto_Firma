package dados;

import java.io.FileInputStream; //arquivo leitura
import java.io.ObjectInputStream; //leitor

import java.io.FileOutputStream; //arquivo gravação
import java.io.ObjectOutputStream; //gravador

import java.io.IOException; //exceção de entrada e saída
import java.io.EOFException; //exceção fim de arquivo encontrado

import java.util.ArrayList;
import java.util.Iterator; //apontador para varrer o arraylist

import entidades.*;

public class FolhaSalarial {
    
    //////// ARRAYLIST //////// (coleção na memória)
    private ArrayList folha;

    public FolhaSalarial() { //cria coleção
        folha = new ArrayList();
    }

    public void inserir(Empregado e) {
        folha.add(e);//adiciona obj e ao ArrayList
      
    }
    
    public String listarTodos() {
        StringBuilder lista = new StringBuilder();
        
        //preencher lista com elementos da folha
        Iterator i = folha.iterator();
        while ( i.hasNext() ) { //enquanto tem um proximo obj no ArrayList
            Empregado e = (Empregado) i.next(); //retorna uma referencia Object
            lista.append(e); 
            //chama o metodo toString de Empregado e adiciona o texto à StringBuilder
        }
        
        
        return lista.toString();
    } 
    
    /////// ARQUIVO /////////
    private ObjectOutputStream gravacao;
    private final String dir = "src/dados/"; //grava no pacote dados do proj
    //se estiver usando Windows, mude o dir
    
    public ObjectOutputStream abreArquivoGravacao(){
        try {
                setGravacao(
                  new ObjectOutputStream(
                    new FileOutputStream(dir+"folha.ser")));
        }
        catch (IOException ex){
            System.err.println("\nErro abertura de arquivo:\n"+ex);
        }

        return getGravacao();
    }

    public void gravarObjetos () {
        try
        {
            //varrer obj arraylist gravando no arq
            Iterator it = folha.iterator(); //ponteiro aux p lista
            while ( it.hasNext() ) //se nao é null
                gravacao.writeObject( (Empregado)it.next() ); //pega obj e grava
        }
        catch ( IOException ex )
        {
            System.err.println( "\nErro gravacao do objeto no arquivo:\n" + ex);
        }

    }

    public void fechaArquivoGravacao() {
        try{
                if (gravacao != null)
                    gravacao.close();
        }
        catch(IOException ex){
            System.out.println("Erro fechar arquivo");
        }
    }


    //abertura e leitura do arquivo
    private ObjectInputStream leitura;

    public ObjectInputStream abreArquivoLeitura()
    {   try {   setLeitura(
                  new ObjectInputStream(
                    new FileInputStream(dir+"folha.ser")));
        }
        catch (IOException e){
            System.err.println("\nErro abertura de arquivo:\n"+e);
        }
        return leitura;
    }

    public void leRegistros()
    {   Empregado e;
        try
        {   folha.clear(); //limpa o arraylist
            while(true) //forçando EOFException
            {   e = ( Empregado ) leitura.readObject(); //le do arq 
                folha.add(e); //inclui no arraylist
            }
        }
        catch ( EOFException ex )
        {   return; // fim do arquivo foi alcançado
        }
        catch ( ClassNotFoundException ex )
        {   System.err.println( "Não foi possível criar o objeto.");
        }
        catch ( IOException ex )
        {   System.err.println("\nErro de leitura do arquivo:\n"+ex);
        }
    }

    public void fechaArquivoLeitura()
    {   try{   if (leitura != null)
                        leitura.close();
        }
        catch(IOException ex){
            System.out.println("\nErro fechar arquivo:\n"+ex);
        }
    }

    
    //getters&setters
    public ArrayList getFolha() { return folha; }
    public void setFolha(ArrayList folha) {
        this.folha = folha;
    }
    public ObjectOutputStream getGravacao() {
        return gravacao;
    }

    public ObjectInputStream getLeitura() {
        return leitura;
    }

    public void setGravacao(ObjectOutputStream gravacao) {
        this.gravacao = gravacao;
    }

    public void setLeitura(ObjectInputStream leitura) {
        this.leitura = leitura;
    }
}
