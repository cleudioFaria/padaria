
package panificadora.uteis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ManipulaBD {
    
    public static void gravaTabelasEmArquivos(ArrayList<Object> tabela, String nomeArquivo) throws IOException{    
        
        // conectando/definindo um arquivo/diretorio a ser manipulado
        File arquivo = new File(nomeArquivo);
        
        //Apagar o arquivo existente
        arquivo.delete();
        
        //criar um novo arquivo
        arquivo.createNewFile();
        
        // criar o gravador dos dados no arquivo
        FileOutputStream fos = new FileOutputStream(arquivo);
        
        // criando um espaço de memoria temporario (buffer) para gravar as tabelas antes de serem salvas no disco
        ObjectOutputStream objOutput = new ObjectOutputStream(fos);
        
        // gravar a tabela no arquivo binario
        objOutput.writeObject(tabela); //serializando o objeto tabela para salvar como binario, ou seja, transforma o objeto tabela em uma seguencia de bytes
        
        objOutput.close(); //fechando o buffer. Então, o buffer descarrrega os bytes no disco gerando o arquivo
        
        
    }
    
    public static ArrayList<Object> recuperaTabelaEmArquivo(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<Object> tabela = null;
        
        // conectando com um arquivo (fornecedor.dat ou jogos.dat ou clientes.dat ou funcionario.dat......)
        File arquivo = new File(nomeArquivo);
        
        // verificando se o arquivo a ser recuperado existe. Se existir, recupera essa arquivo do disco.
        if ( arquivo.exists() ){
            
            // criando um leitor e processados de dados do arquivo
            // Esse objeto lê a seguencia de bytes contidos dentro do arquivo, vai transformar em um objeto novamente e vai jogar dentro de uma memoria temporaria (buffer)
            FileInputStream objIn = new FileInputStream(arquivo);
            
            // Esse objeto (buffer) é a memoria temporaria onde será armazenado as tabelas (ArrayList<Fornecedor>, ArrayList<Jogos>, .....) pra serem recuperadas.
            ObjectInputStream obj = new ObjectInputStream(objIn);
            
            //pegando o objeto armazenado no buffer e fazendo um cast desse objeto para ArrayList<Object>
            tabela = (ArrayList<Object>)obj.readObject();
            
            //fechando o buffer, o leitor e o arquivo
            obj.close();
        }
        
        return tabela;
        
    }
    
}
