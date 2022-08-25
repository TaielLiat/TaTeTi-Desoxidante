import java.util.Scanner;

public class Tateti {
    Scanner lector = new Scanner(System.in);
    private boolean ganador = true;
    private char [][] tablero;
    private int contador = 0;
    private int columna;
    private int fila;
    private String jugador;
    private String nombre;
    private char simbolo;
    private char simboloMaquina;
    
    void CrearTablero(){
        tablero = new char[3][3];
        tablero[0][0] = '-';
        tablero[0][1] = '-';
        tablero[0][2] = '-';
        tablero[1][0] = '-';
        tablero[1][1] = '-';
        tablero[1][2] = '-';
        tablero[2][0] = '-';
        tablero[2][1] = '-';
        tablero[2][2] = '-';
    }

    void DibujarTablero(){
        for (int i=0; i<tablero.length;i++) {
            for (int j=0; j<tablero[i].length;j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("");
    }

    void VerificarDatos(){
        System.out.println("Elija su apodo");
        nombre = (lector.nextLine());
        boolean creado;
        do {
            System.out.println("Seleccione el símbolo que quiere utilizar: [X] o [O]");
            char respuesta =  (lector.nextLine()).charAt(0);
            if (respuesta == 'X'){
                simbolo = respuesta;
                simboloMaquina = 'O';
                creado = true;
            } else if (respuesta == 'O'){
                simbolo = respuesta;
                simboloMaquina = 'X';
                creado = true;
            } else {
                System.out.println("Los únicos símbolos disponibles son [X] o [O], intentalo nuevamente.");
                creado = false;
            }
        } while (creado == false);
    }

    void InicializarJuego(){
        while(ganador){
            if (contador % 2 == 0){
                jugador = nombre;
                System.out.println("Turno de " + nombre);
                System.out.println("Ingresar fila de la jugada");
                fila = Integer.parseInt (lector.nextLine());
                System.out.println ("Ingresar columna de la jugada");
                columna = Integer.parseInt (lector.nextLine());
            } else { 
                jugador = "Bot anti petes";
                JugadaMaquina();
            }
            VerificarJugada(); 
            VerificarGanador();
        }
    }

    void JugadaMaquina(){
        fila = (int) (Math.random() * 3);
        columna = (int) (Math.random() * 3);  
    }

    void VerificarJugada(){
        if (jugador == nombre){
            if(tablero[fila][columna]=='-'){
                tablero[fila][columna] = simbolo;
                contador++;
                DibujarTablero();
            } else {
                System.out.println ("La posicion ya se encuentra ocupada!");
            }
        } else {
            if(tablero[fila][columna]=='-'){
                tablero[fila][columna] = simboloMaquina;
                contador++;
                System.out.println("Turno de Bot anti petes");
                System.out.println("(Y) " + fila + ", (X) " + columna);
                DibujarTablero();
            }
        }
    }

    void VerificarGanador(){
        ///////////////////////////////////columnas///////////////////////////////////
        if ((tablero[0][0]  == tablero[0][1]) && (tablero[0][1] == tablero[0][2])) { 
            if (tablero[0][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][0] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if ((tablero[1][0]  == tablero[1][1]) && (tablero[1][1] == tablero[1][2])) { 
            if (tablero[1][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[1][0] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if ((tablero[2][0]  == tablero[2][1]) && (tablero[2][1] == tablero[2][2])) { 
            if (tablero[2][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[2][0] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        ///////////////////////////////////filas///////////////////////////////////
        if ((tablero[0][0]  == tablero[1][0]) && (tablero[1][0] == tablero[2][0])) { 
            if (tablero[0][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][0] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if ((tablero[0][1]  == tablero[1][1]) && (tablero[1][1] == tablero[2][1])) { 
            if (tablero[0][1] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][1] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if ((tablero[0][2]  == tablero[1][2]) && (tablero[1][2] == tablero[2][2])) { 
            if (tablero[0][2] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][2] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        /////////////////////////////////// diagonales ///////////////////////////////////
        if ((tablero[0][0]  == tablero[1][1]) && (tablero[1][1] == tablero[2][2])) { 
            if (tablero[0][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][0] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if ((tablero[2][0]  == tablero[1][1]) && (tablero[1][1] == tablero[0][2])) { 
            if (tablero[2][0] == simbolo){
                System.out.println ("Fin del juego, el ganador es " + nombre);
                VerificarReintento();
            } else if (tablero[0][2] == simboloMaquina){
                System.out.println ("Fin del juego, el ganador es Bot anti petes");
                VerificarReintento();
            }
        }
        if (contador == 9 && ganador == true) {
            System.out.println ("Fin del juego, empate");
            VerificarReintento();
        }
    }

    void VerificarReintento(){
        System.out.println("¿Jugar nuevamente?");
        System.out.println("Si / No");
        String continuar = lector.nextLine();
        if(continuar.equals("Si") || continuar.equals("si")){
            contador = 0;
            CrearTablero();
            System.out.println("Reintentando... \n");
        } else if (continuar.equals("No") || continuar.equals("no")){
            ganador = false;
            System.out.println("¡Gracias por jugar! \n");
        } else {
            ganador =  false;
            System.out.println("Bobo \n");
        }
    }   

    void Introduccion(){
        System.out.println( "   TA TE TI Desoxidante - Taiel Liat Cleiman");
        System.out.println("-------------------Cómo jugar-------------------\n ");
        System.out.println("En esta versión vas a jugar contra la máquina");
        System.out.println("El objetivo está en completar una linea de la cuadrilla de 3x3.");
        System.out.println("Pudiendo ésta ser horizontal, vertical o diagonal con el símbolo que hayas elegido entre [X] y [O]).");
        System.out.println("Primero jugas vos, después la máquina, y así consecutivamente hasta conseguir un ganador o llegar a un empate completando la cuadrilla.");
        System.out.println("El sistema te va a pedir una posición en la fila, correspondiendo al eje Y (vertical) de la cuadrilla,");
        System.out.println("la cual va de 0 a 2, 0 siendo la esquina superior izquierda y 2 la esquina inferior izquierda.");
        System.out.println("A continuacion, similar a la fila, se te consultará por la columna, que corresponde al eje X (horizontal),");    
        System.out.println("siendo 0 la casilla del lado izquierdo y 2 la del lado derecho.\n");
        System.out.println("Ahora si, con todo aclarado:\n");
    }
}

