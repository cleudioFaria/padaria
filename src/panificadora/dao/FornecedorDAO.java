package panificadora.dao;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import panificadora.model.Fornecedor;

/**
 *
 * @author Grupo Pan
 */
public class FornecedorDAO implements BD {
    
    private ArrayList <Fornecedor> tabelaFornecedor;
    private int proximoCodigo;
    
    public FornecedorDAO (){
        this.tabelaFornecedor = new ArrayList <Fornecedor>();
        this.proximoCodigo = 1;
    }
    
    @Override
    public void cadastrar (Object objeto){
        Fornecedor f = ((Fornecedor)objeto);
        
        
        f.setCodigo(BancoDadosGeral.getProximocodigoFornecedor());
        
        BancoDadosGeral.getTabelaFornecedor().add(f);
        BancoDadosGeral.atualizaProximoCodigoFornecedor();
    }
    
    @Override
    public void alterar (Object objeto){
        Fornecedor f = ((Fornecedor)objeto);
        
        for(int i=0; i<BancoDadosGeral.getTabelaFornecedor().size();i++){
            
            Fornecedor forn = BancoDadosGeral.getTabelaFornecedor().get(i);
            
            if (forn.getCodigo() == f.getCodigo()){
                BancoDadosGeral.getTabelaFornecedor().set(i, f);
                break;
            }
        }
    }
    
    @Override
    public int excluir (int codigo){
        
        if (BancoDadosGeral.getTabelaFornecedor().isEmpty()){
            return 0;
        }
        
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size();i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            
            if (f.getCodigo()==codigo){
                BancoDadosGeral.getTabelaFornecedor().remove(i);
                return 1;
            }
        }
        return 0;
    }
    
    public Fornecedor recuperaCNPJ (String cnpj){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size(); i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            
            if (f.getCNPJ().equals(cnpj)){
                return f;
            }
        }
        return null;
    }
    
     public Fornecedor recuperaCodigo (int codigo){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size(); i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            
            if (f.getCodigo()==codigo){
                return f;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Object> retornaTudo(){
        
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (Object fornecedor : BancoDadosGeral.getTabelaFornecedor()) {
            lista.add(fornecedor);
        }
        
        return lista;
    }
    
}
