package cr.ac.tec.lectuticas.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cr.ac.tec.lectuticas.Models.Answer;
import cr.ac.tec.lectuticas.Models.Question;
import cr.ac.tec.lectuticas.R;
import cr.ac.tec.lectuticas.Utilities.WebServiceCaller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;


public class PreguntasCuentoActivity extends AppCompatActivity {

  private String storyId;
  private int storyBackgroundId;

  private int questionCounter = 0;
  private int correctAnswersCount = 0;

  private ArrayList<Question> questions = new ArrayList<Question>();
  private RadioGroup answersRadioGroup;
  private Question currentQuestion;
  private ArrayList<Answer> currentAnswers;
  private TextView textViewQuestion;
  private Button nextBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preguntas_cuento);

    Intent intent = getIntent();

    storyId = intent.getStringExtra("storyId");
    getStoryQuestions();

    storyBackgroundId = intent.getIntExtra("storyBackgroundId", 0);
    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutPreguntasLectura);

    if ((relativeLayout != null) && (storyBackgroundId != 0)) {
      try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          relativeLayout.setBackground(getDrawable(storyBackgroundId));
        } else {
          relativeLayout.setBackgroundDrawable(getResources().getDrawable(storyBackgroundId));
        }
      } catch (Exception e) {
        Log.e("ResourceError", "No se puede asignar el fondo de activity " +
            "PreguntasCuentoActivity.");
        e.printStackTrace();
      }
    }

    Button botonMenu = (Button) findViewById(R.id.botonMenu);
    if (botonMenu != null) {
      botonMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          closeActivity();
        }
      });
    }

    currentQuestion = questions.get(questionCounter);
    currentAnswers = currentQuestion.getAllAnswers();

    textViewQuestion = (TextView) findViewById(R.id.tvPregunta);
    textViewQuestion.setText(currentQuestion.getText());

    answersRadioGroup = (RadioGroup) findViewById(R.id.conjunto);
    showAnswersInView();

    nextBtn = (Button) findViewById(R.id.btnPreguntaSiguiente);

    if (nextBtn != null) {
      nextBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          checkSelectedAnswer();

          if (questionCounter + 1 < questions.size()) {
            switchToNextQuestion();

          } else {
            finishQuiz();
          }

          answersRadioGroup.clearCheck();
        }
      });
    }
  }

  private void getStoryQuestions() {
    try {
      Map<String, String> params = new HashMap<>();
      params.put("id", storyId);
      String resource = "StoryQuestions.php";

      String result = WebServiceCaller
          .doGetRequest(getApplicationContext(), resource, params);

      if (!result.equals("")) {
        JSONArray questionsJson = new JSONArray(result);

        for (int i = 0; i < questionsJson.length(); i++) {
          JSONObject questionJson = questionsJson.getJSONObject(i);

          Question question = new Question(
              Integer.parseInt(questionJson.getString("Id")),
              questionJson.getString("Text"));

          getQuestionAnswers(question);
          questions.add(question);
        }
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      Toast.makeText(this, R.string.query_error, Toast.LENGTH_LONG).show();
      e.printStackTrace();
      closeActivity();
    }
  }

  private void getQuestionAnswers(Question question) {
    try {
      Map<String, String> params = new HashMap<>();
      params.put("id", Integer.toString(question.getQuestionId()));
      String resource = "QuestionAnswers.php";

      String queryResult = WebServiceCaller.doGetRequest(getApplicationContext(), resource, params);

      if (!queryResult.equals("")) {
        JSONArray answersJson = new JSONArray(queryResult);

        for (int i = 0; i < answersJson.length(); i++) {
          JSONObject answerJson = answersJson.getJSONObject(i);

          int answerId = Integer.parseInt(answerJson.getString("Id"));
          String text = answerJson.getString("Text");
          boolean correctAnswer = answerJson.getString("CorrectAnswer").equals("1");

          Answer extractedAnswer = new Answer(answerId, text, correctAnswer);
          question.addAnswer(extractedAnswer);
        }
      } else {
        Log.e(PreguntasCuentoActivity.class.getSimpleName(), getString(R.string.query_error));
        Toast.makeText(this, R.string.answers_query_error, Toast.LENGTH_LONG).show();
        closeActivity();
      }
    } catch (Exception e) {
      Log.e(PreguntasCuentoActivity.class.getSimpleName(),
          "Error fatal al procesar currentAnswers.");
      e.printStackTrace();
      closeActivity();
    }
  }

  private void checkSelectedAnswer() {
    if (answersRadioGroup.getCheckedRadioButtonId() >= 0) {
      int id = answersRadioGroup.getCheckedRadioButtonId();
      RadioButton rb = (RadioButton) findViewById(id);

      String selectedAnswer = null;
      if (rb != null) {
        selectedAnswer = rb.getText().toString();
      }
      for (Answer answer : currentAnswers) {
        if (answer.getText().equals(selectedAnswer)) {
          if (answer.isCorrect()) {
            correctAnswersCount += 1;
          }
        }
      }
    } else {
      Toast.makeText(PreguntasCuentoActivity.this,
          getString(R.string.answer_not_selected_prompt), Toast.LENGTH_LONG).show();
    }
  }

  private void closeActivity() {
    Intent intentMain = new Intent(this, LeyendasActivity.class);
    intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intentMain);
    finish();
  }

  private void switchToNextQuestion() {
    ++questionCounter;

    // Change button text when reached last question.
    if (questionCounter + 1 == questions.size()) {
      nextBtn.setText(getString(R.string.check_quiz_results));
    }

    currentQuestion = questions.get(questionCounter);
    currentAnswers = currentQuestion.getAllAnswers();
    textViewQuestion.setText(currentQuestion.getText());

    showAnswersInView();
  }

  private void showAnswersInView() {
    answersRadioGroup.removeAllViews();

    for (int option = 0; option < currentAnswers.size(); option++) {
      RadioButton rb = (RadioButton) getLayoutInflater().inflate(
          R.layout.radiobutton_style, null);
      rb.setId(option);
      rb.setText(currentAnswers.get(option).getText());
      rb.setChecked(false);
      answersRadioGroup.addView(rb);
    }
  }

  private void finishQuiz() {
    Intent intentNext = new Intent(PreguntasCuentoActivity.this,
        ResultadoPreguntasActivity.class);
    String correctAnswers = String.valueOf(correctAnswersCount);
    intentNext.putExtra("correctAnswers", correctAnswers);
    intentNext.putExtra("questionsCount", String.valueOf(questions.size()));
    intentNext.putExtra("storyBackgroundId", storyBackgroundId);

    finish();
    startActivity(intentNext);
  }
}
