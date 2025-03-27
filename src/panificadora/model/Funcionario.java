package panificadora.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Grupo Pan
 */
public class Funcionario extends Pessoa implements Serializable{
    
    private String CPF;
    private String RG;
    private Calendar dataNascimento;
    private String Cargo;
    private double Salario;
    private Calendar Admissao;
    private Calendar Demissao;
    
    public Funcionario (){
        
        super();
        this.CPF="";
        this.RG="";
        this.dataNascimento=null;
        this.Cargo="";
        this.Salario=0;
        this.Admissao=Calendar.getInstance();
        this.Demissao=null;
        
    }

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return this.RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }

    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return this.Cargo;
    }
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSalario() {
        return this.Salario;
    }
    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public Calendar getAdmissao() {
        return this.Admissao;
    }
    public void setAdmissao(Calendar Admissao) {
        this.Admissao = Admissao;
    }

    public Calendar getDemissao() {
        return Demissao;
    }
    public void setDemissao(Calendar Demissao) {
        this.Demissao = Demissao;
    }

    public void setDataAdmissao(String Admissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDataDemissao(String Demissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
