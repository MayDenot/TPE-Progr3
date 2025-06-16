import java.util.ArrayList;

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
    System.out.println();
  }

  public static void ejecutarAlgoritmos(LectorDatos datos) {
    BackTracking back = new BackTracking(datos.getTotalPiezas());
    System.out.println("Backtracking");
    Solucion solucionBack = back.backTracking(datos.getMaquinas());
    System.out.println(solucionBack);
    System.out.println();

    Greedy greedy = new Greedy(datos.getTotalPiezas());
    System.out.println("Greedy");
    Solucion solucionGreedy = greedy.greedy(datos.getMaquinas());
    if (solucionGreedy != null) {
      System.out.println(solucionGreedy);
    } else {
      System.out.println("No hay solución posible");
    }
  }
}