package panificadora.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVenda implements Serializable{
    
    private int CodCartao;
    private double Total;
    private Produto Produto;
    private ArrayList<Produto> listaProduto;
    private Funcionario funcionario;
    
    public CartaoVenda(){
        
        this.CodCartao=0;
        this.Total=0;
        this.Produto = new Produto();
        this.funcionario = new Funcionario();
        
    }

    public int getCodCartao() {
        return CodCartao;
    }
    public void setCodCartao(int CodCartao) {
        this.CodCartao = CodCartao;
    }

    public double getTotal() {
        return Total;
    }
    public void setTotal(double Total) {
        this.Total = Total;
    }

    public ArrayList<Produto> getProduto() {
        return listaProduto;
    }
    public void setProduto(Produto Produto) {
        this.listaProduto.add(Produto);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(int Funcionario) { //recebe o código do funcionario
        this.funcionario.setCodigo(Funcionario);
    }
    
    public void CalculaVenda (Produto produto){
        this.Total = getTotal() + produto.getValor();
    }
    
    public int excluirProduto (int codProd){
        
        if (this.listaProduto.isEmpty()){
            return 0;
        }
        
        for (int i=0; i<this.listaProduto.size();i++){
            
            if (this.listaProduto.get(i).getCodProd()==codProd){
                this.Total = getTotal() - this.listaProduto.get(i).getValor();
                this.listaProduto.remove(i);
                return 1;
            }
        }
        return 0;
    }
    
}
