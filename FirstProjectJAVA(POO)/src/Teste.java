import incrementos.asciiArt;

public class Teste{
    public static void main(String[] args) {
        // Criando os clubes
        Clube[] clubes = new Clube[4];
        clubes[0] = new Clube("Icasa");
        clubes[1] = new Clube("Xique-Xique");
        clubes[2] = new Clube("Guarani");
        clubes[3] = new Clube("BalsasFC");
    
        // Criando o campeonato
        Campeonato campeonato = new Campeonato(clubes);

        asciiArt asciiArt = new asciiArt();

        System.out.println(asciiArt.getImprimirCampeonato()); //get pro package incremento
    
        // Jogando o campeonato
        campeonato.jogarCampeonato();
    
        // Exibindo a classificação final
        System.out.println("\nClassificação Final:");
        System.out.println(campeonato.getClassificacao());

        System.out.println("[]=====================================[]");
        System.out.println(asciiArt.getImprimirTrofeu());
        
        // Exibindo o campeão
        System.out.println("Parabéns ao " + campeonato.getCampeao().getNome() + ", o grande campeão!");
        System.out.println("[]=====================================[]");
    }

}

