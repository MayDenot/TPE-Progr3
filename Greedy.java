import java.util.ArrayList;

public class Greedy {
  private ArrayList<Maquina> S;
  private Integer totalPiezasAFabricar;

  public Greedy(Integer totalPiezasAFabricar) {
    this.S = new ArrayList<>();
    this.totalPiezasAFabricar = totalPiezasAFabricar;
  }
  /*
   * Breve explicación de la estrategia de resolución. Por ejemplo:
   * - Cuáles son los candidatos.
   *   Los candidatos son las máquinas.
   * - Estrategia de selección de candidatos.
   *   El critero para elegir los candidatos, es el que tenga mayor capacidad.
   * - Consideraciones respecto a encontrar o no solución.
   *   La consideración que tomamos para ver si se encontró o no la solución
   *   es que las piezas restantes sean iguales a cero.
   */
  public ArrayList<Maquina> greedy(ArrayList<Maquina> maquinas) {
    Integer piezasRestantes = this.totalPiezasAFabricar;

    while (!solucion(piezasRestantes)) {
      Maquina maquinaCandidata = seleccionarMaquinas(maquinas, piezasRestantes); // Criterio greedy
      if (esFactible(maquinaCandidata, piezasRestantes)) {
        Integer cantidad = piezasRestantes / maquinaCandidata.getCapacidad();
        S.add(maquinaCandidata);
        piezasRestantes = piezasRestantes % maquinaCandidata.getCapacidad();
      }
    }
    if (solucion(piezasRestantes))
      return S;
    else
      return null;
  }

  private boolean esFactible(Maquina maquinaCandidata, Integer piezasRestantes) {
    return maquinaCandidata.getCapacidad() <= piezasRestantes;
  }

  private boolean solucion(Integer piezasRestantes) {
    return piezasRestantes.equals(0);
  }

  private Maquina seleccionarMaquinas(ArrayList<Maquina> maquinas, Integer piezasRestantes) {
    // Seleccionar la máquina con capacidad mayor
    Maquina mejor = new Maquina("", 0);
    for (Maquina maquina : maquinas) {
      if (maquina.getCapacidad() > mejor.getCapacidad() && esFactible(maquina, piezasRestantes)) {
        mejor = maquina;
      }
    }
    return mejor;
  }

  // Ordenar los candidatos de mayor a menor
}
