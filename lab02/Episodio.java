public class Episodio extends Midia{
    private long duracao;

    public Episodio(String titulo, long duracao){
        super(titulo);
        this.duracao  = duracao;
    }

    @Override
    public long getDuracao(){
        return this.duracao;
    }

    @Override
    public String info(){
        return "Título: " + super.info() + "Duração: " + getDuracao();
    }
}

