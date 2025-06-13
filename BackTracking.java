import java.util.ArrayList;

public class BackTracking {
  private ArrayList<Maquina> S, estado;
  private Integer totalPiezasAFabricar;

  public BackTracking(Integer totalPiezasAFabricar) {
    this.S = new ArrayList<>();
    this.estado = new ArrayList<>();
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
    return solucionActual;
  }

  private void backTracking(ArrayList<Maquina> maquinas, Integer cantPiezasActual,
                            ArrayList<Maquina> solucionActual) {
    if (cantPiezasActual.equals(totalPiezasAFabricar) && estado.size() < solucionActual.size()) {
      solucionActual.clear();
      solucionActual.addAll(estado);
    } else {
      for (int i = 0; i < maquinas.size(); i++) {
        if (cantPiezasActual + maquinas.get(i).getCapacidad() <= totalPiezasAFabricar) {
          estado.add(maquinas.get(i));
          backTracking(maquinas, cantPiezasActual + maquinas.get(i).getCapacidad(), solucionActual);
          estado.remove(estado.size() - 1);
        }
      }
    }
  }
}
