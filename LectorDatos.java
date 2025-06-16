import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDatos {
  private static final String ARCHIVO_ENTRADA = "Input.txt";
  private int totalPiezas;
  private ArrayList<Maquina> maquinas;

  public LectorDatos(int totalPiezas, ArrayList<Maquina> maquinas) {
    this.totalPiezas = totalPiezas;
    this.maquinas = maquinas;
  }

  public int getTotalPiezas() {
    return totalPiezas;
  }

  public ArrayList<Maquina> getMaquinas() {
    return maquinas;
  }

  public LectorDatos cargarDatos() {
    ArrayList<Maquina> maquinas = new ArrayList<>();
    int totalPiezasAFabricar = 0;

    try (BufferedReader bf = new BufferedReader(new FileReader(ARCHIVO_ENTRADA))) {
      totalPiezasAFabricar = leerTotalPiezas(bf);
      cargarMaquinas(bf, maquinas);
    } catch (Exception e) {
      throw new RuntimeException("Error al leer el archivo de entrada", e);
    }

    return new LectorDatos(totalPiezasAFabricar, maquinas);
  }

  private int leerTotalPiezas(BufferedReader bf) {
    String linea = null;
    try {
      linea = bf.readLine();
      if (linea == null) {
        throw new IllegalStateException("El archivo está vacío");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return Integer.parseInt(linea.trim());
  }

  private void cargarMaquinas(BufferedReader bf, ArrayList<Maquina> maquinas) {
    try {
      String linea;
      while ((linea = bf.readLine()) != null) {
        String[] partes = linea.split(",");
        if (partes.length == 2) {
          maquinas.add(crearMaquina(partes));
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Maquina crearMaquina(String[] partes) {
    String nombreMaquina = partes[0].trim();
    int capacidadMaquina = Integer.parseInt(partes[1].trim());
    return new Maquina(nombreMaquina, capacidadMaquina);
  }
}
