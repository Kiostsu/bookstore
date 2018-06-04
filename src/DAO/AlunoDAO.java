package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import Entidades.Aluno;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AlunoDAO extends AbstractDAO {

    @Override
    public void insert(Object o) throws Exception {
        Aluno aluno = new Aluno(); // converte aluno para um objeto
        if (o instanceof Aluno) {
            aluno = (Aluno) o;
        }
        if (con == null) {
            con = new Conexao().getConnection();
        }
       
        try {
           
            String sql = "insert into aluno(curso,turma,nome,numero_matricula) values(?,?,?,?)";
            //O segundo parâmetro específica que vai retornar o código do registro inserido
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, aluno.getCurso());
            pstmt.setString(2, aluno.getTurma());
            pstmt.setString(3, aluno.getNome());
            pstmt.setInt(4, aluno.getNumeroMatricula());
            
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
        Aluno aluno = new Aluno();
        if (o instanceof Aluno) {
            aluno = (Aluno) o;
        }
        try {
            if (con == null) {
                con = new Conexao().getConnection();
            }
            pstmt = con.prepareStatement("delete from aluno where id = ?");
            pstmt.setInt(1, aluno.getId());
            int i = pstmt.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao remover Locação : " + aluno.getId());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi excluir esta locação", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }

    @Override
    public void update(Object o) throws Exception {
        Aluno aluno = new Aluno(); // criar referencia de aluno
        if (o instanceof Aluno) {
            aluno = (Aluno) o; // converter em objeto
        }

        if (con == null) {
            con = new Conexao().getConnection(); // realiza a conexão com o banco usando URL usuario e senha
        }

        try {         
            String sql = "update aluno set curso = ?,turma = ?,nome = ?,numero_matricula = ? where id = ?";
            //O segundo parâmetro específica que vai retornar o código do registro inserido
            pstmt = con.prepareStatement(sql  );
            
            pstmt.setString(1, aluno.getCurso());
            pstmt.setString(2, aluno.getTurma());
            pstmt.setString(3, aluno.getNome());
            pstmt.setInt(4, aluno.getNumeroMatricula());
            pstmt.setInt(5, aluno.getId());
            pstmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cadastro. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }
}


