public class Posicao {
    
    public int x;
    public int y;

    public Posicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(Posicao p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}
