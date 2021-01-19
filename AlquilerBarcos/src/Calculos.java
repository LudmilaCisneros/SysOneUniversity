import java.util.ArrayList;
import java.util.List;

public  class  Calculos {

    /**
     * @brief Encuentra y muestra el alquiler mas caro
     * @param listaAlquileres
     */
    public static void mayorAlquiler(ArrayList<Alquiler> listaAlquileres){
        long mayorAlquiler = 0;
        int indexMax = 0;

        for (int i=0;i<listaAlquileres.size();i++){
            if(listaAlquileres.get(i).getValorFijoAlquilerCte() > mayorAlquiler){
                mayorAlquiler = listaAlquileres.get(i).getValorFijoAlquilerCte();
                indexMax = i;
            }
        }
        System.out.println(" ");
        System.out.println("El alquiler con mayor valor es: ");
        Alquiler.printAlquiler(listaAlquileres.get(indexMax));
    }

    /**
     * @brief Encuentra y muestra el alquiler mas barato
     * @param listaAlquileres
     */
    public static void menorAlquiler(ArrayList<Alquiler> listaAlquileres){
        long menorAlquiler = Long.MAX_VALUE;
        int indexMin = 0;

        for (int i=0;i<listaAlquileres.size();i++){

            if(listaAlquileres.get(i).getValorFijoAlquilerCte() < menorAlquiler){
                menorAlquiler = listaAlquileres.get(i).getValorFijoAlquilerCte();
                indexMin = i;
            }
        }
        System.out.println("El alquiler con menor valor es: ");
        Alquiler.printAlquiler(listaAlquileres.get(indexMin));
    }

    /**
     * @brief Metodo para printear los promedios mensuales de los alquileres
     * @param acumuladores
     * @param contadores
     */
    private static void printearPromediosMensuales(int[] acumuladores, int[] contadores){
        System.out.println("Promedios mensuales: ");
        if(acumuladores[0] != 0){ System.out.println("Enero: "+ acumuladores[0] / contadores[0]); }
        if(acumuladores[1] != 0){ System.out.println("Febrero: "+ acumuladores[1] / contadores[1]); }
        if(acumuladores[2] != 0){ System.out.println("Marzo: "+ acumuladores[2] / contadores[2]); }
        if(acumuladores[3] != 0){ System.out.println("Abril: "+ acumuladores[3] / contadores[3]); }
        if(acumuladores[4] != 0){ System.out.println("Mayo: "+ acumuladores[4] / contadores[4]); }
        if(acumuladores[5] != 0){ System.out.println("Junio: "+ acumuladores[5] / contadores[5]); }
        if(acumuladores[6] != 0){ System.out.println("Julio: "+ acumuladores[6] / contadores[6]); }
        if(acumuladores[7] != 0){ System.out.println("Agosto: "+ acumuladores[7] / contadores[7]); }
        if(acumuladores[8] != 0){ System.out.println("Septiembre: "+ acumuladores[8] / contadores[8]); }
        if(acumuladores[9] != 0){ System.out.println("Octubre: "+ acumuladores[9] / contadores[9]); }
        if(acumuladores[10] != 0){ System.out.println("Noviembre: "+ acumuladores[10] / contadores[10]); }
        if(acumuladores[11] != 0){ System.out.println("Diciembre: "+ acumuladores[11] / contadores[11]); }
    }
    /**
     * @brief Calcula el promedio mensual del valor de los alquileres
     * @param listaAlquileres
     */
    public static void promedioMensual(ArrayList<Alquiler> listaAlquileres){
        int valorAlquiler;
        int[] contadores = {0,0,0,0,0,0,0,0,0,0,0,0};
        int[] acumuladores = {0,0,0,0,0,0,0,0,0,0,0,0};

        for (Alquiler alq:listaAlquileres) {
            valorAlquiler = (int) alq.getValorFijoAlquilerCte();
            switch (alq.getMonthFechaInicial()){
                case 1: acumuladores[0] += valorAlquiler; //ENERO
                    contadores[0]++;
                    break;
                case 2: acumuladores[1] += valorAlquiler; //FEB
                    contadores[1]++;
                    break;
                case 3: acumuladores[2] += valorAlquiler; //MAR
                    contadores[2]++;
                    break;
                case 4: acumuladores[3] += valorAlquiler; //ABR
                    contadores[3]++;
                    break;
                case 5: acumuladores[4] += valorAlquiler; //MAY
                    contadores[4]++;
                    break;
                case 6: acumuladores[5] += valorAlquiler; //JUN
                    contadores[5]++;
                    break;
                case 7: acumuladores[6] += valorAlquiler; //JUL
                    contadores[6]++;
                    break;
                case 8: acumuladores[7] += valorAlquiler; //AGO
                    contadores[7]++;
                    break;
                case 9: acumuladores[8] += valorAlquiler; // SEP
                    contadores[8]++;
                    break;
                case 10: acumuladores[9] += valorAlquiler; // OCT
                    contadores[9]++;
                    break;
                case 11: acumuladores[10] += valorAlquiler; //NOV
                    contadores[10]++;
                    break;
                case 12: acumuladores[11] += valorAlquiler; //DIC
                    contadores[11]++;
                    break;
            }
        }
        printearPromediosMensuales(acumuladores,contadores);
    }

    /**
     * @brief Calcula el promedio anual del valor de los alquileres
     * @param listaAlquileres
     */
    public static void promedioAnual(ArrayList<Alquiler> listaAlquileres){
        int acumulador = 0;
        int contadorAlq = 0;

        for (Alquiler alq : listaAlquileres) {
            acumulador += alq.getValorFijoAlquilerCte();
            contadorAlq++;
        }
        System.out.println("El promedio anual es: "+ (acumulador/contadorAlq));
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''");
    }
}
