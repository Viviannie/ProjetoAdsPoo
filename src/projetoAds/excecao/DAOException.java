package projetoAds.excecao;
/**
 * @author Aluno
 */
public class DAOException extends Exception {
    public DAOException() {}
    
    public DAOException(String x) {
        super(x);
    }
    
    public DAOException(Exception e) {
        super(e);
    }
    
}
