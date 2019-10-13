package cr.ac.tec.lectuticas.Models;

/**
 * Created by Daniel on 12/06/2016.
 */
public class Answer {

  private int id;
  private String text;
  private boolean correctAnswer;

  public Answer(int id, String text, boolean correctAnswer) {
    this.id = id;
    this.text = text;
    this.correctAnswer = correctAnswer;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isCorrect() {
    return correctAnswer;
  }

  public void setCorrect(boolean correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
}
