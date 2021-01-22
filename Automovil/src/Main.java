/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main(String[] Arg){

        //* Modelos*//
        Modelo basicSedan = new Modelo(1,"Básico sedán",230000);
        Modelo basicFamiliar = new Modelo(2,"Básico familiar",245000);
        Modelo basicCoupe = new Modelo(3,"Básico coupé",270000);


        //*Adicionales*//
        Adicional tc = new Adicional(1,"Techo corredizo",12000);
        Adicional aa = new Adicional(2,"Aire acondicionado",20000);
        Adicional abs = new Adicional(3,"Sistemas de frenos ABS",14000);
        Adicional ab = new Adicional(4,"Airbag",7000);
        Adicional ll = new Adicional(5,"Llantas de aleación",12000);


        //*Instancio Automoviles*//
        Automovil a1 = new Automovil(1,basicSedan);
        a1.agregarAdicional(tc);
        a1.agregarAdicional(aa);
        a1.agregarAdicional(ll);

        Automovil a2 = new Automovil(2,basicFamiliar);
        a2.agregarAdicional(tc);
        a2.agregarAdicional(aa);
        a2.agregarAdicional(ab);
        a2.agregarAdicional(abs);
        a2.agregarAdicional(ll);

        Automovil a3 = new Automovil(3,basicCoupe);
        a3.agregarAdicional(tc);
        a3.agregarAdicional(aa);
        a3.agregarAdicional(ll);

        Automovil a4 = new Automovil(4,basicCoupe);
        a4.agregarAdicional(aa);

        //*Muestro costos finales de los automoviles*//
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("|-*Costos finales de los automóviles-*|");
        System.out.println("|-------------------------------------|");
        System.out.println("|ID: " + a1.getId() + "|Automóvil $" + a1.calcularCostoFinal() + "-.          |");
        System.out.println("|ID: " + a2.getId() + "|Automóvil $" + a2.calcularCostoFinal() + "-.          |");
        System.out.println("|ID: " + a3.getId() + "|Automóvil $" + a3.calcularCostoFinal() + "-.          |");
        System.out.println("|ID: " + a4.getId() + "|Automóvil $" + a4.calcularCostoFinal() + "-.          |");
        System.out.println("--------------------------------------");
    }
}
