
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.nio.file.Files;
public class Main
{
    public static void main (String[] args) {
        Agenda calendario = new Agenda();
        
        switch(args[0]){
            case "add": {
                calendario.add_Event(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),args[4]);
                break;
            }
            case "showall": {
                calendario.get_All();
                break;
            }
            case "clearall": {
                calendario.clear_All_Events();
                break;
            }
            case "show": {
                calendario.get_Event(args[1]);
                break;
            }
            case "clear": {
                calendario.clear_Event(args[1]);
                break;
            }
            default: System.out.println("foda-se");
                     break;
        }
    }
}
