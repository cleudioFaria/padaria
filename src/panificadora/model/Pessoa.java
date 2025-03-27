package panificadora.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Grupo Pan
 */
public abstract class Pessoa implements Serializable{
    
    private int Codigo;
    private String Nome;
    private String Telefone;
    private String Endereco;
    private int Numero;
    private String Bairro;
    private String CEP;
    private String Cidade;
    private String UF;
    private Calendar Nascimento;
    
    public Pessoa(){
        
        this.Codigo=0;
        this.Nome="";
        this.Telefone="";
        this.Endereco="";
        this.Numero=0;
        this.Bairro="";
        this.CEP="";
        this.Cidade="";
        this.UF="";
        this.Nascimento=Calendar.getInstance();
        
    }
    
    public void setNascimento(Calendar Nascimento){
        this.Nascimento=Nascimento;
    }
    
    public Calendar getNascimento(){
        return this.Nascimento;
    }
    public void setCodigo (int Codigo){
        this.Codigo=Codigo;
    }
    
    public int getCodigo (){
        return this.Codigo;
    }
    
    public void setNome (String Nome) throws Exception{
        
        if (Nome.equals(""))
            throw new Exception("O Nome não foi informado! Digite o nome.");
        this.Nome=Nome;
    }
    public String getNome (){
        return this.Nome;
    }
    
    public void setTelefone (String Telefone)throws Exception {
        if (Telefone.equals(""))
            throw new Exception("O Telefone não foi informado! Digite o Telefone.");
        
        this.Telefone=Telefone;
    }
    public String getTelefone (){
        return this.Telefone;
    }
    
    public void setEndereco (String Endereco) throws Exception {
        if (Endereco.equals(""))
           throw new Exception("O Enderço não foi informado! Digite o Enderço.");
        this.Endereco=Endereco;
    }
    public String getEndereco (){
        return this.Endereco;
    }
    
    public void setNumero (int Numero)throws Exception {
        
        if (Numero==0)
            throw new Exception("O Numero não foi informado! Digite o Numero.");
        this.Numero=Numero;
    }
    public int getNumero (){
        return this.Numero;
    }
    
    public void setBairro (String Bairro)throws Exception{
        
        if (Bairro.equals(""))
            throw new Exception("O Bairro não foi informado! Digite o nome.");
        this.Bairro=Bairro;
    }
    public String getBairro (){
        return this.Bairro;
    }
    
    public void setCep (String CEP)throws Exception{
        if (CEP.equals(""))
           throw new Exception("O CEP não foi informado! Digite o CEP.");
        this.CEP=CEP;
    }
    public String getCep (){
        return this.CEP;
    }
    
    public void setCidade (String Cidade){
       // if (Cidade.equals(""))
          //  throw new Exception("A Cidade não foi informado! Digite o Cidade.");
        this.Cidade=Cidade;
    }
    public String getCidade (){
        return this.Cidade;
    }
    
    public void setUF (String Uf){
       // if (UF.equals(""))
          //  throw new Exception("O UF não foi informado! Digite o UF.");
        this.UF=Uf;
    }
    public String getUF (){
        return this.UF;
    }
    
}
