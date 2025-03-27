package panificadora.controller;

import java.util.ArrayList;
import panificadora.dao.FornecedorDAO;
import panificadora.model.Fornecedor;

/**
 *
 * @author Grupo Pan
 */
public class FornecedorController {
    
    private Fornecedor fornecedor;
    private FornecedorDAO bd;
    private ArrayList<Fornecedor> listaFornecedor;
    
    // metodo contrutor padão
    public FornecedorController(){
        this.fornecedor = new Fornecedor();
        this.bd = new FornecedorDAO();
    }
    
    public Fornecedor getFornecedor(){
        return this.fornecedor;
    }
    
    public ArrayList<Fornecedor> getListaFornecedor(){
        return this.listaFornecedor;
    }
    
    //metodo que vai salvar um novo fornecedor no banco de dados
    public void cadastrarFornecedor (String nome, String telefone, String endereco, 
            int numero, String bairro, String CEP, String cidade,String UF, 
            String CNPJ, String nomeContato)throws Exception{
        
        Fornecedor forn = new Fornecedor();
        
        forn.setCodigo(1);
        forn.setNome(nome);
        forn.setTelefone(telefone);
        forn.setEndereco(endereco);
        forn.setNumero(numero);
        forn.setBairro(bairro);
        forn.setCep(CEP);
        forn.setCidade(cidade);
        forn.setUF(UF);
        forn.setCNPJ(CNPJ);
        forn.setNomeContato(nomeContato);
        
        this.bd.cadastrar(forn);
        
    }
    
    public void alterarFornecedor (int codigo, String nome, String telefone, String endereco, 
            int numero, String bairro, String CEP, String cidade,String UF, 
            String CNPJ, String nomeContato)throws Exception{
        
        Fornecedor forn = new Fornecedor();
        
        forn.setCodigo(codigo);
        forn.setNome(nome);
        forn.setTelefone(telefone);
        forn.setEndereco(endereco);
        forn.setNumero(numero);
        forn.setBairro(bairro);
        forn.setCep(CEP);
        forn.setCidade(cidade);
        forn.setUF(UF);
        forn.setCNPJ(CNPJ);
        forn.setNomeContato(nomeContato);
        
        this.bd.alterar(forn);
    }
    
    public int excluirFornecedor (int codigo){
        
        return this.bd.excluir(codigo);
        
    }
    
    public void buscaFornecedor (String CNPJ){
        
        this.fornecedor = this.bd.recuperaCNPJ(CNPJ);
        
    }
    
     
    
    public void todosFornecedores (){
        ArrayList<Object> retorno = this.bd.retornaTudo();
        
        this.listaFornecedor = new ArrayList<Fornecedor>();
        
        for (Object o : retorno){
            
            Fornecedor f = ((Fornecedor)o);
            
            this.listaFornecedor.add(f);
            
        }
    }
    
}
