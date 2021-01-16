public class Yate extends Barco{
    private int potenciaCV;
    private int nroCamarotes;

    public Yate(int matricula,int eslora,int anioDeFabricacion,int potenciaCV,int nroCamarotes){
        super(matricula,eslora,anioDeFabricacion);
        this.potenciaCV = potenciaCV;
        this.nroCamarotes = nroCamarotes;
    }
    public int getPotenciaCV(){ return this.potenciaCV; }

    public int getNroCamarotes(){
        return this.nroCamarotes;
    }

    /**
     * @brief Calcula el modulo del yate
     * @return (int)
     */
    @Override
    protected int calcularModulo(){
        int eslora = this.eslora;
        int resultado = eslora*10;

        return resultado + this.potenciaCV + this.nroCamarotes;
    }

    /**
     * @brief Muestra por consola la info del yate
     */
    @Override
    protected void printBarco(){
        System.out.println("Modelo Yate");
        System.out.println("Matricula: "+ this.matricula);
        System.out.println("Eslora: "+ this.eslora);
        System.out.println("Año de fabricación: "+ this.anioFabricacion);
        System.out.println("PotenciaCV: "+ this.potenciaCV);
        System.out.println("Nro camarotes: "+ this.nroCamarotes);
    }
}
