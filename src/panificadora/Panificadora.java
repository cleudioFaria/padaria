package panificadora;

import java.io.IOException;
import java.util.Scanner;
import panificadora.view.CartaoVendaView;
import panificadora.view.FornecedorView;
import panificadora.view.FuncionarioView;
import panificadora.view.ProdutoView;
import java.util.ArrayList;
import panificadora.dao.BancoDadosGeral;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
import panificadora.uteis.ManipulaBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author NoteC
 */
public class Panificadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        recuperaTabelas();
        BancoDadosGeral.carregaProximoCodigo();
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|----------------------------------------------|");
            System.out.println("|          PANIFICADORA FARINHA D'BOA          |");
            System.out.println("|----------------------------------------------|");
            System.out.println("|                                              |");
            System.out.println("| 0 - Sair                                     |");
            System.out.println("| 1 - Menu Cartão                              |");
            System.out.println("| 2 - Menu Fonecedor                           |");
            System.out.println("| 3 - Menu Funcionario                         |");
            System.out.println("| 4 - Menu Produto                             |");
            System.out.println("|                                              |");
            System.out.println("|----------------------------------------------|");
            System.out.println(" Selection sua opção:");           

            op = Integer.parseInt(s.nextLine());

            switch(op){
                case 0:{
                    System.out.println("Deseja realmente sair? 0 - Sim | 1 - Não");
                    op = Integer.parseInt( s.nextLine() );
                    
                    if ( op == 0){
                        //salvar as tabelas em arquivos no disco
                        salvarTabelas();
                    }
                    break;
                }
                case 1:{
                    CartaoVendaView cav = new CartaoVendaView();
                    break;
                }
                case 2:{
                    FornecedorView fov = new FornecedorView();
                    break;
                }
                case 3:{
                    FuncionarioView fuv = new FuncionarioView();
                    break;
                }
                case 4:{
                    ProdutoView prv = new ProdutoView();
                    break;
                }
            }
            
        }while ( op != 0);
    }
    
    private static void salvarTabelas(){
        
        
        
        // converter ArrayList<Fornecedor> em um ArrayList<Object> (generico)
        ArrayList<Object> tabelaFornecedor = new ArrayList();
        for (Object fornecedor : BancoDadosGeral.getTabelaFornecedor()) {
            tabelaFornecedor.add(fornecedor);
        }
        
        //Convertendo ArrayList<Funcionario> em um ArrayList<Object> (generico)
        ArrayList<Object> tabelaFuncionario = new ArrayList();
        for (Object objFunc : BancoDadosGeral.getTabelaFuncionario()) {
            tabelaFuncionario.add(objFunc);
        }
        
        //Converter Tabela ArrayList<Produtos> em uma tabela ArrayList<Objet> (generico)
        ArrayList<Object> tabelaProduto = new ArrayList();
        for ( Object objProd : BancoDadosGeral.getTabelaProduto()){
            tabelaProduto.add(objProd);
        }
        
        try {
            
            // salvando o objeto tabelaFornecedor com os dados do fornecedor dentro do arquivo fornecedor.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaFornecedor, "D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\fornecedor.dat");
            
            // salvando o objeto tabelaFuncionario com os dados do Funcionario dentro do arquivo funcionario.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaFuncionario, "D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\funcionario.dat");
        
            ManipulaBD.gravaTabelasEmArquivos(tabelaProduto, "D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\produto.dat");
            
           
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERRO: " + ex.getMessage());
        }
        
    }
    
    
    
    private static void recuperaTabelas(){
        
        System.out.println(" ------------------------------------------");
        System.out.println("|                                          |");        
        System.out.println("|      CONECTANDO AO BANCO DE DADOS...     |");
        System.out.println("|                                          |");
        System.out.println(" ------------------------------------------");
        
        try{
            
            // recuperando a tabela fornecedor armazenada em arquivo no disco----------------------------------------------
            ArrayList tabela = ManipulaBD.recuperaTabelaEmArquivo("D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\fornecedor.dat");
            
            if ( tabela != null ){
                
                // converter a tabela recuperada (ArrayList<Object>) em um ArrayList<Fornecedor>
                ArrayList<Fornecedor> tabFornecedor = new ArrayList();
                for (Object obj : tabela) {                    
                    Fornecedor f = (Fornecedor)obj;                    
                    tabFornecedor.add(f);
                }

                //Definir a tabela fornecedor no meu banco de dados
                BancoDadosGeral.setTabelaFornecedor(tabFornecedor);
                
               
            }
            
            // recuperando a tabela Funcionario armazenada em arquivo no disco----------------------------------------------
            ArrayList<Object> tabFunc = ManipulaBD.recuperaTabelaEmArquivo("D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\funcionario.dat");
            
            if ( tabFunc != null){
                
                // converter ArrayList<Object> (Generico) em um ArrayList<Cliente>
                ArrayList<Funcionario> tabFuncionario = new ArrayList();
                
                for (Object funcionario : tabFunc) {
                    Funcionario f = (Funcionario)funcionario;
                    tabFuncionario.add(f);
                }
                
                BancoDadosGeral.setTabelaFuncionario(tabFuncionario);
                
            }
            
            // recuperando a tabela Produto armazenada em arquivo no disco----------------------------------------------
            ArrayList<Object> tabProd = ManipulaBD.recuperaTabelaEmArquivo("D:\\BKP\\Documentos\\Unifae\\Segundo Ano\\Semestre II\\Programação Orientada a Objetos II\\PanificadoraUltimo\\Panificadora\\data\\produto.dat");
            
            if (tabProd != null ){
                
                ArrayList<Produto> tabProduto = new ArrayList();

                for( Object produto : tabProd){
                    Produto p = (Produto)produto;
                    tabProduto.add(p);
                }
                
                BancoDadosGeral.setTabelaProduto(tabProduto);
            }
            
            
            
        }catch(IOException | ClassNotFoundException erro){
            
            System.out.println(" *******************************************");
            System.out.println("|                                            |");        
            System.out.println("|   ERRO AO CONECTAR NO BANCO DE DADOS       |");
            System.out.println("|                                            |");
            System.out.println(" ********************************************");
            System.out.println("ERRO: "+erro.getMessage());
            
        }
        
        
    }
}
