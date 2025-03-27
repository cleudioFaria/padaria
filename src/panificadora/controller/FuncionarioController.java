package panificadora.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import panificadora.dao.FuncionarioDAO;
import panificadora.model.Funcionario;

/**
 *
 * @author Grupo Pan
 */
public class FuncionarioController {
    
    private Funcionario funcionario;
    private FuncionarioDAO bd;
    private ArrayList<Funcionario> listaFuncionario;
    
    public FuncionarioController(){
        this.funcionario = new Funcionario();
        this.bd = new FuncionarioDAO();
    }
    
    public Funcionario getFuncionario(){
        return this.funcionario;
    }
    
    public ArrayList<Funcionario> getListaFuncionario(){
        return this.listaFuncionario;
    }
    
    public void cadastrarFuncionario (String nome, String telefone, String endereco, int numero, String bairro, 
            String CEP, String cidade,String UF, String CPF, String RG, String dataNasc, String Cargo,
            double Salario, String Admissao) throws Exception{
        
        Funcionario fun = new Funcionario();
        
        fun.setCodigo(1);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setEndereco(endereco);
        fun.setNumero(numero);
        fun.setBairro(bairro);
        fun.setCep(CEP);
        fun.setCidade(cidade);
        fun.setUF(UF);
        fun.setCPF(CPF);
        fun.setRG(RG);
        //fun.setNascimento(dataNasc);
        fun.setCargo(Cargo);
        fun.setSalario(Salario);
        //fun.setDataAdmissao(Admissao);
        
        
        // Criando um objetco calendar e pegando a data atual
        Calendar nascimento = Calendar.getInstance();        
        Date d = new Date( dataNasc );        
        nascimento.setTime( d );
        
        fun.setDataNascimento( nascimento );
        
        Calendar admissao = Calendar.getInstance();        
        Date a = new Date( Admissao );        
        nascimento.setTime( a );
        
        
        this.bd.cadastrar(fun);
        
    }
    
    public void alterarFuncionario(int codigo, String nome, String telefone, String endereco, int numero, String bairro, 
            String CEP, String cidade,String UF, String CPF, String RG, String dataNasc, String Cargo,
            double Salario, String Admissao, String Demissao) throws Exception{
        
        Funcionario fun = new Funcionario();
        
        fun.setCodigo(codigo);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setEndereco(endereco);
        fun.setNumero(numero);
        fun.setBairro(bairro);
        fun.setCep(CEP);
        fun.setCidade(cidade);
        fun.setUF(UF);
        fun.setCPF(CPF);
        fun.setRG(RG);
        //fun.setNascimento(dataNasc);
        fun.setCargo(Cargo);
        fun.setSalario(Salario);
        //fun.setDataAdmissao(Admissao);
        //fun.setDataDemissao(Demissao);
        
        // Criando um objetco calendar e pegando a data atual
        Calendar nascimento = Calendar.getInstance();        
        Date d = new Date( dataNasc );        
        nascimento.setTime( d );
        
        fun.setDataNascimento( nascimento );
        
        Calendar admissao = Calendar.getInstance();        
        Date a = new Date( Admissao );        
        nascimento.setTime( a );
        
        Calendar demissao = Calendar.getInstance();        
        Date de = new Date( Demissao );        
        nascimento.setTime( de );
        
        this.bd.alterar(fun);
        
    }
    
    public int excluirFuncionario (int codigo){
        
        return this.bd.excluir(codigo);
        
    }
    
    public void buscaFuncionario (String CPF){
        
        this.funcionario = this.bd.recuperaCPF(CPF);
        
    }
    
    public void todosFuncionarios (){
        
        ArrayList<Object> retorno = this.bd.retornaTudo();
         
        this.listaFuncionario = new ArrayList<Funcionario>();
        
        for (Object o : retorno){
            
            Funcionario f = ((Funcionario)o);
            
            this.listaFuncionario.add(f);
            
        }
        
    }
    
}
