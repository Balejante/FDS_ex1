import java.util.Collection;
import java.util.function.Predicate;

interface IConsultasRepository{
    public Collection<RegistroDoTempo> todosDados();
    public RegistroDoTempo recupera(int dia, int mes, int ano);
    public boolean existe (int dia, int mes, int ano);
    public Collection<RegistroDoTempo> diasEmQue(Predicate<RegistroDoTempo> predicate);
}