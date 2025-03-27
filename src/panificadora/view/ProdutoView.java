package panificadora.view;

import java.io.IOException;
import java.util.Scanner;
import panificadora.controller.ProdutoController;
import panificadora.controller.FornecedorController;
/**
 *
 * @author Grupo Pan
 */
public class ProdutoView {
    
    private ProdutoController controle;
    private FornecedorController controleFornecedor;
    
    public ProdutoView() throws IOException{
        this.controle = new ProdutoController();
        this.menuProduto();
    }
    
    public void menuProduto () throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU PRODUTO                 |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Produto                       |");
            System.out.println("| 2 - Alterar Produto                         |");
            System.out.println("| 3 - Excluir Produto                         |");
            System.out.println("| 4 - Listagem de Produto por Codigo          |");
            System.out.println("| 5 - Listagem de Produtos cadastrados        |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                case 0:{
                    System.out.println("Saindo do Produto!");
                    break;
                }
                case 1:{
                    this.cadastrarProduto();
                    break;
                }
                case 2:{
                    this.alterarProduto();
                    break;
                }
                case 3:{
                    this.excluirProduto();
                    break;
                }
                case 4:{
                    this.buscarProduto();
                    break;
                }
                case 5:{
                    this.todosProdutos();
                    break;
                }
            }
            
        }while (op>0);
        
    }

    private void cadastrarProduto() {
        
        String Descricao="";
        double Valor=0.0;
        String Tipo="";
        int CodForn=0;
        int CodFun=0;
                
        Scanner s = new Scanner (System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               CADASTRAR PRODUTO                |");
        System.out.println("|------------------------------------------------|");
        
        do{
            if(Descricao.equals("")){
                System.out.println("Digite a Descrição do Produto: ");
                Descricao=s.nextLine();
            }
            if(Valor==0){
                System.out.println("Digite o Valor do Produto: ");
                Valor=Double.parseDouble(s.nextLine());
            }
            if(Tipo.equals("")){
                System.out.println("Digite o Tipo do Produto: ");
                Tipo=s.nextLine();
            }
            if(CodForn==0){
                System.out.println("Digite o Código do Fornecedor: ");
                CodForn=Integer.parseInt(s.nextLine());
            }
            if(CodFun==0){
                System.out.println("Digite o Código do Funcionário: ");
                CodFun=Integer.parseInt(s.nextLine());
            }
            try{
                this.controle.cadastrarProduto(Descricao, Valor, Tipo, CodForn, CodFun);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("");
            }
        }while((Descricao.equals("")) || (Valor==0) || (CodForn==0) || (CodFun==0) || (Tipo.equals("")));
    }
    
    private void alterarProduto() {
        
        int Codigo=0;
        String Descricao="";
        double Valor=0.0;
        String Tipo="";
        int CodForn=0;
        int CodFun=0;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                ALTERAR PRODUTO                 |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Produto a ser Alterado: ");
        Codigo = Integer.parseInt(s.nextLine());
        
        this.controle.buscaProduto(Codigo);
        
        if (this.controle.getProduto()==null){ //não encontrou o Codigo do Produro
            System.out.println("Código do Produto não foi encontrado!");
        }
        else{ //encontrou o Codigo do Produto
            
            int op=0;
            System.out.println("Produto: "+this.controle.getProduto().getDescricao()+", Código: "+this.controle.getProduto().getCodProd());
            
            System.out.println("Deseja alterar esse produto? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
            
            if (op==1){
                
                do{
                    if(Descricao.equals("")){
                        System.out.println("Digite a Descrição do Produto: ");
                        Descricao=s.nextLine();
                    }
                    if(Valor==0){
                        System.out.println("Digite o Valor do Produto: ");
                        Valor=Double.parseDouble(s.nextLine());
                    }
                    if(Tipo.equals("")){
                        System.out.println("Digite o Tipo do Produto: ");
                        Tipo=s.nextLine();
                    }
                    if(CodForn==0){
                        System.out.println("Digite o Código do Fornecedor: ");
                        CodForn=Integer.parseInt(s.nextLine());
                    }
                    if(CodFun==0){
                        System.out.println("Digite o Código do Funcionário: ");
                        CodFun=Integer.parseInt(s.nextLine());
                    }
                    try{
                        this.controle.cadastrarProduto(Descricao, Valor, Tipo, CodForn, CodFun);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    }
                }while((!Descricao.equals("")) || (Valor==0) || (CodForn==0) || (CodFun==0) || (Tipo.equals("")));
            
            }
            System.out.println("Produto alterado com Sucesso!");
        }
        
    }

    private void excluirProduto() {
        
        int codigo=0;
        int verifica=0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                EXCLUIR PRODUTO                 |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Produto a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        verifica=this.controle.excluirProduto(codigo);
        
        if (verifica==0){
            System.out.println("Não existe este Produto no Cadastro!");
        }
        else{
            System.out.println("Produto Excluido com Sucesso!");
        }
        
    }

    private void buscarProduto() {
        
        int codigo=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 BUSCAR PRODUTO                  |");
        System.out.println("|-------------------------------------------------|");
        
        System.out.println("Digite o Código do Produto a ser Pesquisado: ");
        codigo=Integer.parseInt(s.nextLine());
        
        
        this.controle.buscaNomes(codigo);
        this.controle.buscaProduto(codigo);
        
        if (this.controle.getProduto()== null){
            System.out.println("Código do Produto não foi encontrado!");
        }
        else{
            System.out.println("|-------------------------------------------------|");
            System.out.println("Produto: "+this.controle.getProduto().getCodProd()+"---"+
                this.controle.getProduto().getDescricao()+"---"+
                this.controle.getProduto().getValor()+"---"+
                this.controle.getProduto().getTipo()+"---"+
                this.controle.getFornecedor().getNome()+"---"+
                this.controle.getFuncionario().getNome()
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }

    private void todosProdutos() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 LISTAR PRODUTO                  |");
        System.out.println("|-------------------------------------------------|");
        
        this.controle.todosProdutos();
        
        for (int i=0; i<this.controle.getListaProduto().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Produto: "+
                    this.controle.getListaProduto().get(i).getCodProd()+"---"+
                    this.controle.getListaProduto().get(i).getDescricao()+"---"+
                    this.controle.getListaProduto().get(i).getValor()+"---"+
                    this.controle.getListaProduto().get(i).getTipo()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}
