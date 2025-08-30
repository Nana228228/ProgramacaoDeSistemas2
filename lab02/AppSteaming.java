import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AppStreaming{
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        List<Midia> midias = new ArrayList<Midia>();

        do {
            System.out.println("--- MENU DE OPÇÕES ---");
            System.out.println("(1) Adicionar novo Filme.");
            System.out.println("(2) Adicionar nova Série.");
            System.out.println("(3) Listar todas as mídias.");
            System.out.println("(4) Sair.");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine(); // Adicionado para consumir a nova linha após nextInt()

                switch (opcao) {
                    case 1:
                        System.out.println("\nVocê escolheu: Adicionar novo Filme.\n");
                        
                        System.out.println("Qual o título do filme?");
                        String tituloDoFilme = entrada.nextLine();
                        System.out.println("E qual a duração do filme?");
                        long duracaoDoFilme = entrada.nextLong();
                        entrada.nextLine(); // Adicionado para consumir a nova linha após nextLong()
                        Filme filme = new Filme(tituloDoFilme, duracaoDoFilme);
                        midias.add(filme);
                        break;

                    case 2:
                        System.out.println("\nVocê escolheu: Adicionar nova Série.\n");
                        //perguntar o título da série
                        System.out.println("Qual o título da Série?");
                        String titulo = entrada.nextLine();
                        //criar uma instância da Serie
                        Serie serie = new Serie(titulo);
                        midias.add(serie);
                        //adicionar duas temporadas à série
                        Temporada temp1 = new Temporada(1);
                        serie.adicionarTemporada(temp1);
                        Temporada temp2 = new Temporada(2);
                        serie.adicionarTemporada(temp2);

                        System.out.println("Qual o título do Ep 1 Temporada 1?");
                        String tituloEp1Temp1 = entrada.nextLine();
                        System.out.println("E qual a duração do episódio?");
                        long duracaoEp1Temp1 = entrada.nextLong();
                        entrada.nextLine(); // Adicionado para consumir a nova linha após nextLong()
                        Episodio epTemp1 = new Episodio(tituloEp1Temp1, duracaoEp1Temp1);
                        temp1.adicionarEpisodio(epTemp1);

                        System.out.println("Qual o título do Ep 2 Temporada 1?");
                        String tituloEp2Temp1 = entrada.nextLine();
                        System.out.println("E qual a duração do episódio?");
                        long duracaoEp2Temp1 = entrada.nextLong();
                        entrada.nextLine(); // Adicionado para consumir a nova linha após nextLong()
                        Episodio ep2Temp1 = new Episodio(tituloEp2Temp1, duracaoEp2Temp1);
                        temp1.adicionarEpisodio(ep2Temp1);

                        System.out.println("Qual o título do Ep 1 Temporada 2?");
                        String tituloEp1Temp2 = entrada.nextLine();
                        System.out.println("E qual a duração do episódio?");
                        long duracaoEp1Temp2 = entrada.nextLong();
                        entrada.nextLine(); // Adicionado para consumir a nova linha após nextLong()
                        Episodio ep1Temp2 = new Episodio(tituloEp1Temp2, duracaoEp1Temp2);
                        temp1.adicionarEpisodio(ep1Temp2);

                        System.out.println("Qual o título do Ep 2 Temporada 2?");
                        String tituloEp2Temp2 = entrada.nextLine();
                        System.out.println("E qual a duração do episódio?");
                        long duracaoEp2Temp2 = entrada.nextLong();
                        entrada.nextLine(); // Adicionado para consumir a nova linha após nextLong()
                        Episodio ep2Temp2 = new Episodio(tituloEp2Temp2, duracaoEp2Temp2);
                        temp1.adicionarEpisodio(ep2Temp2);

                        break;

                    case 3:
                        System.out.println("\nVocê escolheu: Listar todas as mídias.\n");
                        for(int i = 0; i<midias.size(); i++){
                            System.out.println(midias.get(i).info());
                        }
                        break;

                    case 4:
                        System.out.println("\nSaindo do programa. Até logo!");
                        break;
                    default:
                        System.out.println("\nOpção inválida. Por favor, escolha uma opção entre 1 e 4.\n");
                }

        } while (opcao != 4);
    
    }
}
