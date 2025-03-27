package panificadora.dao;

import java.util.ArrayList;

/**
 *
 * @author Grupo Pan
 */
public interface BD {
    
    public abstract void cadastrar (Object objeto);
    
    public abstract void alterar (Object objeto);
    
    public abstract int excluir (int codigo);
    
    //public abstract void consultar ();
    
    public abstract ArrayList<Object> retornaTudo();
    
}
