package actividad1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String path=".";
        String name = "data.txt";
        File file = new File(path, name);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            double avgEdad=0,avgAltura=0;
            int nPersonas=0;
            String linea;
            while ((linea=br.readLine())!=null){
                String[] line= linea.split(" ");
                nPersonas++;  
                avgEdad +=Integer.parseInt(line[1]);
                avgAltura +=Double.parseDouble(line[2]);
            }
            br.close();
            System.out.println("Media edad: "+avgEdad/nPersonas);
            System.out.println("Media altura: "+avgAltura/nPersonas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}