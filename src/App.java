public class App {
    public static void main(String[] args) {
        CarregaDadosTxt dadosTxt = new CarregaDadosTxt("poa_temps.txt");
        Consultas consultas = new Consultas(dadosTxt.getRegistros(), reg -> reg.getAno() == 2000);
        
        consultas.alteraConsultaPadrao(reg->reg.getTemperaturaMedia() > 35.0);
        consultas.diasEmQue().forEach(System.out::println);
    }
}
