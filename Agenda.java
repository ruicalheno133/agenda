
/**
 * Write a description of class Agenda here.
 * 
 * @author Skits Bacano
 * @version 24/02/17
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class Agenda
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Agenda
     */
    public Agenda()
    {
        //do nothing , is it bad behaviour ??

    }

    /**
     * Escreve num ficheiro o evento criado pelo utilizador
     * 
     * @param  dia  Contem o dia do evento
     * @param  mes  Contem o mes do evento
     * @param  ano  Contem o ano do evento
     * @return      void
     */
    public void add_Event(int dia, int mes, int ano, String descricao)
    {
        FileManagement.write_On_File(dia, mes, ano, descricao);
    }

    public void clear_Events() {
        FileManagement.delete_All();
    }

    public void get_All() {
        FileManagement.write_All();
    }

    
    public void get_Event (String descricao)
    {
        FileManagement.read_One_From_File(descricao);
    }

    public void delete_Event(String descricao)
    {
        FileManagement.delete_One_From_File(descricao);
    }

}
