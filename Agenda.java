import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    int contador = 1;
    FileReader fr = null;
    BufferedReader br = null;

    // Caminho do arquivo
    private static String nomeArquivo = "C:\\Users\\Gravena\\OneDrive\\Área de Trabalho\\flag.txt";


    public void opcoes_agenda(){

        Client client = new Client();
        Scanner escolha_agenda = new Scanner(System.in);
        int choice_agenda = 0;

        while(choice_agenda != 5){
            System.out.println("\n*** Área da Agenda ***\n");
            System.out.println("1 - Ver agenda");
            System.out.println("2 - Agendar pet");
            System.out.println("3 - Ver um pet especifico");
            System.out.println("4 - Listar por ordem de agendamento");
            System.out.println("5 - para fechar o programa");
            
            choice_agenda = escolha_agenda.nextInt();


            if(choice_agenda == 1){
                print();
                choice_agenda = 5;
            }

            else if(choice_agenda == 2){
                client.question();
                choice_agenda = 5;
            }

            // Pet especifico por ID
            else if(choice_agenda == 3){
                especifico();
                choice_agenda = 5;
            }

            else if(choice_agenda == 4){
                ordemAgendamento();
                choice_agenda = 5;
            }

            else if(choice_agenda != 1 && choice_agenda != 2 && choice_agenda != 3 && choice_agenda != 4 && choice_agenda != 5){
                System.out.println("\n*** Favor digitar uma das opções ***\n");
            }
        }
    }


    // grava as respostas no banco de dado(notepad) e não imprime
    public void record(String nome, String nomePet, int idade, int telefone, String alergia, String raca){
        
        // Gerador de ID



        // Grava dados no arquivo junto com o id em cima
        
        try{

            try{
                fr = new FileReader(nomeArquivo);
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
            boolean arquivoExiste = new File(nomeArquivo).exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter data = new FileWriter(nomeArquivo, arquivoExiste);
            if (!arquivoExiste){
                data.write("Nome");
            }

            // escrever os dados
            data.write(contador + ", " + nome + ", " + nomePet + ", " + idade + ", " + telefone + ",  " + alergia + ", " + raca + "\n");

            // Escrever todos os dados do buffer no arquivo imediatamente
            data.flush();

            // Fecha o rescurso de escrita
            data.close();

        } 

        catch(IOException e){
            e.printStackTrace();
        }
    }


    // imprime o que estiver no banco de dados
    public void print(){
        
        try{
            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);

            String line = br.readLine();
            
            System.out.println("ID, " + "NOME, " + "Nome do Pet, " + "Idade do Pet, " + "Telefone, " + "Alergia, " + "Raça, "+ "\n");

            while(line != null){
                System.out.println(line.replace(",", ", "));
                line = br.readLine();
            }
        }

        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        finally{
            try{
                br.close();
                fr.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    // Pet especifico por ID
    public void especifico(){
        Scanner escolhaIDPet = new Scanner(System.in);
        System.out.println("Qual ID procurar? ");
        int choiceID = escolhaIDPet.nextInt();

        try{
            try{
                fr = new FileReader(nomeArquivo);
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
            boolean arquivoExiste = new File(nomeArquivo).exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter data = new FileWriter(nomeArquivo, arquivoExiste);
            if (!arquivoExiste){
                data.write("Nome");
            }

        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        if(choiceID > contador){
            System.out.println("Numero não existente - tente novamente ou feche o programa");
            Scanner escolha_continua = new Scanner(System.in);

            System.out.println("1 - Para continuar");
            System.out.println("Outro - Para fechar o programa");
            int choice_continua = 0;
            
            try{
                choice_continua = escolha_continua.nextInt();

                if(choice_continua == 1){
                    especifico();
                }

                else{
                    System.exit(0);
                }
            }catch(Exception e){
                System.exit(0);;
            }
        }

        else{
            int procura = 0;

            try{
                fr = new FileReader(nomeArquivo);
                br = new BufferedReader(fr);
    
                String line = br.readLine();
                
                System.out.println("ID, " + "NOME, " + "Nome do Pet, " + "Idade do Pet, " + "Telefone, " + "Alergia, " + "Raça, "+ "\n");
    
                while(procura != choiceID){
                    procura ++;
                    if(procura == choiceID){
                        System.out.println(line.replace(",", "\t"));
                    }
                    line = br.readLine();
                }
            }
    
            catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    public void ordemAgendamento(){
        try {
            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);

            List<String> linhas = new ArrayList<>();
            String line = br.readLine();
            
            // Adiciona cada linha à lista
            while (line != null) {
                linhas.add(line);
                line = br.readLine();
            }

            // Imprime os dados de baixo para cima
            System.out.println("ID, " + "NOME, " + "Nome do Pet, " + "Idade do Pet, " + "Telefone, " + "Alergia, " + "Raça, "+ "\n");
            Collections.reverse(linhas); // Inverte a ordem das linhas
            for (String linha : linhas) {
                System.out.println(linha.replace(",", "\t"));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}