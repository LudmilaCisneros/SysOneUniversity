public abstract class Barco {
    protected int matricula;
    protected int eslora;
    protected int anioFabricacion;

    protected Barco(int matricula,int eslora,int anioDeFabricacion){
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioDeFabricacion;
    }

    /**
     * @brief Calcula el modulo del barco
     * @return (int)
     */
    protected abstract int calcularModulo();

    /**
     * @brief Muestra por consola la info de un barco
     */
    protected abstract void printBarco();
}
