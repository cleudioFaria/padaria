package panificadora.dao;

import java.util.ArrayList;
import panificadora.model.Funcionario;

/**
 *
 * @author Grupo Pan
 */
public class FuncionarioDAO implements BD {
    
    private ArrayList<Funcionario> tabelaFuncionario;
    
    public FuncionarioDAO (){
        this.tabelaFuncionario = new ArrayList<Funcionario>();
    }
    
    @Override
    public void cadastrar (Object objeto){
        Funcionario f = ((Funcionario)objeto);
 
        f.setCodigo(BancoDadosGeral.getProximocodigoFuncionario());
        BancoDadosGeral.getTabelaFuncionario().add(f);
        BancoDadosGeral.atualizaProximoCodigoFuncionario();
    }
    
    @Override
    public void alterar (Object objeto){
        Funcionario f = ((Funcionario)objeto);
        
        for(int i=0; i<BancoDadosGeral.getTabelaFuncionario().size();i++){
            
            Funcionario forn = BancoDadosGeral.getTabelaFuncionario().get(i);
            
            if (forn.getCodigo() == f.getCodigo()){
                BancoDadosGeral.getTabelaFuncionario().set(i, f);
                break;
            }
        }
    }
    
    @Override
    public int excluir(int codigo){
        
        if (BancoDadosGeral.getTabelaFuncionario().isEmpty()){
            return 0;
        }
        
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size();i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            
            if (f.getCodigo()==codigo){
                BancoDadosGeral.getTabelaFuncionario().remove(i);
                return 1;
            }
        }
        return 0;
    }
    
    public Funcionario recuperaCPF (String cpf){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size(); i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            
            if (f.getCPF().equals(cpf)){
                return f;
            }
        }
        return null;
    }
    
    public Funcionario recuperaCodigo (int codigo){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size(); i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            
            if (f.getCodigo()==codigo){
                return f;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Object> retornaTudo (){
        
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (Funcionario f : BancoDadosGeral.getTabelaFuncionario()){
            lista.add(f);
        }
        
        return lista;
        
    }
}
