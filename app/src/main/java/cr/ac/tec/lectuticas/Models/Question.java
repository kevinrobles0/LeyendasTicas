package cr.ac.tec.lectuticas.Models;

import java.util.ArrayList;

/**
 * Created by Daniel on 12/06/2016.
 */
public class Question {

  private int questionId;
  private String text;
  private ArrayList<Answer> answers = new ArrayList<>();

  public Question(int questionId, String text) {
    this.questionId = questionId;
    this.text = text;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void addAnswer(Answer answer) {
    answers.add(answer);
  }

  Answer getAnswer(int index) {
    return answers.get(index);
  }

  public ArrayList<Answer> getAllAnswers() {
    return answers;
  }

}
