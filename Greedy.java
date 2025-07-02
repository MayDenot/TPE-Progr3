import java.util.ArrayList;
import java.util.Collections;

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
    maquinas.sort(Collections.reverseOrder());

    while (!solucion(piezasRestantes) && !maquinas.isEmpty()) {
      Maquina maquinaCandidata = maquinas.getFirst(); // Criterio greedy
      maquinas.remove(maquinaCandidata);

      solucion.actualizarMetrica();
      if (esFactible(maquinaCandidata, piezasRestantes)) {
        int cantidadDeUsos = piezasRestantes / maquinaCandidata.getCapacidad();
        for (int i = 0; i < cantidadDeUsos; i++) {
          solucion.agregarMaquina(maquinaCandidata);
          solucion.actualizarCantPiezasProducidas(maquinaCandidata.getCapacidad());
          solucion.actualizarCantidadPuestasFuncionamiento();
          piezasRestantes -= maquinaCandidata.getCapacidad();
        }
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
}
