import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Client {
    Agenda agenda = new Agenda();
    Record record = new Record();

    public void opcoes(){
        Scanner escolha_cliente = new Scanner(System.in);
        int choice_cliente = 0;

        while(choice_cliente != 3){
            System.out.println("\n*** Área do Cliente ***\n");
            System.out.println("1 - Agendar um horário");
            System.out.println("2 - Quem Somos");
            System.out.println("3 - Para fechar o programa");
            
            choice_cliente = escolha_cliente.nextInt();


            if(choice_cliente == 1){
                question();
                choice_cliente = 3;
            }

            else if(choice_cliente == 2){
                quemSomos();
                choice_cliente = 3;
            }

            else if(choice_cliente != 1 && choice_cliente != 2 && choice_cliente != 3){
                System.out.println("\n*** Favor digitar uma das opções ***\n");
            }
        }
    }


    // faz as perguntas
    public void question(){
        System.out.println("\n*** Para agendamos um hórario para seu pet precisamos fazer algumas perguntas antes ***\n");
        

        // Scanner.in - input
        Scanner dado = new Scanner(System.in);

        String nome = "";
        String nomePet = "";
        int telefone = 0;
        String pagamento = "";
        String endereco = "";
        String alergia = "";
        String raca = "";
        int idade = 0;

        // Solicita ao usuário até que uma entrada válida seja fornecida

        // nome do tutor
        while (nome.isEmpty()) {
            System.out.println("\nQual seu nome? ");
            nome = dado.nextLine().trim();
            nome = new String(nome.getBytes(), StandardCharsets.UTF_8);
            if (nome.isEmpty()) {
                System.out.println("Por favor, insira um nome válido.");
            }
        }
        
        // telefone do tutor
        while (telefone == 0) {
            try{
                System.out.println("\nQual seu telefone? ");
                telefone = Integer.parseInt(dado.nextLine().trim());            
            }catch(NumberFormatException e){
                System.out.println("Telefone inválido. Por favor, insira um número válido.");
            }
        }


        // endereço do tutor
        while (endereco.isEmpty()) {
            System.out.println("\nQual seu endereço? ");
            endereco = dado.nextLine().trim();
            if (endereco.isEmpty()) {
                System.out.println("Por favor, insira um endereço valido.");
            }
        }


        // Forma de pagamento
        while (pagamento.isEmpty()) {
            System.out.println("\nQual a forma de pagamento? ");
            pagamento = dado.nextLine().trim();
            if (pagamento.isEmpty()) {
                System.out.println("Por favor, insira um endereço valido.");
            }
        }

        // Nome do Pet
        while (nomePet.isEmpty()) {
            System.out.println("\nQual o nome do Pet? ");
            nomePet = dado.nextLine().trim();
            if (nomePet.isEmpty()) {
                System.out.println("Por favor, insira um nome válido.");
            }
        }

        // idade do Pet
        while (idade == 0) {
            try{
                System.out.println("\nQual o idade do seu pet? ");
                idade = Integer.parseInt(dado.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Idade inválido. Por favor, insira um número válido.");
            }
        }

        // Pergunta se o Pet tem alguma alergia, como shampoo, perfume...
        while (alergia.isEmpty()) {
            System.out.println("\nSeu pet tem alguma alergia? ");
            alergia = dado.nextLine().trim();
            if (alergia.isEmpty()) {
                System.out.println("Por favor, insira um nome válido.");
            }
        }

        // Pergunta a raça do Pet
        while (raca.isEmpty()) {
            System.out.println("\nQual a raça do seu pet? ");
            raca = dado.nextLine().trim();
            if (raca.isEmpty()) {
                System.out.println("Por favor, insira um nome válido.");
            }
        }


        record.record_pet(nomePet, idade, raca, alergia);
        record.record_tutor(nome, telefone, endereco, pagamento);
    }

    public void quemSomos(){
        System.out.println("\n\nEm um pet shop exclusivo para cachorros, nosso foco é proporcionar um ambiente seguro e acolhedor para nossos amigos caninos. Nossa equipe é treinada especificamente para lidar com as necessidades e comportamentos desses animais, garantindo que cada visita seja uma experiência positiva para os peludos e seus tutores. \n\nAo entrar em nossa loja, os clientes são recebidos por uma equipe calorosa e atenciosa, pronta para auxiliá-los em todas as suas demandas. Oferecemos uma variedade de serviços personalizados, desde banho e tosa até cuidados de saúde e alimentação. Trabalhamos com produtos de alta qualidade, garantindo o bem-estar e a felicidade dos cãezinhos. \n\nNosso espaço é projetado pensando no conforto e na segurança dos pets, com áreas dedicadas para brincadeiras, descanso e interação social. Mantemos um ambiente limpo e higienizado para garantir a saúde de todos os frequentadores. \n\nAlém disso, estamos sempre atualizados com as melhores práticas de cuidado animal e buscamos constantemente aprimorar nossos serviços para atender às necessidades individuais de cada cachorro que passa por aqui. No nosso pet shop, cada cliente de quatro patas é tratado com carinho e respeito, fazendo com que eles se sintam em casa sempre que nos visitam.\n\n");
    }
}