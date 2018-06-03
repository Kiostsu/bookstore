package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    //parametros para conexão com o BD
    Connection con; //Representa a conexão com o BD
    String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/cadastroLocacao";
    String USUARIO = "root";
    String SENHA = "";
            
    public Conexao(){
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao driver MySQL " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Connected");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    public void closeConnection(){
        if(con!=null)
            try {
                con.close();
                System.out.println("Disconnected");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}