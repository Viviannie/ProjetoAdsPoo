package projetoAds.conexao; //Nome do pacote que essa classe estar

import java.sql.Connection; //Classe que gera a Conexão com o banco de dados.
import java.sql.DriverManager;  //Gerencia a Conexão.
import java.sql.SQLException;   //Classe de Exceção do SQL
import java.util.ResourceBundle;    //Usando para lê arquivos
import projetoAds.excecao.ConexaoException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
//Encapsulamento
public class Conectar implements ConexaoBD {

    private final String url;
    private final String usuario;
    private final String senha;
    private static Conectar instancia;

    /**
     * Abaixo, o ResourceBundle Recebe o local que o arquivo vai estar, atráves do
     * Arquivo recebe: url, usuário e senha.
     */
    private Conectar() {
        ResourceBundle resb = ResourceBundle.getBundle("projetoAds.conexao.configBanco");
        url = resb.getString("url");
        usuario = resb.getString("usuario");
        senha = resb.getString("senha");
    }
    
    /*
    * Criado para limitar a quantidade de instâncias e para ter apenas uma
    * conexão.
    * Retorna a instância da classe.
    */

    //@Singleton 
    public static Conectar getInstancia() {
        if (instancia == null) {
            instancia = new Conectar();
        }
        return instancia;
    }

    /*
     * Sobrescrita da interface.
     * Como é um metodo que pode ou não gerar conexão é necessario -
     * - resolver ou jogar pra cima o possivel erro que pode dar
     */
    @Override
    public Connection conectar() throws ConexaoException {
        Connection con;
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            return con;//Retorna uma conexão com o bd se todos os dados acima forém validos
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

    @Override
    public void desconectar(Connection con) throws ConexaoException {
        try {
            con.close(); // Encerra a conexão com o bd
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

}
