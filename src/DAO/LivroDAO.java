package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import Entidades.Livro;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LivroDAO extends AbstractDAO {

    @Override
    public void insert(Object o) throws Exception {
        Livro livro = new Livro(); // converte livro para um objeto
        if (o instanceof Livro) {
            livro = (Livro) o;
        }
        if (con == null) {
            con = new Conexao().getConnection();
        }
       
        try {
            pstmt = con.prepareStatement("select id from generos where descricao=?");//selecionar id onde nome=

            pstmt.setString(1, livro.getGenero().getDescricao());
            rs = pstmt.executeQuery(); //fazendo pesquisa no banco
            rs.next(); //Pegar o primeiro elemento retornado da consulta enquanto houverem
            int idGenero = rs.getInt("id"); // atribuir o campo id_marca da tabela marcas em uma variável
            rs.close();//fecha o result set
            pstmt.close();//e o prep statement
            String sql = "insert into livro(id_genero,titulo,editora,autor,ano) values(?,?,?,?,?)";
            //O segundo parâmetro específica que vai retornar o código do registro inserido
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idGenero);
            pstmt.setString(2, livro.getTitulo());
            pstmt.setString(3, livro.getEditora());
            pstmt.setString(4, livro.getAutor());
            pstmt.setInt(5, livro.getAno());
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
        Livro livro = new Livro();
        if (o instanceof Livro) {
            livro = (Livro) o;
        }
        try {
            if (con == null) {
                con = new Conexao().getConnection();
            }
            pstmt = con.prepareStatement("delete from livro where id = ?");
            pstmt.setInt(1, livro.getId());
            int i = pstmt.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao remover Locação : " + livro.getId());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi excluir esta locação", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }

    @Override
    public void update(Object o) throws Exception {
        Livro livro = new Livro(); // criar referencia de livro
        if (o instanceof Livro) {
            livro = (Livro) o; // converter em objeto
        }

        if (con == null) {
            con = new Conexao().getConnection(); // realiza a conexão com o banco usando URL usuario e senha
        }

        try {
                        pstmt = con.prepareStatement("select id from generos where descricao=?");//selecionar id onde nome=

            pstmt.setString(1, livro.getGenero().getDescricao());
            rs = pstmt.executeQuery(); //fazendo pesquisa no banco
            rs.next(); //Pegar o primeiro elemento retornado da consulta enquanto houverem
            int idGenero = rs.getInt("id"); // atribuir o campo id_marca da tabela marcas em uma variável
            rs.close();//fecha o result set
            pstmt.close();//e o prep statement
            String sql = "update livro set id_genero = ?,titulo = ?,editora = ?,autor = ?,ano = ? where id = ?";
            //O segundo parâmetro específica que vai retornar o código do registro inserido
            pstmt = con.prepareStatement(sql  );
            pstmt.setInt(1, idGenero);
            pstmt.setString(2, livro.getTitulo());
            pstmt.setString(3, livro.getEditora());
            pstmt.setString(4, livro.getAutor());
            pstmt.setInt(5, livro.getAno());
            pstmt.setInt(6, livro.getId());
            pstmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cadastro. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            AbstractDAO.close(pstmt);
        }
    }
}


