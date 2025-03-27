/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panificadora.dao;

import java.util.ArrayList;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
import panificadora.model.CartaoVenda;

public class BancoDadosGeral {
    
    private static ArrayList<Fornecedor> tabelaFornecedor = null;
    private static ArrayList<Funcionario> tabelaFuncionario = null;
    private static ArrayList<Produto> tabelaProduto = null;
    private static ArrayList<CartaoVenda> tabelaCartao = null;
    
   
    
    private static int proximoCodigoFornecedor = 1; 
    private static int proximoCodigoFuncionario = 1;
    private static int proximoCodigoProduto = 1;
    private static int proximoCodigoCartao = 1;
    
    public static void carregaProximoCodigo(){
        int forn = 0;
        for(int i=0;i<BancoDadosGeral.getTabelaFornecedor().size();i++){
            forn=forn+1;
        }
        
        
       int func = 0;
       for(int j=0; j<BancoDadosGeral.getTabelaFuncionario().size();j++){
           func=func+1;
       }
       
       int prod = 0;
       for(int h=0; h<BancoDadosGeral.getTabelaProduto().size();h++){
           prod = prod+1;
       }
       
       int cart = 0;
       for(int k=0; k<BancoDadosGeral.getTabelaCartao().size();k++){
           cart = cart+1;
       }
       
       proximoCodigoFornecedor = forn+1;
       proximoCodigoFuncionario = func+1;
       proximoCodigoProduto = prod+1;
       proximoCodigoCartao  = cart+1;
       
    }
    
    public static int getProximocodigoFornecedor(){
        return proximoCodigoFornecedor;
    }
    
    public static void atualizaProximoCodigoFornecedor(){
        proximoCodigoFornecedor = proximoCodigoFornecedor + 1;
    }
    
    public static int getProximocodigoFuncionario(){
        return proximoCodigoFuncionario;
    }
    
     public static void atualizaProximoCodigoFuncionario(){
        proximoCodigoFuncionario = proximoCodigoFuncionario + 1;
    }
    
    public static int getProximocodigoProduto(){
        return proximoCodigoProduto;
    }
    
    public static void atualizaProximoCodigoProduto(){
        proximoCodigoProduto = proximoCodigoProduto + 1;
    }
    
    public static int getProximocodigoCartao(){
        return proximoCodigoCartao;
    }
    public static void atualizaProximoCodigoCartao(){
        proximoCodigoCartao = proximoCodigoCartao + 1;
    }
    
    
    public static ArrayList<Fornecedor> getTabelaFornecedor() {
        
        if ( tabelaFornecedor == null)
            tabelaFornecedor = new ArrayList<Fornecedor>();
        
        return tabelaFornecedor;
    }
    
    public static ArrayList<Funcionario> getTabelaFuncionario() {
        
        if ( tabelaFuncionario == null)
            tabelaFuncionario = new ArrayList<Funcionario>();
        
        return tabelaFuncionario;
    }
    public static ArrayList<Produto> getTabelaProduto() {
        
        if ( tabelaProduto == null)
            tabelaProduto = new ArrayList<Produto>();
        
        return tabelaProduto;
    }
    
    public static ArrayList<CartaoVenda> getTabelaCartao() {
        
        if ( tabelaCartao == null)
            tabelaCartao = new ArrayList<CartaoVenda>();
        
        return tabelaCartao;
    }
    
    
    public static void setTabelaFornecedor(ArrayList<Fornecedor> tabfor){
        tabelaFornecedor = tabfor;
    }
    
    public static void setTabelaFuncionario(ArrayList<Funcionario> tabfun){
        tabelaFuncionario = tabfun;
    }
    
    public static void setTabelaProduto(ArrayList<Produto> tabprod){
        tabelaProduto = tabprod;
    }
    
    public static void setTabelaCartao(ArrayList<CartaoVenda> tabcartao){
        tabelaCartao = tabcartao;
    }
    
}
