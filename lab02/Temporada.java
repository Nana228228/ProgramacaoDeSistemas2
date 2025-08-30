import java.util.List;
import java.util.ArrayList;

public class Temporada extends Midia{

    List<Episodio> episodios;
    
    public Temporada(int num){
    super("Número: " + num);
    this.episodios = new ArrayList<Episodio>();
    }

    public void adicionarEpisodio(Episodio ep){
        episodios.add(ep);
    }

    @Override
    public long getDuracao(){
        long duracao = 0;
        for(int i = 0; i<episodios.size(); i++){
            duracao += episodios.get(i).getDuracao();
        }
        return duracao;
    }

    @Override
    public String info(){
        return "Número da Temporada: " + super.info() + "Duração: " + getDuracao();
    }
}


