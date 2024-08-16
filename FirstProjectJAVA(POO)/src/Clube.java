public class Clube {
    String nome;
    int pontos;
    int saldoGols;

    // Construtor
    public Clube(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.saldoGols = 0;
    }

    // Métodos
    public void ganhar(int saldoGols) {
        this.pontos += 3; // valor dos pontos se o time ganhar .
        this.saldoGols += saldoGols;
    }

    public void empatar() {
        this.pontos += 1; // atribue 1 ponto se o time empatar.
    }

    public void perder(int saldoGols) {
        this.saldoGols -= saldoGols; //subtrai o valor de saldoGols se o time perder.
    }

    public String getNome() {
        return nome;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public int getSaldoGols() {
        return saldoGols;
    }
}
