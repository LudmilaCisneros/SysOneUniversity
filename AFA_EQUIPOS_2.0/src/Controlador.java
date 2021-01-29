import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    public static void menuQuerys(List<Equipos> listaEquipos){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int opcionInt;
        System.out.println("┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉");
        System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\nＢＩＥＮＶＥＮＩＤＯ\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\n");
        System.out.println("╔═══════╗   ╔════════╗");
        System.out.println("①|INSERT    ②|SELECT");
        System.out.println("╚═══════╝   ╚════════╝");
        System.out.println("\nIngrese la opción: ↓ ");
        opcion = sc.next();
        if(isNumeric(opcion)){
            opcionInt = Integer.parseInt(opcion);
            if(opcionInt == 1){//INSERT
                System.out.println("\n•◦ •° °• De cuál equipo? •◦ •° °•\n");
                seleccionandoCualEquipo(listaEquipos,"INSERT");

            }
            else if(opcionInt == 2){//SELECT
                seleccionandoCualEquipo(listaEquipos, "SELECTALL");
            }
        }else{
            System.out.println("*Error*");
        }

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

        for (int i=0;i<list.size();i++){
            System.out.print(i+1 +") ");
            list.get(i).printNombreEquipo();
            System.out.print(". \n");
        }
        System.out.println("\nIngrese la opcion: ↓");
        opcionStr = sc.next();
        if(isNumeric(opcionStr)){
            opcionInt = Integer.parseInt(opcionStr);
            switch(query){
                case "INSERT":
                    list.get(opcionInt-1).insert();
                    break;
                case "SELECTALL":
                    list.get(opcionInt-1).select();
                    break;
                //case "UPDATE":
                    //list.get(opcionInt-1).select();
                    //break;
                //case "DELETE":
                    //list.get(opcionInt-1).select();
                    //break;
            }
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
