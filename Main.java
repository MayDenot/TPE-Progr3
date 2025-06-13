import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Maquina> maquinas = new ArrayList<>();
    Integer totalPiezasAFabricar = 0;

    try {
      BufferedReader bf = new BufferedReader(new FileReader("Input.txt"));

      // Leer la primera línea: cantidad total de piezas a fabricar
      String primeraLinea = bf.readLine();
      totalPiezasAFabricar = Integer.parseInt(primeraLinea.trim());

      // Leer las líneas siguientes: información de las máquinas
      String linea;
      while ((linea = bf.readLine()) != null) {
        // Dividir la línea por la coma
        String[] partes = linea.split(",");

        if (partes.length == 2) {
          String nombreMaquina = partes[0].trim();
          int capacidadMaquina = Integer.parseInt(partes[1].trim());

          // Crear nueva máquina y agregarla al ArrayList
          Maquina maquina = new Maquina(nombreMaquina, capacidadMaquina);
          maquinas.add(maquina);
        }
      }

      bf.close();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.out.println("Total de piezas a fabricar: " + totalPiezasAFabricar);
    System.out.println("Máquinas disponibles:");
    for (Maquina maquina : maquinas) {
      System.out.println("  " + maquina);
    }

    BackTracking back = new BackTracking(totalPiezasAFabricar);
    System.out.println("Backtracking");
    System.out.println(back.backTracking(maquinas));
    // FALTA ESTO
    // Solución obtenida: secuencia de máquinas.
    // Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento
    // requeridas.
    // Métrica para analizar el costo de la solución (cantidad de estados generados)

    Greedy greedy = new Greedy(totalPiezasAFabricar);
    System.out.println("Greedy");
    System.out.println("Solución obtenida: " + greedy.greedy(maquinas));
    // FALTA ESTO
    // Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento
    // requeridas.
    // Métrica para analizar el costo de la solución (cantidad de candidatos considerados)
  }
}