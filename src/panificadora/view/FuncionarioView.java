package panificadora.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import panificadora.controller.FuncionarioController;
import java.util.Date;
/**
 *
 * @author Grupo Pan
 */
public class FuncionarioView {
    
    private FuncionarioController controle;
    
    public FuncionarioView() throws IOException{
        this.controle = new FuncionarioController();
        this.menuFuncionario();
    }
    
    public void menuFuncionario() throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|             MENU FUNCIONARIOS               |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Funcionario                   |");
            System.out.println("| 2 - Alterar Funcionario                     |");
            System.out.println("| 3 - Excluir Funcionario                     |");
            System.out.println("| 4 - Listagem de Funcionario por CPF         |");
            System.out.println("| 5 - Listagem de Funcionarios cadastrados    |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                case 0:{
                    System.out.println("Saindo do Funcionario!");
                    break;
                }
                case 1:{
                    this.cadastrarFuncionario();
                    break;
                }
                case 2:{
                    this.alterarFuncionario();
                    break;
                }
                case 3:{
                    this.excluirFuncionario();
                    break;
                }
                case 4:{
                    this.buscarFuncionario();
                    break;
                }
                case 5:{
                    this.todosFuncionario();
                    break;
                }
            }
            
        }while (op>0);
    }
    
    public void cadastrarFuncionario(){
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
        
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CPF="";
        String RG="";
        String dataNascimento="";
        String Cargo="";
        double Salario=0.0;
        String Admissao="";
        String Demissao="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              CADASTRAR FUNCIONARIO             |");
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
            if (CPF.equals("")){
                System.out.println("Digite o CEP: ");
                CEP = s.nextLine();
            }
            if(Cidade.equals("")){
                System.out.println("Digite a Cidade: ");
                Cidade = s.nextLine();
            }
            if (UF.equals("")){
                System.out.println("Digite o Estado: ");
                UF = s.nextLine();
            }
            if (CPF.equals("")){
                System.out.println("Digite o cpf: ");
                CPF = s.nextLine();
            }
            if (RG.equals("")){
                System.out.println("Digite o RG: ");
                RG = s.nextLine();
            }
            if (dataNascimento.equals("")){
                System.out.println("Digite o Data de Nascimento: ");
                dataNascimento = s.nextLine();
            }
            if (Cargo.equals("")){
                System.out.println("Digite o Cargo: ");
                Cargo = s.nextLine();
            }
            if (Salario==0){
                System.out.println("Digite o Salario: ");
                Salario = Double.parseDouble(s.nextLine());
            }
            if (Admissao.equals("")){
                System.out.println("Digite o Data de Admissão: ");
                Admissao = s.nextLine();
            }

            try{
                this.controle.cadastrarFuncionario(Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CPF, RG, dataNascimento, Cargo, Salario, Admissao);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("");
            }
        }while(( (Nome.equals("")) || (CPF.equals("")) || (RG.equals("")) || (dataNascimento.equals("")) ));
    }

    private void alterarFuncionario() {
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
        
        int Codigo=0;
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CPF="";
        String RG="";
        String dataNascimento="";
        String Cargo="";
        double Salario=0.0;
        String Admissao="";
        String Demissao="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              ALTERAR FUNCIONARIO               |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o CPF do Funcionario a ser Alterado: ");
        CPF = s.nextLine();
        
        this.controle.buscaFuncionario(CPF);
        
        if (this.controle.getFuncionario()==null){ //não encontrou o CPF
            System.out.println("CPF do Funcionario não foi encontrado!");
        }
        else{ //encontrou o CPF
            
            int op=0;
            System.out.println("Funcionario: "+this.controle.getFuncionario().getCPF()+"---"+this.controle.getFuncionario().getNome()+", Código: "+this.controle.getFuncionario().getCodigo());
            
            System.out.println("Deseja alterar esse funcionario? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
                
            if (op==1){
                
                Codigo=this.controle.getFuncionario().getCodigo();
                
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
                if (CPF.equals("")){
                    System.out.println("Digite o CEP: ");
                    CEP = s.nextLine();
                }
                if(Cidade.equals("")){
                    System.out.println("Digite a Cidade: ");
                    Cidade = s.nextLine();
                }
                if (UF.equals("")){
                    System.out.println("Digite o Estado: ");
                    UF = s.nextLine();
                }
                if (CPF.equals("")){
                    System.out.println("Digite o CPF: ");
                    CPF = s.nextLine();
                }
                if (RG.equals("")){
                    System.out.println("Digite o RG: ");
                    RG = s.nextLine();
                }
                if (dataNascimento.equals("")){
                    System.out.println("Digite o Data de Nascimento: ");
                    dataNascimento = s.nextLine();
                }
                if (Cargo.equals("")){
                    System.out.println("Digite o Cargo: ");
                    Cargo = s.nextLine();
                }
                if (Salario==0){
                    System.out.println("Digite o Salario: ");
                    Salario = Double.parseDouble(s.nextLine());
                }
                if (Admissao.equals("")){
                    System.out.println("Digite o Data de Admissão: ");
                    Admissao = s.nextLine();
                }
                
                try{
                    this.controle.alterarFuncionario(Codigo, Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CPF, RG, dataNascimento, Cargo, Salario, Admissao, Demissao);
                
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("");
                }
                
                System.out.println("Funcionário Alterado com Sucesso!");
            }
            
        }
        
    }

    private void excluirFuncionario() {
        
        int codigo=0;
        int verifica;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               EXCLUIR FUNCIONARIO              |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Funcionario a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        verifica=this.controle.excluirFuncionario(codigo);
        
        if (verifica==0){
            System.out.println("Não existe este Fornecedor no Cadastro!");
        }
        else{
            System.out.println("Fornecedor Excluido com Sucesso!");
        }
        
    }

    private void buscarFuncionario() {
        
        String CPF = "";
        Scanner s = new Scanner(System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                BUSCAR FUNCIONARIO               |");
        System.out.println("|-------------------------------------------------|");
        
        System.out.println("Digite o CPF do Funcionario a ser Pesquisado: ");
        CPF = s.nextLine();
        
        this.controle.buscaFuncionario(CPF);
        
        if(this.controle.getFuncionario()==null){
            System.out.println("CPF do Funcionario não foi encontrado!");
        }
        else{
            System.out.println("|-------------------------------------------------|");
            System.out.println("Funcionario: "+this.controle.getFuncionario().getCodigo()+"---"+
                this.controle.getFuncionario().getNome()+"---"+
                this.controle.getFuncionario().getTelefone()+"---"+
                this.controle.getFuncionario().getEndereco()+"---"+
                this.controle.getFuncionario().getNumero()+"---"+
                this.controle.getFuncionario().getBairro()+"---"+
                this.controle.getFuncionario().getCep()+"---"+
                this.controle.getFuncionario().getCidade()+"---"+
                this.controle.getFuncionario().getUF()+"---"+
                this.controle.getFuncionario().getCPF()+"---"+
                this.controle.getFuncionario().getRG()+"---"+
                this.controle.getFuncionario().getDataNascimento()+"---"+
                this.controle.getFuncionario().getCargo()+"--"+
                this.controle.getFuncionario().getSalario()+"---"+
                this.controle.getFuncionario().getAdmissao()+"---"+
                this.controle.getFuncionario().getDemissao()
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }

    private void todosFuncionario() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                LISTAR FUNCIONARIO               |");
        System.out.println("|-------------------------------------------------|");
        
        this.controle.todosFuncionarios();
        
        for (int i=0; i<this.controle.getListaFuncionario().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+
                this.controle.getListaFuncionario().get(i).getCodigo()+"---"+
                this.controle.getListaFuncionario().get(i).getNome()+"---"+
                this.controle.getListaFuncionario().get(i).getCPF()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}
