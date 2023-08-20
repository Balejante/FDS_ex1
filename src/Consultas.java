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

        //throw new UnsupportedOperationException("Unimplemented method 'todosDados'");
        return registros;
    }


    // pesquisa em registros por um RegistroDoTempo correspondente a dia, mes e ano
    // se existir, retorna o RegistroDoTempo. Se nao, retorna null
    @Override
    public RegistroDoTempo recupera(int dia, int mes, int ano) {

        //throw new UnsupportedOperationException("Unimplemented method 'recupera'");
        for (RegistroDoTempo registro : registros){
            if (registro.getDia()==dia && registro.getMes()==mes && registro.getAno()==ano){
                return registro;
            }
        }
        return null;

    }



    // pesquisa em registros por um RegistroDoTempo correspondente a dia, mes e ano
    // se existir, retorna o True. Se nao, retorna False
    @Override
    public boolean existe(int dia, int mes, int ano) {

        //throw new UnsupportedOperationException("Unimplemented method 'existe'");
        for (RegistroDoTempo registro : registros){
            if (registro.getDia()==dia && registro.getMes()==mes && registro.getAno()==ano){
                return true;
            }
        }
        return false;
    }


    //realiza uma pesquisa com Predicate(funcao lambda) na lista "Registros"
    //retorna uma Lista dos registros correspondentes ao Predicate
    @Override
    public List<RegistroDoTempo> diasEmQue(Predicate<RegistroDoTempo> predicate) {

        throw new UnsupportedOperationException("Unimplemented method 'diasEmQue'");


    }
}
