import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Client client = new Client();
        Agenda agenda = new Agenda();
        Scanner escolha = new Scanner(System.in);
        int choice = 0;

        
        while (choice != 3) {
            try {
                System.out.println("--- Olá, Qual área você deseja? ---");
                System.out.println("1 - Acessar área do cliente");
                System.out.println("2 - Acessar área da agenda");
                System.out.println("3 - Para fechar o programa");

                choice = escolha.nextInt();

                if (choice == 1) {
                    client.opcoes(); 
                    choice = 3;
                } else if (choice == 2) {
                    agenda.opcoes_agenda(); 
                    choice = 3;
                } else if (choice != 3) {
                    System.out.println("\n*** Favor digitar uma das opções ***\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n*** Favor digitar uma das opções - digite qualquer botão para continuar ***\n");
                escolha.next(); // Limpa o buffer do scanner após a exceção
            }
        }
        escolha.close(); // Fechando o Scanner após o uso3
    }
}
