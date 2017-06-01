package projetoAds.conexao; //Nome do pacote que essa classe estar

import java.sql.Connection; //Classe que gera a Conexão com o banco de dados.
import java.sql.DriverManager;  //Gerencia a Conexão.
import java.sql.SQLException;   //Classe de Exceção do SQL
import java.util.ResourceBundle;    //Usando para lê arquivos
import projetoAds.excecao.ConexaoException;

/**
 *
 * @author aluno
 */
//Encapsulamento
public class Conectar implements ConexaoBD {

    private final String url;
    private final String usu;
    private final String sen;
    private static Conectar instancia;

    /**
     * Abaixo o ResourceBundle Recebe o local que o arquivo vai está Atráves do
     * Arquivo recebe: url, usuário e senha.
     */
    private Conectar() {
        ResourceBundle rb = ResourceBundle.getBundle("projetoAds.conexao.configBanco");
        url = rb.getString("url");
        usu = rb.getString("usu");
        sen = rb.getString("sen");
    }

    //@Singleton 
    public static Conectar getInstancia() {           //precisa ser static
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

        Connection c;
        try {
            c = DriverManager.getConnection(url, usu, sen);
            return c;
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

}
