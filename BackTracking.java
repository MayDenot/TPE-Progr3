import java.util.ArrayList;

public class BackTracking {
  private Solucion solucion;
  private Integer totalPiezasAFabricar;

  public BackTracking(Integer totalPiezasAFabricar) {
    this.solucion = new Solucion();
    this.totalPiezasAFabricar = totalPiezasAFabricar;
  }
  /*
   *   - Cómo se genera el árbol de exploración.
   *     Por cada nivel del árbol se genera un estado, al cual se le van agregando
   *     máquinas, es decir, en el primer nivel van a estar los estados que tengan
   *     solo una máquina, en el segundo nivel todos lo estados que tengan dos máquinas,
   *     y así progresivamente.
   *   - Cuáles son los estados finales y estados solución.
   *     Un estado final posible siguiendo el ejemplo con máquinas [M1=7, M2=3, M3=4, M4=1] y
   *     con un total de piezas a fabricar = 12 sería [M1,M2,M3] saliendo por la primera poda
   *     (si nos pasamos del total requerido).
   *     Algunos estados solución válidos siguiendo con el mismo ejemplo, serían [M3,M3,M3] o
   *     [M1,M3,M4] o [M2,M2,M2,M2].
   *   - Posibles podas
   *      1. Sí nos pasamos del total requerido
   *      2. Si ya tenemos una solución mejor
   */
  public Solucion backTracking(ArrayList<Maquina> maquinas) {
    Solucion solucionActual = new Solucion();

    backTracking(maquinas, 0, solucionActual);

    return solucion;
  }

  private void backTracking(ArrayList<Maquina> maquinas, Integer cantPiezasActual, Solucion solucionActual) {
    solucionActual.actualizarMetrica();

    if (cantPiezasActual.equals(totalPiezasAFabricar)) {
      if (esMejor(solucionActual, solucion, cantPiezasActual)) {
        actualizarMejorSolucion(solucionActual);
      }
    } else {
      // Poda: si nos pasamos del total requerido
      if (cantPiezasActual > totalPiezasAFabricar) {
        return;
      }

      // Poda: si ya tenemos una solución mejor
      if (!solucion.estaVacio() && solucionActual.getTamanio() >= solucion.getTamanio()) {
        return;
      }

      for (Maquina maquina : maquinas) {
        solucionActual.agregarMaquina(maquina);
        solucionActual.actualizarCantPiezasProducidas(maquina.getCapacidad());
        solucionActual.actualizarCantidadPuestasFuncionamiento();
        cantPiezasActual += maquina.getCapacidad();

        backTracking(maquinas, cantPiezasActual, solucionActual);

        solucionActual.eliminarUltimo();
        solucionActual.restarCantPiezasProducidas(maquina.getCapacidad());
        solucionActual.decrementarPuestasFuncionamiento();
        cantPiezasActual -= maquina.getCapacidad();
      }
    }
  }

  private void actualizarMejorSolucion(Solucion solucionActual) {
    this.solucion.vaciarSolucion();
    for (Maquina m : solucionActual.getMaquinas()) {
      solucion.agregarMaquina(m);
    }
    solucion.setCantPiezasProducidas(solucionActual.getCantPiezasProducidas());
    solucion.setCantidadPuestasFuncionamiento(solucionActual.getCantidadPuestasFuncionamiento());
    solucion.setMetrica(solucionActual.getMetrica());
  }

  private boolean esMejor(Solucion actual, Solucion mejor, Integer cantPiezasActual) {
    return mejor.estaVacio() || actual.getTamanio() < mejor.getTamanio();
  }
}
