import java.util.Collection;

interface IConsultasRepository {
    public Collection<RegistroDoTempo> todosDados();

    public RegistroDoTempo recupera(int dia, int mes, int ano);

    public boolean existe(int dia, int mes, int ano);
}