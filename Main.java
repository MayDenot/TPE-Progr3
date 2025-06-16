import java.util.ArrayList;
import java.util.List;

public class Main {
  private static final String ARCHIVO_ENTRADA = "Input.txt";

  public static void main(String[] args) {
    ArrayList<Maquina> maquinas = new ArrayList<>();
    int totalPiezasAFabricar = 0;
    LectorDatos datos = new LectorDatos(totalPiezasAFabricar, maquinas);

    datos = datos.cargarDatos();

    mostrarInformacionInicial(datos);

    ejecutarAlgoritmos(datos);
  }

  public static void mostrarInformacionInicial(LectorDatos datos) {
    System.out.println("Total de piezas a fabricar: " + datos.getTotalPiezas());
    System.out.println("Máquinas disponibles:");
    for (Maquina maquina : datos.getMaquinas()) {
      System.out.println("  " + maquina);
    }
  }

  public static void ejecutarAlgoritmos(LectorDatos datos) {
    BackTracking back = new BackTracking(datos.getTotalPiezas());
    System.out.println("Backtracking");
    System.out.println(back.backTracking(datos.getMaquinas()));
    // FALTA ESTO
    // Solución obtenida: secuencia de máquinas.
    // Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento
    // requeridas.
    // Métrica para analizar el costo de la solución (cantidad de estados generados)

    Greedy greedy = new Greedy(datos.getTotalPiezas());
    System.out.println("Greedy"); // Crear clase Solucion
    List<Maquina> solucionGreedy = greedy.greedy(datos.getMaquinas());
    if (solucionGreedy != null) {
      System.out.println("Solución obtenida: " + solucionGreedy);
    } else {
      System.out.println("No hay solución posible");
    }
    // FALTA ESTO
    // Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento
    // requeridas.
    // Métrica para analizar el costo de la solución (cantidad de candidatos considerados)
  }
}