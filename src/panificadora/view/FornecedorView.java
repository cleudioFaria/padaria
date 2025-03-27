package panificadora.view;

import java.io.IOException;
import java.util.Scanner;
import panificadora.controller.FornecedorController;

/**
 *
 * @author Grupo Pan
 */
public class FornecedorView {
    
    private FornecedorController controle;
    
    public FornecedorView() throws IOException{
        this.controle = new FornecedorController();
        this.menuFornecedor();
    }
    
    public void menuFornecedor () throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|             MENU FORNECEDORES               |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Fonecedor                     |");
            System.out.println("| 2 - Alterar Fornecedor                      |");
            System.out.println("| 3 - Excluir Fornecedor                      |");
            System.out.println("| 4 - Listagem de Fornecedor por CNPJ         |");
            System.out.println("| 5 - Listagem de Fornecedores cadastrados    |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                case 0:{
                    System.out.println("Saindo do Fornecedor!");
                    break;
                }
                case 1:{
                    this.cadastrarFornecedor();
                    break;
                }
                case 2:{
                    this.alterarFornecedor();
                    break;
                }
                case 3:{
                    this.excluirFornecedor();
                    break;
                }
                case 4:{
                    this.buscarFornecedor();
                    break;
                }
                case 5:{
                    this.todosFornecedores();
                    break;
                }
            }
            
        }while (op>0);
    }

    private void cadastrarFornecedor() {
        
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CNPJ="";
        String NomeContato="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              CADASTRAR FORNECEDOR              |");
        System.out.println("|------------------------------------------------|");
        
        do{
            if (Nome.equals("")){
                System.out.println("Digite o Nome: ");
                Nome = s.nextLine();
            }
            if (Telefone.equals("")){
                System.out.println("Digite o Telefone: ");
                Telefone = s.nextLine();
            }
            if (Endereco.equals("")){
                System.out.println("Digite o Endereço: ");
                Endereco = s.nextLine();
            }
            if (Numero==0){
                System.out.println("Digite o Número: ");
                Numero = Integer.parseInt(s.nextLine());
            }
            if (Bairro.equals("")){
                System.out.println("Digite o Bairro: ");
                Bairro = s.nextLine();
            }
            if (CEP.equals("")){
                System.out.println("Digite o CEP: ");
                CEP = s.nextLine();
            }
            if (Cidade.equals("")){
                System.out.println("Digite a Cidade: ");
                Cidade = s.nextLine();
            }
            if (UF.equals("")){
                System.out.println("Digite o Estado: ");
                UF = s.nextLine();
            }
            if (CNPJ.equals("")){
                System.out.println("Digite o CNPJ: ");
                CNPJ = s.nextLine();
            }
            if (NomeContato.equals("")){
                System.out.println("Digite o Nome de Contato do Fornecedor: ");
                NomeContato = s.nextLine();
            }
            try{

            controle.cadastrarFornecedor(Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CNPJ, NomeContato);
            
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("");
            }
        }while(( (Nome.equals("")) || (CNPJ.equals(""))|| (Telefone.equals(""))));
    }
    
    private void alterarFornecedor() {
        
        int Codigo=0;
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CNPJ="";
        String NomeContato="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               ALTERAR FORNECEDOR               |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o CNPJ do Fornecedor a ser Alterado: ");
        CNPJ = s.nextLine();
        
        this.controle.buscaFornecedor(CNPJ);
        
        if (this.controle.getFornecedor()==null){ //não encontrou o CNPJ
            System.out.println("CNPJ do Fornecedor não foi encontrado!");
        }
        else{ //encontrou o CNPJ
            
            int op=0;
            System.out.println("Fornecedor: "+this.controle.getFornecedor().getCNPJ()+"---"+this.controle.getFornecedor().getNome()+", Código: "+this.controle.getFornecedor().getCodigo());
            
            System.out.println("Deseja alterar esse fornecedor? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
                
            if (op==1){
                
                Codigo = this.controle.getFornecedor().getCodigo();
                
                do{
                    if (Nome.equals("")){
                        System.out.println("Digite o Nome: ");
                        Nome = s.nextLine();
                    } 
                    if (Telefone.equals("")){
                        System.out.println("Digite o Telefone: ");
                        Telefone = s.nextLine();
                    }   
                    if (Endereco.equals("")){
                        System.out.println("Digite o Endereço: ");
                        Endereco = s.nextLine();
                    }
                    if (Numero==0){
                        System.out.println("Digite o Número: ");
                        Numero = Integer.parseInt(s.nextLine());
                    }
                    if (Bairro.equals("")){
                        System.out.println("Digite o Bairro: ");
                        Bairro = s.nextLine();
                    }
                    if (CEP.equals("")){
                        System.out.println("Digite o CEP: ");
                        CEP = s.nextLine();
                    }
                    if (Cidade.equals("")){
                        System.out.println("Digite a Cidade: ");
                        Cidade = s.nextLine();
                    }
                    if (UF.equals("")){
                        System.out.println("Digite o Estado: ");
                        UF = s.nextLine();
                    }
                    if (CNPJ.equals("")){
                        System.out.println("Digite o CNPJ: ");
                        CNPJ = s.nextLine();
                    }
                    if (NomeContato.equals("")){
                        System.out.println("Digite o Nome de Contato do Fornecedor: ");
                        NomeContato = s.nextLine();
                    }
                    try{
                        this.controle.alterarFornecedor(Codigo, Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CNPJ, NomeContato);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    } 
                }while(( (Nome.equals("")) || (CNPJ.equals("")) ));
                System.out.println("Fornecedor alterado com Sucesso!");
            }
            
        }
        
    }

    private void excluirFornecedor() {
        
        int codigo=0;
        int verifica;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               EXCLUIR FORNECEDOR               |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Fornecedor a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        verifica=this.controle.excluirFornecedor(codigo);
        
        if (verifica==0){
            System.out.println("Não existe este Fornecedor no Cadastro!");
        }
        else{
            System.out.println("Fornecedor Excluido com Sucesso!");
        }
        
    }

    private void buscarFornecedor() {
        
        String CNPJ="";
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                BUSCAR FORNECEDOR                |");
        System.out.println("|-------------------------------------------------|");
        
        System.out.println("Digite o CNPJ do Fornecedor a ser Pesquisado: ");
        CNPJ = s.nextLine();
        
        this.controle.buscaFornecedor(CNPJ);
        
        if (this.controle.getFornecedor() == null){
            System.out.println("CNPJ do Fornecedor não foi encontrado!");
        }
        else{
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+this.controle.getFornecedor().getCodigo()+"---"+
                this.controle.getFornecedor().getNome()+"---"+
                this.controle.getFornecedor().getTelefone()+"---"+
                this.controle.getFornecedor().getEndereco()+"---"+
                this.controle.getFornecedor().getNumero()+"---"+
                this.controle.getFornecedor().getBairro()+"---"+
                this.controle.getFornecedor().getCep()+"---"+
                this.controle.getFornecedor().getCidade()+"---"+
                this.controle.getFornecedor().getUF()+"---"+
                this.controle.getFornecedor().getCNPJ()+"---"+
                this.controle.getFornecedor().getNomeContato()
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }

    private void todosFornecedores() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                LISTAR FORNECEDOR                |");
        System.out.println("|-------------------------------------------------|");
        
        this.controle.todosFornecedores();
        
        for (int i=0; i<this.controle.getListaFornecedor().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+
                    this.controle.getListaFornecedor().get(i).getCodigo()+"---"+
                    this.controle.getListaFornecedor().get(i).getNome()+"---"+
                    this.controle.getListaFornecedor().get(i).getCNPJ()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
        
    }
    
}
