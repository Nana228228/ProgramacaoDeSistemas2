public class CriterioPrecoMinimo implements CriterioBusca {
    //método testar retorna true se o produto tem um preço menor ou igual ao valor informado.
     public boolean testar(Produto p, String valor) {
        return p.getPreco() >= Double.parseDouble(valor);
    }
}