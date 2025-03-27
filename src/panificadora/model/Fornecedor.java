package panificadora.model;

import java.io.Serializable;

/**
 *
 * @author Grupo Pan
 */
public class Fornecedor extends Pessoa implements Serializable{
    
    private String CNPJ;
    private String NomeContato;
    
    public Fornecedor (){
        
        super();
        this.CNPJ="";
        this.NomeContato="";
        
    }

    public String getCNPJ() {
        return this.CNPJ;
    }
    public void setCNPJ(String CNPJ)throws Exception {
         if (CNPJ.equals(""))
            throw new Exception("O CNPJ não foi informado! Digite o CNPJ.");
        this.CNPJ = CNPJ;
    }

    public String getNomeContato() {
        return this.NomeContato;
    }
    public void setNomeContato(String NomeContato) {
        this.NomeContato = NomeContato;
    }
    
}
