

package br.com.bibliotecaweb.model;


import br.com.bibliotecaweb.dal.*;
import br.com.bibliotecaweb.model.Editora;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
/**
 *
 * @author
 */
public abstract class EditoraTamplate {
    //Atributos
     private Connection connection;
    
     private Editora editora;
    //Metodos
    public EditoraTamplate(String nome){
       editora = new Editora();
        
    }
    //Metodo abstrato que ira compor o algoritmo de ordenacao da listagem
    public abstract boolean ePrimeiro(Editora editora1, Editora editora2);
    
      
}
