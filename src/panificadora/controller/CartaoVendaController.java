package panificadora.controller;

import java.util.ArrayList;
import panificadora.dao.CartaoVendaDAO;
import panificadora.dao.ProdutoDAO;
import panificadora.model.CartaoVenda;
import panificadora.model.Produto;
//import panificadora.model.Produto;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaController {
    
    private CartaoVenda cartao;
    private ArrayList<CartaoVenda> listaCartao;
    private CartaoVendaDAO bd;
    //private Produto produto;
    private ProdutoDAO bdp;
    
    public CartaoVendaController(){
        this.cartao = new CartaoVenda();
        this.bd = new CartaoVendaDAO();
        this.bdp = new ProdutoDAO();
    }

    public CartaoVenda getCartao() {
        return cartao;
    }

    public ArrayList<CartaoVenda> getListaCartao() {
        return listaCartao;
    }
    
    public int cadastrarCartao (int codCartao, int codProd, int codFun){
        
        Produto verifica=null;
        CartaoVenda car = new CartaoVenda();
        
        car.setCodCartao(codCartao);
        car.setFuncionario(codFun);
        
        verifica=bdp.recuperaProduto(codProd);
        
        if (verifica==null){
            return 0;
        }
        else{
            car.setProduto(verifica);
            car.CalculaVenda(verifica);
            this.bd.cadastrar(car);
            return 1;
        }
        
    }
    
    public int adicionaProdCartao (int codCartao, int codProd){
        
        Produto verifica=null;
        CartaoVenda car = new CartaoVenda();
        
        car=bd.recuperaCartao(codCartao);
        verifica=bdp.recuperaProduto(codProd);
        
        if (verifica==null){
            return 0;
        }
        else{
            car.setProduto(verifica);
            car.CalculaVenda(verifica);
            bd.alterar(car);
            return 1;
        }
        
    }
    
    public int excluiProdCartao (int codCartao, int codProd){
        
        int verifica=0;
        CartaoVenda car = new CartaoVenda();
        
        car=bd.recuperaCartao(codCartao);
        verifica=car.excluirProduto(codProd);
        
        if (verifica==1){
            bd.alterar(car);
        }
        
        return verifica;
        
    }
    
    public int excluirCartao (int codCartao){
        
        return this.bd.excluir(codCartao);
        
    }
    
    public void buscaCartao (int CodCartao){
        
        this.cartao = this.bd.recuperaCartao(CodCartao);
        
    }
    
    public void todosCartoes (){
        
        this.listaCartao = new ArrayList<CartaoVenda>();
        
        for (Object o : this.bd.retornaTudo()){
            
            CartaoVenda c = ((CartaoVenda)o);
            
            this.listaCartao.add(c);
            
        }
        
    }
    
}
