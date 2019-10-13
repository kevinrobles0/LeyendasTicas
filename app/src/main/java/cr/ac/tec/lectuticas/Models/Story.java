package cr.ac.tec.lectuticas.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Daniel on 09/06/2016.
 */
public class Story implements Serializable {

  private int idCuento;

  private String nombre;
  private ArrayList<Paragraph> paragraphs;    // Párrafos corresponden a páginas.

  public Story(String nombre, int idCuento) {
    this.nombre = nombre;
    this.idCuento = idCuento;
    this.paragraphs = new ArrayList<Paragraph>();
  }

  public void addParagraph(Paragraph paragraph) {
    paragraphs.add(paragraph);
  }

  public Paragraph getParrafo(int index) {
    return paragraphs.get(index);
  }

  public ArrayList<Paragraph> getLista() {
    return paragraphs;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getIdCuento() {
    return idCuento;
  }

  public void setIdCuento(int idCuento) {
    this.idCuento = idCuento;
  }
}
