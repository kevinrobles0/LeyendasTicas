package cr.ac.tec.lectuticas.Utilities;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import cr.ac.tec.lectuticas.R;

public class AnalyticsTracker extends Application {
  
  static AnalyticsTracker analyticsTracker = null;
  Tracker tracker;
  
  public AnalyticsTracker(Context context) {
    GoogleAnalytics analytics = GoogleAnalytics.getInstance(context.getApplicationContext());
    tracker = analytics.newTracker(R.xml.global_tracker);
  }
  
  public static AnalyticsTracker getAnalyticsTracker(Context context) {
    if (analyticsTracker == null)
      analyticsTracker = new AnalyticsTracker(context);
    return analyticsTracker;
  }
  
  public void trackScreen(String screenName) {
    Log.i(screenName, "Setting screen name: " + screenName);
    tracker.setScreenName(screenName);
    tracker.send(new HitBuilders.ScreenViewBuilder().build());
  }
  
  public void trackEvent(String category, String action, String label) {
    tracker.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
  }


}

