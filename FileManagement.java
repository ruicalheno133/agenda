import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;
import java.io.File;

public class FileManagement {
    private static String HOME = System.getProperty("user.home");
	private static String FILENAME = HOME + "/Agenda/events.txt";
	private static String FILENAME_AUX = HOME + "/Agenda/aux.txt";

	public static void write_On_File (int dia , int mes, int ano , String descricao) {

 		BufferedWriter bw = null;
        FileWriter fw = null;


        try {

            String content = descricao + " >>> " + Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano) + "\n";

            fw = new FileWriter(FILENAME,true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.print("\nThe following event was saved: " + content);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
	}

	public static void read_One_From_File (String descricao) {
		BufferedReader br = null;
        FileReader fr = null;
        int i;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            String auxLine = descricao;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                for (i = 0; i < sCurrentLine.length() && sCurrentLine.charAt(i) != '>' ; i++);
                auxLine= sCurrentLine.substring(0,i-1);
            	if (auxLine.equals(descricao)) {
            		System.out.println(sCurrentLine);
            		break; // tirar eventualmente
            	}

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {


                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
	}

	public static void delete_One_From_File(String descricao) {
		BufferedReader br = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        int i;
        File original = new File(FILENAME);
        File aux = new File(FILENAME_AUX);
        private deleted = 0;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            fw = new FileWriter(FILENAME_AUX,true);
            bw = new BufferedWriter(fw);

            

            String sCurrentLine;
            String auxLine = descricao;

           

            while ((sCurrentLine = br.readLine()) != null) {
                for (i = 0; i < sCurrentLine.length() && sCurrentLine.charAt(i) != '>' ; i++);
                auxLine= sCurrentLine.substring(0,i-1);
            	if (auxLine.equals(descricao)) {
                    System.out.println("\nSucessfuly deleted the following Event: " + sCurrentLine);
                    deleted = 1;
            	} else {
            		bw.write(sCurrentLine + "\n");
            		
            	}

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

            	if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
      if (deleted == 0) System.out.println("\nThe Event was not found")
      aux.renameTo(original);
	}
	
	public static void write_All(){

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            System.out.println("\n< Presenting All Events >\n");
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
            System.out.println("\n<          Done         >");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    public static void delete_All () {
        try {
            PrintWriter pw = new PrintWriter(FILENAME);
            pw.close();
            System.out.println("\nAll events were deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}