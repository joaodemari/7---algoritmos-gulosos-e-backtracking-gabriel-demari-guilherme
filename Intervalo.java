public class Intervalo {
    
    public int s;
    public int f;

    public Intervalo(int s, int f) {
        this.s = s;
        this.f = f;
    }

    @Override
    public String toString() {
        return "S: " + s + " F: " + f;
    }
}
