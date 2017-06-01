package projetoAds.conexao;

import java.sql.Connection;
import projetoAds.excecao.ConexaoException;

/**
 *
 * @author aluno
 */
public interface ConexaoBD {

    /**
     * Estabelece uma conexao com o BD
     *
     * @return Uma conexao ativa
     * @throws ConexaoException
     */
    public Connection conectar() throws ConexaoException;

    /**
     * Encerra uma conexao com o BD
     *
     * @param c Objeto de conexao ativa
     * @throws ConexaoException
     */
    public void desconectar(Connection c) throws ConexaoException;

}
