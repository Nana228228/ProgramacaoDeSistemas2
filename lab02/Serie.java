import java.util.List;
import java.util.ArrayList;

public class Serie extends Midia{
     List<Temporada> temporadas;

     public Serie(String titulo){
        super(titulo);
        this.temporadas = new ArrayList<Temporada>();
     }

     public void adicionarTemporada(Temporada temp){
        temporadas.add(temp);
    }


    @Override
    public long getDuracao(){
        long duracao = 0;
        for(int i = 0; i<temporadas.size(); i++){
            duracao += temporadas.get(i).getDuracao();
        }
        return duracao;
    }

    @Override
    public String info(){
        return super.info() + "Quantidade de temporadas: " + temporadas.size() + "Duração: " + getDuracao();
    }

}
