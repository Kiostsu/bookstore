package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import Entidades.Genero;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GeneroDAO extends AbstractDAO {

    @Override
    public void insert(Object o) throws Exception {
        Genero genero = new Genero(); // converte genero para um objeto
        if (o instanceof Genero) {
            genero = (Genero) o;
        }
        if (con == null) {
            con = new Conexao().getConnection();
        }
        String sql = "insert into generos(descricao) values(?)";
        //O segundo parâmetro específica que vai retornar o código do registro inserido
        pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setString(1, genero.getDescricao());
          
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir os dados. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }

    @Override
    public void delete(Object o) throws Exception {
        Genero genero = new Genero();
        if (o instanceof Genero) {
            genero = (Genero) o;
        }
        try {
            if (con == null) {
                con = new Conexao().getConnection();
            }
            pstmt = con.prepareStatement("delete from generos where id = ?");
            pstmt.setInt(1, genero.getId());
            int i = pstmt.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao remover Locação : " + genero.getId());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi excluir esta locação", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }

    @Override
    public void update(Object o) throws Exception {
        Genero genero = new Genero(); // criar referencia de genero
        if (o instanceof Genero) {
            genero = (Genero) o; // converter em objeto
        }

        if (con == null) {
            con = new Conexao().getConnection(); // realiza a conexão com o banco usando URL usuario e senha
        }

        try {
            pstmt = con.prepareStatement("UPDATE GENEROS SET DESCRICAO  = ? WHERE ID = ?");

            pstmt.setString(1, genero.getDescricao());
           
            pstmt.setInt(2, genero.getId());
            int i = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso");
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o cadastro ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cadastro. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }
}


