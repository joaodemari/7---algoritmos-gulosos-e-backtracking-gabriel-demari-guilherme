import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        // ArrayList<Float> moedas = new ArrayList<Float>();
        // moedas.add(0.5f);
        // moedas.add(0.10f);
        // moedas.add(0.2f);
        // moedas.add(1.0f);
        // moedas.add(0.05f);
        // ArrayList<Float> resultado = troco(2.89f, moedas);

        // if(resultado == null) {
        //     System.out.println("Não é possível dar o troco com as moedas disponíveis");
        //     return;
        // }
        // System.out.println(resultado);
        

        // ArrayList<Intervalo> intervalos = new ArrayList<Intervalo>();
        // intervalos.add(new Intervalo(2, 4));
        // intervalos.add(new Intervalo(4, 5));
        // intervalos.add(new Intervalo(1, 6));
        // intervalos.add(new Intervalo(6, 7));
        // intervalos.add(new Intervalo(4, 8));
        // intervalos.add(new Intervalo(6, 9));
        // intervalos.add(new Intervalo(7, 10));
        // intervalos.add(new Intervalo(9, 11));
        // intervalos.add(new Intervalo(9, 12));        
        // intervalos.add(new Intervalo(3, 13));
        // intervalos.add(new Intervalo(13, 14));

        // ArrayList<Intervalo> resultado = SDM_GULOSO(intervalos);
        // System.out.println(resultado);
        // System.out.println(resultado.size());

        eniRainhas(10);
        

    }

    public static ArrayList<Float> troco(float troco, ArrayList<Float> moedas) {
        
        ArrayList<Float> resultado = new ArrayList<>();
        
        moedas.sort((a, b) -> {
            return a > b ? -1 : a < b ? 1 : 0;
        });
        
        for (int i = 0; i < moedas.size(); i++) {
            resultado.add((float) Math.floor(troco / moedas.get(i)));
            troco = troco % moedas.get(i);
        }
        
        return troco == 0 ? resultado : null;
    }

    public static ArrayList<Intervalo> SDM_GULOSO(ArrayList<Intervalo> intervalos) {
        ArrayList<Intervalo> X = new ArrayList<>();
        intervalos.set(0, new Intervalo(Integer.MAX_VALUE, Integer.MIN_VALUE));
        int i = 0;
        for(int k = 1; k < intervalos.size(); k++) {
            if(intervalos.get(k).s > intervalos.get(i).f) {
                X.add(intervalos.get(k));
                i = k;
            }
        }

        return X;
    }

    public static ArrayList<Posicao> eniRainhas(int n){
        if(n <= 2) return null;

       ArrayList<Posicao> MelhoresRainhas = new ArrayList<>();

        for(int l = 0; l < n; l++){
            for(int k = 0; k< n; k++){
                ArrayList<Posicao> rainhas = new ArrayList<>();
                Posicao initialP = new Posicao(l, k);
                rainhas.add(initialP);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        Posicao p = new Posicao(i, j);
                        if(!rainhasNaRedondeza(rainhas, p)) {
                            rainhas.add(p);
                        }
                    }
                }
                if(rainhas.size() > MelhoresRainhas.size())
                    MelhoresRainhas = rainhas;
            }
        }

        System.out.println(MelhoresRainhas);

        return MelhoresRainhas;
    }

    private static boolean rainhasNaRedondeza(ArrayList<Posicao> rainhas, Posicao p1) {
        for (Posicao p2 : rainhas) {
            if (rainhaNaDiagonal(p1, p2)) return true;
            if (rainhaNaLinha(p1, p2)) return true;
            if (rainhaNaColuna(p1, p2)) return true;
        }
        return false;
    }

    private static boolean rainhaNaDiagonal(Posicao p1, Posicao p2) {
        return Math.abs(p1.x - p2.x) == Math.abs(p1.y - p2.y);
    }

    private static boolean rainhaNaLinha(Posicao p1, Posicao p2) {
        return p1.x == p2.x;
    }

    private static boolean rainhaNaColuna(Posicao p1, Posicao p2) {
        return p1.y == p2.y;
    }

}