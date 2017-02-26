public class Jugada{
    private Tablero t;
    private Mina[] mina;
    private Boolean[][] estado_casillas;
    public Jugada(int dimension_campo){
         t = new Tablero(dimension_campo);
    }
    public Boolean[][] inicializarEstado(){
        int tam = t.getTamanio();
        estado_casillas = new Boolean[tam][tam];
        for(int i=0; i<tam;i++){
            for(int j=0;j<tam;j++){
                estado_casillas[i][j] = false;    
            }
        }
        return estado_casillas;
    }
    public void colocarMinas( int nivel ){
        int dim = t.getTamanio();
        int numero_casillas = (int)(Math.pow(dim,2));
        int numero_minas = 0;
        switch( nivel ){
            case 1:
                numero_minas = (int)(0.35 * numero_casillas);
                break;
            case 2:
                numero_minas = (int)(0.50 * numero_casillas);
                break;
            case 3:
                numero_minas = (int)(0.75 * numero_casillas);
                break;
            default:
                System.out.println("Nivel no existente. Terminando Programa...");
                System.exit(1);
                break;
        }
        //System.out.println(numero_minas);
        mina = new Mina[numero_minas];
        for( int i = 0; i < mina.length; i++ ){
            int x = (int)( Math.random()*(dim - 1) + 1 );
            int y = (int)( Math.random()*(dim - 1) + 1 );
            mina[i] = new Mina(x, y);
            estado_casillas[x][y] = true; 
        }
    }
}