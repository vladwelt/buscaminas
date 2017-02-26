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
        }
    }
}