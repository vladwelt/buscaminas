import java.util.Scanner;
public class main{
    public static void main(String args[]){
        System.out.println("********* BUSCAMINAS *********");
        System.out.println("PRESIONE [S] PARA INICIAR");
        Scanner lector = new Scanner(System.in);
        String comando = lector.next();
        if( comando.equals("S") || 
            comando.equals("s") ){
                System.out.print("Dimension del campo: ");
                int t = lector.nextInt();
                Jugada jugada = new Jugada(t);
                String[][] tablero = jugada.dibujarCampo(t);
                Boolean[][] estados = jugada.inicializarEstado();
                jugada.imprimirTablero(tablero);
                System.out.print("NIVEL DE JUEGO: [1] FACIL [2] MEDIO [3] MUY DIFICIL: ");
                int nivel = lector.nextInt();
                jugada.colocarMinas(nivel);
                System.out.println("INICIANDO...");
                while(true){
                    System.out.print("X: ");
                    int x = lector.nextInt();
                    System.out.print("Y: ");
                    int y = lector.nextInt();
                    if(jugada.mina_detectada(x, y)){
                        tablero[x][y] = "X";
                        jugada.imprimirTablero(tablero);
                        break;
                    }
                    tablero[x][y] = "O";
                    jugada.imprimirTablero(tablero);
                }
        }else{
            System.out.println("PROGRAMA FINALIZADO");
        }
        /*Jugada j = new Jugada(10);
        Boolean[][] campo = j.inicializarEstado();
        j.colocarMinas(3);*/
    }
}