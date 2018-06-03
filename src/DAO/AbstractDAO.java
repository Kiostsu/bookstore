package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class AbstractDAO {

    //atributos de acesso a banco e para execução e retorno SQL
    //Protected permite que somente as classes do mesmo pacote acessem os dados
    protected static Connection con;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    public AbstractDAO() {
        con = new Conexao().getConnection();
    }

    //Vai retornar um código
    public abstract void insert(Object o) throws Exception;

    public abstract void delete(Object o) throws Exception;

    public abstract void update(Object o) throws Exception;
    
    public static void close(PreparedStatement p) {
        try {
            //Verifica se o objeto connection estiver fechado
            if (!con.isClosed()) {
                con.close();
                con = null;
            }
            if (p != null) {
                p.close();
                p = null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar a conexão. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
