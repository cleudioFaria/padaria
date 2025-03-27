package panificadora.model;

import java.io.Serializable;

/**
 *
 * @author Grupo Pan
 */
public class Produto implements Serializable{
    
    private int CodProd;
    private String Descricao;
    private double Valor;
    private String Tipo;
    private Fornecedor Fornecedor;
    private Funcionario Funcionario;
    
    public Produto(){
        
        this.CodProd=0;
        this.Descricao="";
        this.Valor=0;
        this.Tipo="";
        this.Fornecedor = new Fornecedor();
        this.Funcionario = new Funcionario();
        
    }

    public int getCodProd() {
        return CodProd;
    }
    public void setCodProd(int CodProd) throws Exception {
        if (CodProd==0)
            throw new Exception("O Codigo do Produto não foi informado! Digite o Codigo.");
        this.CodProd = CodProd;
    }

    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String Descricao)throws Exception {
        if (Descricao.equals(""))
            throw new Exception("A descricao do Produto não foi informado! Digite a Descrição.");
        this.Descricao = Descricao;
    }

    public double getValor() {
        return Valor;
    }
    public void setValor(double Valor) throws Exception {
        if (Valor==0)
            throw new Exception("O Valor do Produto não foi informado! Digite o Valor.");
        this.Valor = Valor;
    }

    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Fornecedor getFornecedor() {
        return Fornecedor;
    }
    public void setFornecedor(int Fornecedor) throws Exception { //recebe o codigo do fornecedor
        if (Fornecedor==0)
            throw new Exception("O Fordecedor do Produto não foi informado! Digite o Forcedor.");
        this.Fornecedor.setCodigo(Fornecedor);
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }
    public void setFuncionario(int Funcionario) throws Exception{ //recebe o código do funcionario
        this.Funcionario.setCodigo(Funcionario);
    }
    
}
