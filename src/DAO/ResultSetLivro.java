package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

// A classe ResultSetLivro realiza a conexão com o banco de dados 
//via TableModel e mantém o ResultSet.
//todos os métodos devem realizar a conexão com o BD
//essa classe estende a classe AbstractTableModel
//e, portanto, deve implementar todos os seus métodos abstratos
//todos os métodos abstrados lançam uma exceção throws IllegalStateException
//essa exceção 
public class ResultSetLivro extends AbstractTableModel {

    //declaração dos atributos da classe
    private PreparedStatement pstmt; //responsável por executar instrução SQL
    private ResultSet resultSet;//retorna conjunto de dados da tabela
    private ResultSetMetaData metaData;//retorna metadados da tabela
    private int numeroLinhas;//retorna número de linhas da tabela

    private boolean conectado = false;

    //metodo construtor 
    public ResultSetLivro() throws SQLException {
        if (con == null) {//conecta ao BD
            con = new Conexao().getConnection();
        }
        conectado = true;

        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

 pstmt = con.prepareStatement("select l.id as Codigo,"
                + " g.descricao as Genero,"
                + " l.titulo as Titulo,"
                + " l.editora as Editora,"
                + " l.autor as Autor,"
                + " l.ano as Ano"
                + " from livros l"
                + " inner join generos g on"
                + " g.id = l.id_genero");
        resultSet = pstmt.executeQuery();
        //obtém metadados da consulta: número e nome de colunas retornadas
        //tipos de dados daquela coluna
        metaData = resultSet.getMetaData();
        //envio para o ultimo registro
        resultSet.last();
        //para obter o número da linha
        numeroLinhas = resultSet.getRow();
    }

    @Override
    //O método getColumnClass retorna o tipo de dado 
    //referente à coluna especificada no parâmetro (int column).
    //ou seja: obtém a classe que representa o tipo de 
    //coluna que pode ser: Integer, String, Double, etc.
    /*Linhas e colunas do ResultSet são contadas a partir de 1
    e linhas e colunas da JTable são contadas a partir de 0.
    Ao processar as linhas e colunas de ResultSet para utilização em
    uma JTable, é necessário adicionar 1 ao número de linhas ou coluna
    para manipular a coluna apropriada de ResultSet
    coluna 0 da JTable corresponde a coluna 1 da Resultset
     */

    public Class getColumnClass(int column) throws IllegalStateException {

        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

        try {
            // obtém o nome da classe para o tipo da coluna especificada (String, Integer...)
            //column + 1, porque a primeira coluna de uma consulta SQL
            //inicia em 1 e o número da coluna em um TableModel inicia em 0
            String nomeClasse = metaData.getColumnClassName(column + 1);
            // retorna objeto Class que representa o nome da classe 
            return Class.forName(nomeClasse);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        //se ocorreram erros retorna o tipo Object ao invés do tipo específico (string, Double, etc)
        return Object.class;
    }

    @Override
    //obtem a quantidade de colunas da tabela
    public int getColumnCount() throws IllegalStateException {
        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

        try {
            //retorna a qtde de colunas da tabela
            return metaData.getColumnCount();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
//se ocorreram erros retorna nulo
        return 0;
    }

    @Override
    //obtém o nome das colunas
    public String getColumnName(int column) throws IllegalStateException {
        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

        try {
            //retorna o nome da coluna
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o nome das colunas. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
//se ocorreram erros retorna nulo
        return "";
    }

    @Override
    //obtém a qtde de linhas de ResultSet
    public int getRowCount() throws IllegalStateException {
        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

        return numeroLinhas;
    }

    @Override
    //obtém valor na linha e na coluna especificada
    public Object getValueAt(int row, int column)
            throws IllegalStateException {
        if (!conectado) {
            throw new IllegalStateException("Não está conectado ao BD");
        }

        try {
            resultSet.absolute(row + 1); //move o cursor para a linha especificada
            return resultSet.getObject(column + 1);//e pega o valor da coluna

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
//caso deu algum erro retorna string vazio
        return "";
    }

    //metodo que desconecta todas as classes que necessitam de conexão
    public void desconectarBD() {
        if (!conectado) {
            try {
                resultSet.close();
                pstmt.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi fechar a conexão. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } finally {
                conectado = false;
            }
        }
    }
}
