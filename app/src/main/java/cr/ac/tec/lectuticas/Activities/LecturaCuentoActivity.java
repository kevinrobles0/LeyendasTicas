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
import android.widget.Toast;
import cr.ac.tec.lectuticas.Models.Paragraph;
import cr.ac.tec.lectuticas.Models.Story;
import cr.ac.tec.lectuticas.R;
import cr.ac.tec.lectuticas.Utilities.AnalyticsTracker;
import cr.ac.tec.lectuticas.Utilities.WebServiceCaller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;


public class LecturaCuentoActivity extends AppCompatActivity {

  private String storyId;
  private Story story;

  private int storyBackgroundRes; // ResId del fondo del story.
  private int storyCharaGifRes;  // ResId de GIF del personaje de story.

  private int counter;
  private AnalyticsTracker analyticsTracker;

  private ArrayList<Paragraph> paragraphs;
  private TextView textViewParagraph;

  private int paragraphsQty;

  private Button previousButton;
  private Button nextButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    try {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_lectura_cuento);

      analyticsTracker = AnalyticsTracker.getAnalyticsTracker(this.getApplicationContext());

      final Intent intent = getIntent();
      storyId = intent.getStringExtra("id");
      String storyName = intent.getStringExtra("name");

      storyBackgroundRes = intent.getIntExtra("storyBackground", 0);
      storyCharaGifRes = intent.getIntExtra("characterGif", 0);

      // Asigna el fondo del layout recibiendo el identificador de la imagen como extra del Intent.

      RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutLecturaCuento);
      if ((relativeLayout != null) && (storyBackgroundRes != 0)) {
        try {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            relativeLayout.setBackground(getDrawable(storyBackgroundRes));
          } else {
            relativeLayout.setBackgroundDrawable(getResources().getDrawable(storyBackgroundRes));
          }
        } catch (Exception e) {
          Log.e("ResourceError", "No se puede asignar el fondo de activity LecturaCuentoActivity.");
        }
      }

      story = new Story(storyName, Integer.parseInt(storyId));

      getParrafos();
      counter = 0;

      textViewParagraph = (TextView) findViewById(R.id.textoParrafo);
      paragraphs = story.getLista();
      paragraphsQty = paragraphs.size();
      textViewParagraph.setText(paragraphs.get(counter).getText());

      previousButton = (Button) findViewById(R.id.btnAtras);
      nextButton = (Button) findViewById(R.id.btnAdelante);
      previousButton.setVisibility(View.INVISIBLE);

      nextButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if ((counter + 1) < paragraphsQty) {
            ++counter;
            textViewParagraph.setText(paragraphs.get(counter).getText());

            previousButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(
                ((counter + 1) < paragraphsQty) ? View.VISIBLE : View.INVISIBLE
            );
          }
        }
      });

      previousButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (counter > 0) {
            --counter;
            textViewParagraph.setText(paragraphs.get(counter).getText());

            nextButton.setVisibility(View.VISIBLE);
            previousButton.setVisibility(
                (counter > 0) ? View.VISIBLE : View.INVISIBLE
            );
          }
        }
      });

      Button btnMenu = (Button) findViewById(R.id.botonMenu);
      if (btnMenu != null) {
        btnMenu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            volverAMenuPrincipal();
          }
        });
      }

      Button btnPreguntas = (Button) findViewById(R.id.btnPreguntas);
      if (btnPreguntas != null) {
        btnPreguntas.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intentGo = new Intent(LecturaCuentoActivity.this,
                IniciarPreguntasCuentoActivity.class);
            intentGo.putExtra("storyBackgroundId", storyBackgroundRes);
            intentGo.putExtra("storyId", storyId);
            intentGo.putExtra("storyCharaGifRes", storyCharaGifRes);
            startActivity(intentGo);
          }
        });
      }
    } catch (NumberFormatException e) {
      Log.e("Exception", "Id de historia no tiene formato válido. Dato no existe o es inválido.");
      Toast.makeText
          (getApplicationContext(), getString(R.string.error_iniciarPantallaCuento),
              Toast.LENGTH_LONG).show();
      finish();
    }
  }

  // TODO - Llamada a Web Service para obtener párrafos del story.
  private void getParrafos() {
    try {
      Map<String, String> params = new HashMap<>();
      params.put("id", storyId);
      String resource = "StoryParagraphs.php";

      String result = WebServiceCaller
          .doGetRequest(getApplicationContext(), resource, params);

      if (!result.equals("")) {
        JSONArray list = new JSONArray(result);

        for (int i = 0; i < list.length(); i++) {
          JSONObject paragraphJson = list.getJSONObject(i);

          Paragraph paragraph = new Paragraph(paragraphJson.getString("Text"),
              Integer.parseInt(paragraphJson.getString("ParagraphNumber")));
          story.addParagraph(paragraph);
        }
      } else {
        Toast.makeText(this, getString(R.string.query_error), Toast.LENGTH_LONG).show();
      }
    } catch (Exception e) {
      Toast.makeText(this, R.string.connection_error, Toast.LENGTH_LONG).show();
      e.printStackTrace();
      volverAMenuPrincipal();
    }
  }

  protected void onResume() {
    super.onResume();
    analyticsTracker.trackScreen("LecturaCuentoActivity");
  }

  private void volverAMenuPrincipal() {
    Intent intentMain = new Intent(this, LeyendasActivity.class);
    intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intentMain);
    finish();
  }
}
