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
    public boolean mina_detectada(int x, int y){
        boolean bandera = false;
        if(estado_casillas[x][y])
            bandera = true;
        return bandera;
    }
    public String[][] dibujarCampo(int t){
        String[][] campo = new String[t][t];
        for( int i = 0; i < t; i++ ){
            for( int j = 0; j < t; j++){
                campo[i][j] = " -";
            }
        }
        return campo;
    }
    public void imprimirTablero(String[][] campo){
        int dim = t.getTamanio();
        for( int i = 0; i < dim; i++ ){
            for( int j = 0; j < dim; j++ ){
                System.out.print(campo[i][j]+" ");
            }
            System.out.println();
        }
    }
}