import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Record {
    int contador = 1;
    FileReader fr = null;
    BufferedReader br = null;


    private static String file_pet = "C:\\Users\\Gravena\\OneDrive\\Área de Trabalho\\test\\bd_pet.txt";
    private static String file_tutor = "C:\\Users\\Gravena\\OneDrive\\Área de Trabalho\\test\\bd_tutor.txt";

    // grava as respostas no banco de dado(notepad) e não imprime
    public void record_pet(String nomePet, int idade, String raca, String alergia){
        
        // Gerador de ID



        // Grava dados no arquivo junto com o id em cima
        
        try{

            try{
                fr = new FileReader(file_pet);
                br = new BufferedReader(fr);
    
                String line = br.readLine();
    

                while(line != null){
                    contador++;
                    line = br.readLine();
                }
            }
    
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }


            // verifica se o arquivo já existe
            boolean arquivoExiste = new File(file_pet).exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter data = new FileWriter(file_pet, arquivoExiste);
            if (!arquivoExiste){
                data.write("Nome");
            }

            // escrever os dados
            data.write(contador + ", " + nomePet + ", " + idade + ", " + raca + ", " + alergia + ", " + "\n");

            // Escrever todos os dados do buffer no arquivo imediatamente
            data.flush();

            // Fecha o rescurso de escrita
            data.close();

        } 

        catch(IOException e){
            e.printStackTrace();
        }
    }


    // grava as respostas no banco de dado(notepad) e não imprime
    public void record_tutor(String nome, int telefone, String endereco, String pagamento){
        
        // Gerador de ID



        // Grava dados no arquivo junto com o id em cima
        
        try{

            try{
                fr = new FileReader(file_tutor);
                br = new BufferedReader(fr);
    
                String line = br.readLine();
    

                while(line != null){
                    contador++;
                    line = br.readLine();
                }
            }
    
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }


            // verifica se o arquivo já existe
            boolean arquivoExiste = new File(file_tutor).exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter data = new FileWriter(file_tutor, arquivoExiste);
            if (!arquivoExiste){
                data.write("Nome");
            }

            // escrever os dados
            data.write(contador + ", " + nome + ", " + telefone + ", " + endereco + ", " + pagamento +"\n");

            // Escrever todos os dados do buffer no arquivo imediatamente
            data.flush();

            // Fecha o rescurso de escrita
            data.close();

        } 

        catch(IOException e){
            e.printStackTrace();
        }
    }

}
