import java.util.ArrayList;

public class BackTracking {
  private ArrayList<Maquina> S, estado;
  private ArrayList<Maquina> solucion;
  private Integer totalPiezasAFabricar;

  public BackTracking(Integer totalPiezasAFabricar) {
    this.S = new ArrayList<>();
    this.estado = new ArrayList<>();
    this.solucion = new ArrayList<>();
    this.totalPiezasAFabricar = totalPiezasAFabricar;
  }
  /*
   *   - Cómo se genera el árbol de exploración.
   *   - Cuáles son los estados finales y estados solución.
   *   - Posibles podas
   */
  public ArrayList<Maquina> backTracking(ArrayList<Maquina> maquinas) {
    ArrayList<Maquina> solucionActual = new ArrayList<>();
    Integer cantPiezasActual = 0;

    backTracking(maquinas, cantPiezasActual, solucionActual);

    return solucion;
  }

  private void backTracking(ArrayList<Maquina> maquinas, Integer cantPiezasActual, ArrayList<Maquina> solucionActual) {
    if (esMejor(solucionActual, solucion, cantPiezasActual)) {
      this.solucion.clear();
      this.solucion.addAll(solucionActual);
    } else {
      for (Maquina maquina : maquinas) {
        solucionActual.add(maquina);
        cantPiezasActual += maquina.getCapacidad();

        backTracking(maquinas, cantPiezasActual, solucionActual);

        solucionActual.removeLast();
        cantPiezasActual -= maquina.getCapacidad();
      }
    }
  }

  private boolean esMejor(ArrayList<Maquina> actual, ArrayList<Maquina> mejor, Integer cantPiezasActual) {
    return mejor.isEmpty() || cantPiezasActual.equals(totalPiezasAFabricar) && actual.size() < mejor.size();
  }
}
