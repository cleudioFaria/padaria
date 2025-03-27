package panificadora.controller;

import java.util.ArrayList;
import panificadora.dao.ProdutoDAO;
import panificadora.dao.FornecedorDAO;
import panificadora.dao.FuncionarioDAO;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
/**
 *
 * @author Grupo Pan
 */
public class ProdutoController {
    
    
    private Produto produto;
    private ProdutoDAO bd;
    private FornecedorDAO bdFor;
    private FuncionarioDAO bdFunc;
    private ArrayList<Produto> listaProduto;
    
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    
    public ProdutoController(){
        
        this.produto = new Produto();
        this.bd = new ProdutoDAO();
        this.bdFor = new FornecedorDAO();
        this.bdFunc = new FuncionarioDAO();
        
    }

    public Produto getProduto() {
        return this.produto;
    }

    public ArrayList<Produto> getListaProduto() {
        return this.listaProduto;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void cadastrarProduto (String Descricao, double Valor, 
            String Tipo, int fornecedor, int funcionario)throws Exception{
        
        Produto prod = new Produto();
        
        prod.setCodProd(1);
        prod.setDescricao(Descricao);
        prod.setValor(Valor);
        prod.setTipo(Tipo);
        prod.setFornecedor(fornecedor);
        prod.setFuncionario(funcionario);
        
        this.bd.cadastrar(prod);
        
    }
    
    public void buscaNomes (int CodProd){
        this.produto=this.bd.recuperaProduto(CodProd);
        this.fornecedor=this.bdFor.recuperaCodigo(produto.getFornecedor().getCodigo());
        this.funcionario=this.bdFunc.recuperaCodigo(produto.getFornecedor().getCodigo());
    }
    
    public void alterarProduto (int CodProd, String Descricao, double Valor, 
            String Tipo, int fornecedor, int funcionario)throws Exception{
        
        Produto prod = new Produto();
        
        prod.setCodProd(CodProd);
        prod.setDescricao(Descricao);
        prod.setValor(Valor);
        prod.setTipo(Tipo);
        prod.setFornecedor(fornecedor);
        prod.setFuncionario(funcionario);
        
        this.bd.alterar(prod);
        
    }
    
    public void retornaFornecedor(int CodProd){
        this.produto = this.bd.recuperaProduto(CodProd);
        this.produto.getFornecedor();
    }
    
    public int excluirProduto (int codigo){
        
        return this.bd.excluir(codigo);
        
    }
    
    public void buscaProduto (int CodProd){
        
        this.produto = this.bd.recuperaProduto(CodProd);
        
    }
    
    public void todosProdutos (){
        
        ArrayList<Object> retorno = this.bd.retornaTudo();
        this.listaProduto = new ArrayList<Produto>();
        
        for (Object o : retorno){
            
            Produto p = ((Produto)o);
            
            this.listaProduto.add(p);
            
        }
        
    }
    
}
