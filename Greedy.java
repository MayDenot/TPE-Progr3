import java.util.ArrayList;

public class Greedy {
  private Solucion solucion;
  private Integer totalPiezasAFabricar;

  public Greedy(Integer totalPiezasAFabricar) {
    this.solucion = new Solucion();
    this.totalPiezasAFabricar = totalPiezasAFabricar;
  }
  /*
   * Breve explicación de la estrategia de resolución. Por ejemplo:
   * - Cuáles son los candidatos.
   *   Los candidatos son las máquinas.
   * - Estrategia de selección de candidatos.
   *   El criterio para elegir los candidatos, es el que tenga mayor capacidad.
   * - Consideraciones respecto a encontrar o no solución.
   *   La consideración que tomamos para ver si se encontró o no la solución
   *   es que las piezas restantes sean iguales a cero o que el metodo seleccionarMaquinas
   *   no devuelva ningún candidato válido.
   */
  public Solucion greedy(ArrayList<Maquina> maquinas) {
    Integer piezasRestantes = this.totalPiezasAFabricar;

    while (!solucion(piezasRestantes)) {
      Maquina maquinaCandidata = seleccionarMaquinas(maquinas, piezasRestantes); // Criterio greedy
      if (maquinaCandidata.getCapacidad() == 0) {
        return null;
      }
      if (esFactible(maquinaCandidata, piezasRestantes)) {
        solucion.agregarMaquina(maquinaCandidata);
        solucion.actualizarCantPiezasProducidas(maquinaCandidata.getCapacidad());
        solucion.actualizarCantidadPuestasFuncionamiento();
        solucion.actualizarMetrica();
        piezasRestantes -= maquinaCandidata.getCapacidad();
      } else {
        return null;
      }
    }
    if (solucion(piezasRestantes))
      return solucion;
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
}
