package cr.ac.tec.lectuticas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import cr.ac.tec.lectuticas.R;
import cr.ac.tec.lectuticas.Utilities.AnalyticsTracker;

public class LeyendasActivity extends AppCompatActivity {

  private AnalyticsTracker analyticsTracker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_leyendas);

    analyticsTracker = AnalyticsTracker.getAnalyticsTracker(this.getApplicationContext());
  }

  public void verLeyendaCadejos(View view) {
    Intent intent = new Intent(this, LecturaCuentoActivity.class);
//    getIdStory("1");

    intent.putExtra("storyBackground", R.drawable.cadejos);
    intent.putExtra("characterGif", R.drawable.cadejos_anim);
    intent.putExtra("id", "1");
    intent.putExtra("name", "El Cadejos");

    startActivity(intent);
  }

  public void verLeyendaCegua(View view) {
    Intent intent = new Intent(this, LecturaCuentoActivity.class);
//    getIdStory("2");

    intent.putExtra("storyBackground", R.drawable.cegua);
    intent.putExtra("characterGif", R.drawable.cegua_anim);
    intent.putExtra("id", "2");
    intent.putExtra("name", "La Cegua");

    startActivity(intent);
  }

  protected void onResume() {
    super.onResume();
    analyticsTracker.trackScreen("LeyendasActivity");
  }
}
