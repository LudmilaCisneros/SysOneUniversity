/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main(String[] Arg){

        //* Modelos*//
        Modelo basicSedan = new Modelo("Básico sedán",230000);
        Modelo basicFamiliar = new Modelo("Básico familiar",245000);
        Modelo basicCoupe = new Modelo("Básico coupé",270000);


        //*Adicionales*//
        Adicional tc = new Adicional("Techo corredizo",12000);
        Adicional aa = new Adicional("Aire acondicionado",20000);
        Adicional abs = new Adicional("Sistemas de frenos ABS",14000);
        Adicional ab = new Adicional("Airbag",7000);
        Adicional ll = new Adicional("Llantas de aleación",12000);


        //*Instancio Automoviles*//
        Automovil a1 = new Automovil(basicSedan);
        a1.agregarAdicional(tc);
        a1.agregarAdicional(aa);
        a1.agregarAdicional(ll);

        Automovil a2 = new Automovil(basicFamiliar);
        a2.agregarAdicional(tc);
        a2.agregarAdicional(aa);
        a2.agregarAdicional(ab);
        a2.agregarAdicional(abs);
        a2.agregarAdicional(ll);

        Automovil a3 = new Automovil(basicCoupe);
        a3.agregarAdicional(tc);
        a3.agregarAdicional(aa);
        a3.agregarAdicional(ll);

        Automovil a4 = new Automovil(basicCoupe);
        a4.agregarAdicional(aa);

        //*Muestro costos finales de los automoviles*//
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("|-*Costos finales de los automóviles-*|");
        System.out.println("|-------------------------------------|");
        System.out.println("|1°|Automóvil $" + a1.calcularCostoFinal() + "-.             |");
        System.out.println("|2°|Automóvil $" + a2.calcularCostoFinal() + "-.             |");
        System.out.println("|3°|Automóvil $" + a3.calcularCostoFinal() + "-.             |");
        System.out.println("|4°|Automóvil $" + a4.calcularCostoFinal() + "-.             |");
        System.out.println("--------------------------------------");
    }
}
