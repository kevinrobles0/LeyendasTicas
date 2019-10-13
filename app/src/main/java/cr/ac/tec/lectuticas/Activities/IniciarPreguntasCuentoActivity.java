package cr.ac.tec.lectuticas.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import cr.ac.tec.lectuticas.R;
import cr.ac.tec.lectuticas.Utilities.AnalyticsTracker;
import pl.droidsonroids.gif.GifImageView;

public class IniciarPreguntasCuentoActivity extends AppCompatActivity {

  private String storyId;
  private int backgroundId;
  
  private AnalyticsTracker analyticsTracker;
  
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_iniciar_preguntas);
    analyticsTracker = AnalyticsTracker.getAnalyticsTracker(this.getApplicationContext());
    
    Intent intent = getIntent();
    storyId = intent.getStringExtra("storyId");
    
    // Asigna fondo de layout para Activity.
    backgroundId = intent.getIntExtra("storyBackgroundId", 0);
    RelativeLayout relativeLayout =
        (RelativeLayout) findViewById(R.id.layoutIniciarPreguntasCuento);
    if ((relativeLayout != null) && (backgroundId != 0)) {
      try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          relativeLayout.setBackground(getDrawable(backgroundId));
        } else {
          relativeLayout.setBackgroundDrawable(getResources().getDrawable(backgroundId));
        }
      } catch (Exception e) {
        Log.e("ResourceError", getString(R.string.background_rendering_error));
        e.printStackTrace();
      }
    }
    
    // Asigna GIF animado que se muestra en Activity.
    int characterGifId = intent.getIntExtra("storyCharaGifRes", 0);
    GifImageView gifImageView = (GifImageView) findViewById(R.id.gifPersonajeCuento);
    if ((gifImageView != null) && (characterGifId != 0)) {
      try {
        gifImageView.setImageResource(characterGifId);
      } catch (Exception e) {
        Log.e("ResourceError", getString(R.string.character_gif_render_error));
        e.printStackTrace();
      }
    }

    Button questionButton = (Button) findViewById(R.id.botonIniciarPreguntas);
    if (questionButton != null) {
      questionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(IniciarPreguntasCuentoActivity.this,
              PreguntasCuentoActivity.class);
          intent.putExtra("storyBackgroundId", backgroundId);
          intent.putExtra("storyId", storyId);
          startActivity(intent);
        }
      });
    }
  }
  
  protected void onResume() {
    super.onResume();
    analyticsTracker.trackScreen("IniciarPreguntasCuentoActivity");
  }
}
