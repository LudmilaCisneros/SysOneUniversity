public class Deportivo extends Barco{
    private int potenciaCV;

    public Deportivo(int matricula,int eslora,int anioDeFabricacion,int potenciaCV){
    super(matricula,eslora,anioDeFabricacion);
    this.potenciaCV = potenciaCV;
    }

    public int getPotenciaCV(){
        return this.potenciaCV;
    }
    
    /**
     * @brief Calcula el modulo del barco deportivo
     * @return (int)
     */
    @Override
    protected int calcularModulo(){
        int eslora = this.eslora;
        int resultado = eslora*10;
        return resultado + this.potenciaCV;
    }

    /**
     * @brief Muestra por consola la info del barco deportivo
     */
    @Override
    protected void printBarco(){
        System.out.println("Modelo Deportivo");
        System.out.println("Matricula: "+ this.matricula);
        System.out.println("Eslora: "+ this.eslora);
        System.out.println("Año de fabricación: "+ this.anioFabricacion);
        System.out.println("PotenciaCV: "+ this.potenciaCV);
    }
}
