
/*
 * To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import static DAO.AbstractDAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ResultSetComboBoxAlunos extends AbstractListModel implements ComboBoxModel {

    private PreparedStatement pstmt; //executa instrução SQL
    private ResultSet resultSet;//retorna conjunto de dados da tabela
    private ResultSetMetaData metaData;//retorna metadados da tabela
    Object selected = null;
    ArrayList objetos = new ArrayList();//Array list para os dados do banco

    @Override
    public int getSize() {
        return objetos.size(); //pegar o tamanho do array

    }

    @Override
    public Object getElementAt(int index) {

        return objetos.get(index); // pegar os elementos no indice

    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = anItem; //mudar o item selecionado
        fireContentsChanged(this, 0, 0); // Forçar atualização da combobox
    }

    @Override
    public Object getSelectedItem() {
        return selected; // pegar o item selecionado
    }

    public ResultSetComboBoxAlunos() throws SQLException {
        if (con == null) {//coneta ao BD
            con = new Conexao().getConnection();
        }

        pstmt = con.prepareStatement("select nome from aluno");
        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            objetos.add(resultSet.getString(1));
        }
        selected = objetos.get(0);
    }

}

