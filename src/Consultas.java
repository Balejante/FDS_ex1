import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Consultas implements IConsultasRepository{
    private List<RegistroDoTempo> registros;

    public Consultas(List<RegistroDoTempo> registrosDados){
        registros = registrosDados;
    }

   

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }


    // retorna a lista "registros"
    @Override
    public Collection<RegistroDoTempo> todosDados() {
        return registros;
    }

    // retorna a lista "registros"
    @Override
    public RegistroDoTempo recupera(int dia, int mes, int ano) {
        return registros.stream()
                        .filter(reg->reg.getDia() == dia && reg.getMes() == mes && reg.getAno() == ano)
                        .findFirst()
                        .orElse(null);   
    }



    // pesquisa em registros por um RegistroDoTempo correspondente a dia, mes e ano
    // se existir, retorna o True. Se nao, retorna False
    @Override
    public boolean existe(int dia, int mes, int ano) {
        return recupera(dia, mes, ano) != null;
    }


    //realiza uma pesquisa com Predicate(funcao lambda) na lista "Registros"
    //retorna uma Lista dos registros correspondentes ao Predicate
    
    public List<RegistroDoTempo> diasEmQue(Predicate<RegistroDoTempo> predicate) {

        throw new UnsupportedOperationException("Unimplemented method 'diasEmQue'");
    }


}
