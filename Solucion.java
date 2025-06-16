import java.util.ArrayList;

public class Solucion {
  private ArrayList<Maquina> maquinas;
  private Integer cantPiezasProducidas, cantidadPuestasFuncionamiento, metrica;

  public Solucion() {
    this.maquinas = new ArrayList<>();
    this.cantPiezasProducidas = 0;
    this.cantidadPuestasFuncionamiento = 0;
    this.metrica = 0;
  }

  public void eliminarUltimo() {
    this.maquinas.removeLast();
  }

  public boolean estaVacio() {
    return maquinas.isEmpty();
  }

  public int getTamanio() {
    return maquinas.size();
  }

  public void vaciarSolucion() {
    this.maquinas.clear();
  }

  public ArrayList<Maquina> getMaquinas() {
    return new ArrayList<>(maquinas);
  }

  public void agregarMaquinas(ArrayList<Maquina> ms) {
    this.maquinas.addAll(ms);
  }

  public void agregarMaquina(Maquina m) {
    this.maquinas.add(m);
  }

  public Integer getCantPiezasProducidas() {
    return cantPiezasProducidas;
  }

  public Integer getCantidadPuestasFuncionamiento() {
    return cantidadPuestasFuncionamiento;
  }

  public void setCantidadPuestasFuncionamiento(Integer cantidad) {
    this.cantidadPuestasFuncionamiento = cantidad;
  }

  public Integer getMetrica() {
    return metrica;
  }

  public void setMetrica(Integer metrica) {
    this.metrica = metrica;
  }

  public void actualizarCantPiezasProducidas(Integer cantPiezasProducidas) {
    this.cantPiezasProducidas += cantPiezasProducidas;
  }

  public void setCantPiezasProducidas(Integer cantPiezasProducidas) {
    this.cantPiezasProducidas = cantPiezasProducidas;
  }

  public void restarCantPiezasProducidas(Integer cantPiezasProducidas) {
    this.cantPiezasProducidas -= cantPiezasProducidas;
  }

  public void actualizarCantidadPuestasFuncionamiento() {
    this.cantidadPuestasFuncionamiento++;
  }

  public void actualizarMetrica() {
    this.metrica++;
  }

  public void decrementarPuestasFuncionamiento() {
    this.cantidadPuestasFuncionamiento--;
  }

  @Override
  public String toString() {
    return "Solución {\n" +
            "    Maquinas = " + maquinas + "\n" +
            "    Cantidad de piezas producidas = " + cantPiezasProducidas + "\n" +
            "    Cantidad de puestas en funcionamiento requeridas = " + cantidadPuestasFuncionamiento + "\n" +
            "    Métrica para analizar el costo de la solución (cantidad de candidatos/estados considerados) = "
                 + metrica + "\n" +
            "}";
  }
}
