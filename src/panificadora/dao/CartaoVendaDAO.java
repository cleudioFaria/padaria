package panificadora.dao;

import java.util.ArrayList;
import panificadora.model.CartaoVenda;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaDAO implements BD {
    
    private ArrayList<CartaoVenda> tabelaCartaoVenda;
    
    public CartaoVendaDAO (){
        this.tabelaCartaoVenda = new ArrayList<CartaoVenda>();
    }
    
    @Override
    public void cadastrar (Object objeto){
        CartaoVenda c = ((CartaoVenda)objeto);
       
        c.setCodCartao(BancoDadosGeral.getProximocodigoCartao());
        
        BancoDadosGeral.getTabelaCartao().add(c);
        BancoDadosGeral.atualizaProximoCodigoCartao();
    }
    
    @Override
    public void alterar (Object objeto){
        CartaoVenda c = ((CartaoVenda)objeto);
        
        
        for(int i=0; i<BancoDadosGeral.getTabelaCartao().size();i++){
            
            CartaoVenda cart = BancoDadosGeral.getTabelaCartao().get(i);
            
            if (cart.getCodCartao()== c.getCodCartao()){
                BancoDadosGeral.getTabelaCartao().set(i, c);
                break;
            }
        }
    }
    
    @Override
    public int excluir (int codigo){
        
        if (BancoDadosGeral.getTabelaCartao().isEmpty()){
            return 0;
        }
        
        for (int i=0; i<BancoDadosGeral.getTabelaCartao().size();i++){
            CartaoVenda c = BancoDadosGeral.getTabelaCartao().get(i);
            
            if (c.getCodCartao()==codigo){
                BancoDadosGeral.getTabelaCartao().remove(i);
                return 1;
            }
        }
        return 0;
    }
    
    public CartaoVenda recuperaCartao (int codigo){
        
        for (int i=0; i<BancoDadosGeral.getTabelaCartao().size(); i++){
            CartaoVenda c = BancoDadosGeral.getTabelaCartao().get(i);
            
            if (c.getCodCartao()==codigo){
                return c;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Object> retornaTudo(){
        
         ArrayList<Object> lista = new ArrayList<Object>();
        
        for (Object cartao : BancoDadosGeral.getTabelaCartao()) {
            lista.add(cartao);
        }
        
        return lista;
    }
    
}
