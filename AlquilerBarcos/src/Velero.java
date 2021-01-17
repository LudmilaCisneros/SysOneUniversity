public class Velero extends Barco{
    private final int nroMastiles;

    public Velero(int matricula,int eslora,int anioDeFabricacion,int nroMastiles){
        super(matricula,eslora,anioDeFabricacion);
        this.nroMastiles = nroMastiles;
    }

    public int getNroMastiles(){
        return this.nroMastiles;
    }

    /**
     * @brief Calcula el modulo del velero
     * @return (int)
     */
    @Override
    protected int calcularModulo(){
        int eslora = this.eslora * 10;

        return (eslora + this.nroMastiles);
    }

    /**
     * @brief Muestra por consola la info del Velero
     */
    @Override
    protected void printBarco(){
        System.out.println("Modelo Velero");
        System.out.println("Matricula: "+ this.matricula);
        System.out.println("Eslora: "+ this.eslora);
        System.out.println("Año de fabricación: "+ this.anioFabricacion);
        System.out.println("Nro de mastiles: "+ this.nroMastiles);
    }
}
