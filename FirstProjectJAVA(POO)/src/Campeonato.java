import java.util.Random;

public class Campeonato {
    Clube[] clubes;

    // Construtor para atribuir o array de clubes ao 'clubes' da classe.
    public Campeonato(Clube[] clubes) {
        this.clubes = clubes;
    }

    // Método para jogar o campeonato
    public void jogarCampeonato() { 
        for (int i = 0; i < clubes.length; i++) {
            for (int j = i + 1; j < clubes.length; j++) {
                // validar para que os times joguem entre si sem faltar nenhum
                System.out.println("<--------------------------> \n");
                jogarPartida(clubes[i], clubes[j]);
                jogarPartida(clubes[j], clubes[i]);

            } //o .length é pra pecorrer o tamanho do array
        }
    }

    // Método auxiliar para jogar uma partida
    private void jogarPartida(Clube t1, Clube t2) { //simular a partida de dois times t1 e t2.
        Random random = new Random();
        int golsTime1 = random.nextInt(6);
        int golsTime2 = random.nextInt(6);
        //importei o random do java pra gerar aleatoriamente os gols dos times.
        System.out.println(t1.nome + " " + golsTime1 + " x " + golsTime2 + " " + t2.nome);

        if (golsTime1 > golsTime2) {
            t1.ganhar(golsTime1 - golsTime2);
            t2.perder(golsTime1 - golsTime2);
            System.out.println("| O time vencedor foi " + " "+t1.nome + "\n");

        } else if (golsTime1 < golsTime2) {
            t2.ganhar(golsTime2 - golsTime1);
            t1.perder(golsTime2 - golsTime1);
            System.out.println("| O time vencedor foi " + " "+t2.nome + "\n");

        } else {
            t1.empatar();
            t2.empatar();
            System.out.println("| EMPATE!  " + "\n");
        }
    }

    // Método para obter a classificação
    public String getClassificacao() {
        String classificacao = "";
    
        // Ordena os clubes por pontos (e saldo de gols para desempate)
        for (int i = 0; i < clubes.length - 1; i++) {
            for (int j = i + 1; j < clubes.length; j++) {
                if (clubes[i].pontos < clubes[j].pontos) { 
                    // Troca os clubes de lugar
                    Clube aux = clubes[i];
                    clubes[i] = clubes[j];
                    clubes[j] = aux;
                }
                else if (clubes[i].pontos == clubes[j].pontos && clubes[i].saldoGols < clubes[j].saldoGols) { //validação em caso de empate utiliza o getSaldoGols.
                    Clube aux = clubes[i];
                    clubes[i] = clubes[j];
                    clubes[j] = aux;
                }
                }
            }
        
    
        // Montei a string de classificação usando concatenação pra ficarem alinhados.
        for (Clube clube : clubes) {
            classificacao += "|" + clube.nome
                            + "\n Pontos: " + clube.pontos +"\n"
                            + " Saldo de Gols: " + clube.saldoGols +"\n"
                            + "\n";
        }
    
        return classificacao;
    }

    // Método para obter o campeão
    public Clube getCampeao() {
        return clubes[0]; // Após ordenação dos times, o time que tiver na posição [0] é o campeão GOOOOOOOL!
    }
}
