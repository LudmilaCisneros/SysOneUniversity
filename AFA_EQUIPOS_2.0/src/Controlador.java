import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    public static void menuQuerys(List<Equipos> listaEquipos){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉");
            System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\nＢＩＥＮＶＥＮＩＤＯ\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\n");
            System.out.println("╔═══════╗   ╔════════╗   ╔═══════╗");
            System.out.println("①|INSERT    ②|SELECT     ③|SALIR");
            System.out.println("╚═══════╝   ╚════════╝   ╚═══════╝");
            System.out.println("\nIngrese la opción: ↓ ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: System.out.println("\n•◦ •° °• De cuál equipo? •◦ •° °•\n");
                        seleccionandoCualEquipo(listaEquipos,"INSERT");
                        break;

                case 2: System.out.println("\nSELECT\n");
                        MostrarEquiposBD(Equipos.select());
                        break;

                case 3: break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        }while(opcion != 3);

    }

    /** Imprime los equipos disponibles para hacer querys,contiene la lógica para seleccionar sobre cual equipo se gestionará
     * y llama al método encargado de hacer la query
     * @param list
     * @param query
     */
    public static void seleccionandoCualEquipo(List<Equipos> list, String query){
        Scanner sc = new Scanner(System.in);
        int opcionInt;
        String opcionStr;
        List<Equipos> aux = new ArrayList<>();

        if(query.equals("INSERT")){
            for (int i=0;i<list.size();i++){
                System.out.print(i+1 +") ");
                list.get(i).printNombreEquipo();
                System.out.print(". \n");
            }
            System.out.println("\nIngrese la opcion: ↓");
            opcionStr = sc.next();
            if (isNumeric(opcionStr)){
                opcionInt = Integer.parseInt(opcionStr);
                list.get(opcionInt-1).insert();
            }
        }
        /*
        if(query.equals("DELETE")){
        }*/

    }

    public static void MostrarEquiposBD(List<Equipos> listaEq){
        for (Equipos eq:listaEq) {
            System.out.println(eq.toString());
            System.out.println("\n");
        }
    }
    /**Verifica que el Str sea un entero
     * @param str
     * @return aux
     */
    public static boolean isNumeric(String str){
        int aux = -1;
        try{
            aux = Integer.parseInt(str);
            if(aux != -1)
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
