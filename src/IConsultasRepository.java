import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

interface IConsultasRepository {
    public Collection<RegistroDoTempo> todosDados();
    public void cadastra(RegistroDoTempo novoRegistro);
    public RegistroDoTempo recupera(int dia, int mes, int ano);
    public List<RegistroDoTempo> pesquisa(Predicate<RegistroDoTempo> condicao);
    public boolean existe(int dia, int mes, int ano);
    public void remove(int dia, int mes, int ano);
}