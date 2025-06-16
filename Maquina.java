public class Maquina implements Comparable<Maquina> {
  private String nombre;
  private Integer capacidad;

  public Maquina(String nombre, Integer capacidad) {
    this.nombre = nombre;
    this.capacidad = capacidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
  }

  @Override
  public String toString() {
    return nombre;
  }

  @Override
  public int compareTo(Maquina o) {
    return this.getCapacidad().compareTo(o.getCapacidad());
  }
}
