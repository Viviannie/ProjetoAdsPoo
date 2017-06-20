package projetoAds.excecao;

/**
 * Classe de Erros Herda da Classe Exception
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class ConexaoException extends Exception {

    public ConexaoException() {
    }

    public ConexaoException(String x) {
        super(x);                           //herdando da exception
    }

    public ConexaoException(Exception e) {
        super(e);                           //herdando da exception
    }
}
