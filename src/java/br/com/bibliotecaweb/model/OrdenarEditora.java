
package br.com.bibliotecaweb.model;
public class OrdenarEditora extends EditoraTamplate {

    public OrdenarEditora(String nome) {
        super(nome);
    }

   
     @Override
    public  boolean ePrimeiro(Editora editora1, Editora editora2){
        if(editora1.getNome().compareToIgnoreCase(editora2.getNome()) <= 0) return true;
        else return false;
    }
}

