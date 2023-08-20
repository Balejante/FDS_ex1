import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Consultas implements IConsultasRepository {
    private List<RegistroDoTempo> registros;
    private Predicate<RegistroDoTempo> condicao;

    public Consultas(List<RegistroDoTempo> registrosDados, Predicate<RegistroDoTempo> consultaInicial) {
        registros = registrosDados;
        this.condicao = consultaInicial;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros) {
        return registros
                .stream()
                .filter(r -> r.getPrecipitacao() > milimetros)
                .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
                .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = registros
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", "
                + registro.getPrecipitacao();
        return resp;
    }

    // retorna a lista "registros"
    @Override
    public Collection<RegistroDoTempo> todosDados() {
        return registros;
    }

    @Override
    public void cadastra(RegistroDoTempo novoRegistro){
        if(!(registros.contains(novoRegistro))){
            registros.add(novoRegistro);
        }
    }

    // pesquisa em registros por um RegistroDoTempo correspondente a dia, mes e ano
    // se existir, retorna o RegistroDoTempo. Se nao, retorna null
    @Override
    public RegistroDoTempo recupera(int dia, int mes, int ano) {
        return registros.stream()
                        .filter(reg->reg.getDia() == dia && reg.getMes() == mes && reg.getAno() == ano)
                        .findFirst()
                        .orElse(null);   
    }

    @Override
    public List<RegistroDoTempo> pesquisa(Predicate<RegistroDoTempo> condicao){
        return registros.stream()
                        .filter(condicao)
                        .toList();
    }

    // pesquisa em registros por um RegistroDoTempo correspondente a dia, mes e ano
    // se existir, retorna o True. Se nao, retorna False
    @Override
    public boolean existe(int dia, int mes, int ano) {
        return recupera(dia, mes, ano) != null;
    }

    @Override
    public void remove(int dia, int mes, int ano){
        RegistroDoTempo aux = recupera(dia, mes, ano);
        if(aux != null){registros.remove(aux);}
    }

    
    // realiza uma pesquisa com Predicate(funcao lambda) na lista "Registros"
    // retorna uma Lista dos registros correspondentes ao Predicate

    public List<Data> diasEmQue() {
        return registros.stream()
                        .filter(condicao)
                        .map(reg -> new Data(reg.getDia(), reg.getMes(), reg.getAno()))
                        .toList();
    }

    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> novaCondicao) {
        this.condicao = novaCondicao;
    }
}
