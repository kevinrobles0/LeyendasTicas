package cr.ac.tec.lectuticas.Utilities;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Esteban Fonseca on 15/4/2017.
 */
public class WebServiceCaller {

  private final static String WEB_SERVICE_URL = "http://kivucr.com/LectuTicas/";

  private WebServiceCaller() {
  }

  private static String executeGetRequest(Context context, String requestUrl) throws Exception {
    try {
      return new WebServiceHandler(context, requestUrl).execute().get();
    } catch (Exception e) {
      Log.e(WebServiceCaller.class.getSimpleName(), e.getMessage());
      throw e;
    }
  }

  public static String doGetRequest(Context context, String resourcePath,
      Map<String, String> params)
      throws Exception {
    StringBuilder stringBuilder = new StringBuilder(WEB_SERVICE_URL);
    stringBuilder.append(resourcePath);
    stringBuilder.append("?");

    Set<String> paramsKeys = params.keySet();
    Iterator<String> iterator = paramsKeys.iterator();

    while (iterator.hasNext()) {
      String paramKey = iterator.next();
      stringBuilder.append(paramKey).append("=").append(params.get(paramKey));
      if (iterator.hasNext()) {
        stringBuilder.append("&");
      }
    }
    String requestUrl = stringBuilder.toString();
    try {
      return executeGetRequest(context, requestUrl);
    } catch (Exception e) {
      throw e;
    }
  }
}
