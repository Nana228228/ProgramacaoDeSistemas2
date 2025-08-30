public abstract class Midia{
    private String titulo;

    public Midia(String titulo){
        this.titulo = titulo;
    }


    public String info(){
        return "Titulo: "+ titulo;
    }

    public abstract long getDuracao();
}
