public class App {
    public static void main(String[] args) {
        CarregaDadosTxt dadosTxt = new CarregaDadosTxt("poa_temps.txt");
        Consultas consultas = new Consultas(dadosTxt.getRegistros(), reg -> reg.getAno() == 2000);
        
        System.out.println("\n\nConsultando registros com Temperatura Maxima acima de 33 em 2015\n");
        consultas.pesquisa(reg->reg.getTempMaxima() > 33.0 && reg.getAno() == 2015).forEach(System.out::println);
        
        System.out.println("\n\nConsultando datas registradas do ano 2000\n");
        consultas.diasEmQue().forEach(System.out::println);

        System.out.println("\n\nConsultando datas com Temperatura Media acima de 30\n");
        consultas.alteraConsultaPadrao(reg->reg.getTemperaturaMedia() > 30.0);
        consultas.diasEmQue().forEach(System.out::println);

    }
}
