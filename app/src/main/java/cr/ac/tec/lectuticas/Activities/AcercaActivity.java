package cr.ac.tec.lectuticas.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cr.ac.tec.lectuticas.R;
import cr.ac.tec.lectuticas.Utilities.AnalyticsTracker;

public class AcercaActivity extends AppCompatActivity {

  private AnalyticsTracker analyticsTracker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_acerca);

    analyticsTracker = AnalyticsTracker.getAnalyticsTracker(this.getApplicationContext());
  }

  protected void onResume() {

    super.onResume();
    analyticsTracker.trackScreen("AcercaActivity");
  }
}
