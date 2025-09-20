package ps2.titular_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static ps2.titular_app.ES.*;
import java.util.Optional;

@SpringBootApplication
public class TitularAppApplication implements CommandLineRunner {

    @Autowired
    private TitularRepo titularrepo;

    public static void main(String[] args) {
        SpringApplication.run(TitularAppApplication.class, args);
    }

// Métodos
    // 1 - Ler tudo
    public void lerTudo() {
        Iterable<Titular> titulares = titularrepo.findAll();
        System.out.println("\n--- Lista de Titulares ---");
        for (Titular t : titulares) {
            System.out.println(t);
        }
        System.out.println("--------------------------");
    }

    // 2 - Buscar um titular específico pelo número
    public void buscarPorId() {
        long id = Integer.parseInt(input("Digite o ID do titular a ser buscado: "));
        Optional<Titular> titularOptional = titularrepo.findById(id);
        if (titularOptional.isPresent()) {
            System.out.println("\n--- Titular Encontrado ---");
            System.out.println(titularOptional.get());
        } else {
            System.out.println("Titular com o ID " + id + " não encontrado.");
        }
    }

    // 3 - Criar um novo titular
    public void criar() {
        Titular t = new Titular();
        String nome = input("Nome do novo titular: ");
        t.setNome(nome);
        String cpf = input("CPF do novo titular: ");
        t.setCpf(cpf);
        titularrepo.save(t);
        System.out.println("Titular criado com o id " + t.getId());
    }

    // 4 - Alterar os dados do titular
    public void atualizar() {
        long id = Integer.parseInt(input("Digite o ID do titular a ser alterado: "));
        Optional<Titular> titularOptional = titularrepo.findById(id);
        if (titularOptional.isPresent()) {
            Titular t = titularOptional.get();
            String novoNome = input("Digite o novo nome (atual: " + t.getNome() + "): ");
            t.setNome(novoNome);
            String novoCpf = input("Digite o novo CPF (atual: " + t.getCpf() + "): ");
            t.setCpf(novoCpf);
            titularrepo.save(t);
            System.out.println("Titular com ID " + id + " atualizado com sucesso.");
        } else {
            System.out.println("Titular com o ID " + id + " não encontrado.");
        }
    }

    // 5 - Apagar um titular
    public void deletar() {
        long id = Integer.parseInt(input("Digite o ID do titular a ser apagado: "));
        if (titularrepo.existsById(id)) {
            titularrepo.deleteById(id);
            System.out.println("Titular com ID " + id + " apagado com sucesso.");
        } else {
            System.out.println("Titular com o ID " + id + " não encontrado.");
        }
    }

// Execução
    @Override
    public void run(String... args) throws Exception {
        System.out.println("# GERENCIADOR DE TITULARES!");
        boolean sair = false;
        String menu = "\nEscolha uma opção: ";
        menu += "\n(1) Listar todos os titulares";
        menu += "\n(2) Buscar um titular específico pelo ID";
        menu += "\n(3) Criar um novo titular";
        menu += "\n(4) Alterar os dados do titular";
        menu += "\n(5) Apagar um titular";
        menu += "\n(0) Sair \n";

        while (!sair) {
            String op = input(menu);
            switch (op) {
                case "1":
                    lerTudo();
                    break;
                case "2":
                    buscarPorId();
                    break;
                case "3":
                    criar();
                    break;
                case "4":
                    atualizar();
                    break;
                case "5":
                    deletar();
                    break;
                case "0":
                    System.out.println("Saindo do programa...");
                    sair = true;
                    break;
                default:
                    print("Opção inválida!");
            }
        }
    }
}