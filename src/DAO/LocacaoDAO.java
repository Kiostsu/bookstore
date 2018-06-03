package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import Entidades.Locacao;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LocacaoDAO extends AbstractDAO {

    @Override
    public void insert(Object o) throws Exception {
        Locacao locacao = new Locacao(); // converte locacao para um objeto
        if (o instanceof Locacao) {
            locacao = (Locacao) o;
        }
        if (con == null) {
            con = new Conexao().getConnection();
        }
        String sql = "insert into locacao(ALUNO,CURSO,TURMA,LIVRO,DATA,ENTREGA) values(?,?,?,?,?,?)";
        //O segundo parâmetro específica que vai retornar o código do registro inserido
        pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setString(1, locacao.getAluno());
            pstmt.setString(2, locacao.getCurso());
            pstmt.setString(3, locacao.getTurma());
            pstmt.setString(4, locacao.getLivro());
            pstmt.setString(5, locacao.getData());
            pstmt.setString(6, locacao.getEntrega());
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
        Locacao locacao = new Locacao();
        if (o instanceof Locacao) {
            locacao = (Locacao) o;
        }
        try {
            if (con == null) {
                con = new Conexao().getConnection();
            }
            pstmt = con.prepareStatement("delete from locacao where id = ?");
            pstmt.setInt(1, locacao.getId());
            int i = pstmt.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao remover Locação : " + locacao.getId());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi excluir esta locação", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }

    @Override
    public void update(Object o) throws Exception {
        Locacao locacao = new Locacao(); // criar referencia de locacao
        if (o instanceof Locacao) {
            locacao = (Locacao) o; // converter em objeto
        }

        if (con == null) {
            con = new Conexao().getConnection(); // realiza a conexão com o banco usando URL usuario e senha
        }

        try {
            pstmt = con.prepareStatement("UPDATE LOCACAO SET ALUNO = ?, CURSO = ?, TURMA = ?, LIVRO = ?, DATA = ?, ENTREGA = ? WHERE ID = ?");

            pstmt.setString(1, locacao.getAluno());
            pstmt.setString(2, locacao.getCurso());
            pstmt.setString(3, locacao.getTurma());
            pstmt.setString(4, locacao.getLivro());
            pstmt.setString(5, locacao.getData());
            pstmt.setString(6, locacao.getEntrega());
            pstmt.setInt(7, locacao.getId());
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


