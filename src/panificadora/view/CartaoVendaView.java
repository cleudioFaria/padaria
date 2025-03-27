package panificadora.view;

import java.io.IOException;
import java.util.Scanner;
import panificadora.controller.CartaoVendaController;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaView {
    
    private CartaoVendaController controle;
    
    public CartaoVendaView() throws IOException{
        this.controle = new CartaoVendaController();
        this.menuCartao();
    }

    private void menuCartao() throws IOException {
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU CARTAO                  |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Cartao                        |");
            System.out.println("| 2 - Inserir Produto no Cartao               |");
            System.out.println("| 3 - Excluir Produto no Cartao               |");
            System.out.println("| 4 - Excluir Cartao                          |");
            System.out.println("| 5 - Listagem de Cartao por Codigo           |");
            System.out.println("| 6 - Listagem de Cartoes Cadastrados         |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                case 0:{
                    System.out.println("Saindo do Cartao!");
                    break;
                }
                case 1:{
                    this.cadastrarCartao();
                    break;
                }
                case 2:{
                    this.adicionaProdCartao();
                    break;
                }
                case 3:{
                    this.excluiProdCartao();
                    break;
                }
                case 4:{
                    this.excluirCartao();
                    break;
                }
                case 5:{
                    this.buscaCartao();
                    break;
                }
                case 6:{
                    this.todosCartoes();
                    break;
                }
            }
        
        }while (op>0);
    
    }

    private void cadastrarCartao() {
        
        int CodCartao=0;
        int CodProduto=0;
        int CodFuncionario=0;
        int verifica=0;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               CADASTRAR CARTAO                 |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Cartão: ");
        CodCartao = Integer.parseInt(s.nextLine());
        
        System.out.println("Digite o Código do Produto a ser Inserido no Cartão: ");
        CodProduto = Integer.parseInt(s.nextLine());
        
        System.out.println("Digite o Código do Funcionário: ");
        CodFuncionario = Integer.parseInt(s.nextLine());
        
        try{
            verifica=this.controle.cadastrarCartao(CodCartao, CodProduto, CodFuncionario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("");
        }
        if (verifica==1){
            System.out.println("Cartão Cadastrado com Sucesso!");
        }
        
    }

    private void adicionaProdCartao() {
     
        int CodCartao=0;
        int CodProduto=0;
        int verifica=0;
        int op=0;
        
        Scanner s = new Scanner(System.in);
        
        do{
            
            System.out.println("|------------------------------------------------|");
            System.out.println("|           ADICIONA PRODUTO CARTAO              |");
            System.out.println("|------------------------------------------------|");

            System.out.println("Digite o Código do Cartão: ");
            CodCartao = Integer.parseInt(s.nextLine());

            System.out.println("Digite o Código do Produto a ser Inserido no Cartão: ");
            CodProduto = Integer.parseInt(s.nextLine());
            
            
            verifica=this.controle.adicionaProdCartao(CodCartao, CodProduto);

            if(verifica==0){
                System.out.println("Produto a ser Adicionado Não Encontrado!");
            }
            else{
                System.out.println("Produto Adicionado no Cartão com Sucesso!");
            }
            
            System.out.println("Deseja Adicionar outro Produto no Cartão: 0-Não | 1-Sim");
            op = Integer.parseInt(s.nextLine());
            
        }while(op==1);
        
    }

    private void excluiProdCartao() {
        
        int CodCartao=0;
        int CodProduto=0;
        int verifica=0;
        int op=0;
        
        Scanner s = new Scanner(System.in);
        
        do{
            
            System.out.println("|------------------------------------------------|");
            System.out.println("|           EXCLUIR PRODUTO CARTAO               |");
            System.out.println("|------------------------------------------------|");

            System.out.println("Digite o Código do Cartão: ");
            CodCartao = Integer.parseInt(s.nextLine());

            System.out.println("Digite o Código do Produto a ser Excluido no Cartão: ");
            CodProduto = Integer.parseInt(s.nextLine());

            verifica=this.controle.adicionaProdCartao(CodCartao, CodProduto);

            if(verifica==0){
                System.out.println("Produto a ser Excluido Não Encontrado!");
            }
            else{
                System.out.println("Produto Excluido no Cartão com Sucesso!");
            }
            
            System.out.println("Deseja Excluir outro Produto no Cartão: 0-Não | 1-Sim");
            op = Integer.parseInt(s.nextLine());
            
        }while(op==1);
        
    }

    private void excluirCartao() {
        
        int codCartao=0;
        int verifica=0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                EXCLUIR CARTAO                  |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Cartão a ser Excluido: ");
        codCartao = Integer.parseInt(s.nextLine());
        
        verifica=this.controle.excluirCartao(codCartao);
        
        if (verifica==0){
            System.out.println("Não existe este Cartão no Cadastro!");
        }
        else{
            System.out.println("Cartão Excluido com Sucesso!");
        }
        
    }

    private void buscaCartao() {
        
        int codCartao=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 BUSCAR CARTAO                   |");
        System.out.println("|-------------------------------------------------|");
        
        System.out.println("Digite o Código do Cartão a ser Pesquisado: ");
        codCartao=Integer.parseInt(s.nextLine());
        
        this.controle.buscaCartao(codCartao);
        
        if (this.controle.getCartao()== null){
            System.out.println("Código do Cartão não foi encontrado!");
        }
        else{
            System.out.println("|-------------------------------------------------|");
            System.out.println("Cartão: "+this.controle.getCartao().getCodCartao());
            System.out.println("Produtos: ");
            System.out.println("-------");
            for(int i=0; i<this.controle.getCartao().getProduto().size(); i++){
                System.out.println("Código: "+this.controle.getCartao().getProduto().get(i).getCodProd());
                System.out.println("Descrição: "+this.controle.getCartao().getProduto().get(i).getDescricao());
                System.out.println("Tipo: "+this.controle.getCartao().getProduto().get(i).getTipo());
                System.out.println("Valor: "+this.controle.getCartao().getProduto().get(i).getValor());
                System.out.println("-------");
            }
            System.out.println("Funcionario cód: "+this.controle.getCartao().getFuncionario());
            System.out.println("VALOR TOTAL: "+this.controle.getCartao().getTotal());
            System.out.println("|-------------------------------------------------|");
        }
        
    }

    private void todosCartoes() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 LISTAR CARTÕES                  |");
        System.out.println("|-------------------------------------------------|");
        
        this.controle.todosCartoes();
        
        if (this.controle.getListaCartao()==null){
            System.out.println("A Lista de Cartões está Vazia!");
        }
        else{
            for (int i=0; i<this.controle.getListaCartao().size();i++){
                System.out.println("|-------------------------------------------------|");
                System.out.println("Cartão: "+this.controle.getListaCartao().get(i).getCodCartao());
                System.out.println("Produtos: ");
                System.out.println("-------");
                for(int j=0; j<this.controle.getListaCartao().get(i).getProduto().size(); j++){
                    System.out.println("Código: "+this.controle.getListaCartao().get(i).getProduto().get(j).getCodProd());
                    System.out.println("Descrição: "+this.controle.getListaCartao().get(i).getProduto().get(j).getDescricao());
                    System.out.println("Tipo: "+this.controle.getListaCartao().get(i).getProduto().get(j).getTipo());
                    System.out.println("Valor: "+this.controle.getListaCartao().get(i).getProduto().get(j).getValor());
                    System.out.println("-------");
                }
                System.out.println("Funcionario cód: "+this.controle.getListaCartao().get(i).getFuncionario());
                System.out.println("VALOR TOTAL: "+this.controle.getListaCartao().get(i).getTotal());
                System.out.println("|-------------------------------------------------|");
            }
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|            TECLE ENTER PARA CONTINUAR           |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}
