package cr.ac.tec.lectuticas.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cr.ac.tec.lectuticas.R;


public class ResultadoPreguntasActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_resultado_preguntas);

    Intent intent = getIntent();
    String correctAnswers = intent.getStringExtra("correctAnswers");
    String questionsQty = intent.getStringExtra("questionsCount");
    int score = (Integer.parseInt(correctAnswers) * 100) / Integer.parseInt(questionsQty);

    String resultText = getString(R.string.mensaje_resultados_parte1) + correctAnswers + " "
        + getString(R.string.mensaje_resultados_parte2) + " " + questionsQty + " " +
        getString(R.string.mensaje_resultados_parte3) + " " + String.valueOf(score);

    TextView textViewScore = (TextView) findViewById(R.id.txtPuntaje);
    if (textViewScore != null) {
      textViewScore.setText(resultText);
    }

    int storyBackgroundId = intent.getIntExtra("storyBackgroundId", 0);
    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutResultadosPreguntas);
    if ((relativeLayout != null) && (storyBackgroundId != 0)) {
      try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          relativeLayout.setBackground(getDrawable(storyBackgroundId));
        } else {
          relativeLayout.setBackgroundDrawable(getResources().getDrawable(storyBackgroundId));
        }
      } catch (Exception e) {
        Log.e("ResourceError", getString(R.string.background_rendering_error));
        e.printStackTrace();
      }
    }

    Button menuButton = (Button) findViewById(R.id.botonMenu);

    if (menuButton != null) {
      menuButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          goToMainMenu();
        }
      });
    }
  }

  private void goToMainMenu() {
    Intent intentMain = new Intent(this, LeyendasActivity.class);
    intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intentMain);
    finish();
  }
}
