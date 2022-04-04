package ${YYAndroidPackageName};

//import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
//import android.widget.Toast;

public class WebviewActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView myWebView = new WebView(this);
        myWebView.setWebViewClient(new WebviewActivity.MyWebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebviewActivity.WebAppInterface(this), "Android");
        setContentView(myWebView);
        myWebView.loadUrl("file:///android_asset/client/index.html");
    }

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.equals("http://exit_me_now/")) {


                //view.removeAllViews();

                //view.clearHistory();

                // NOTE: clears RAM cache, if you pass true, it will also clear the disk cache.
                // Probably not a great idea to pass true if you have other WebViews still alive.
                //view.clearCache(true);

                // Loading a blank page is optional, but will ensure that the WebView isn't doing anything when you destroy it.
                //view.loadUrl("about:blank");

                //view.onPause();
                //view.removeAllViews();
                //view.destroyDrawingCache();

                // NOTE: This pauses JavaScript execution for ALL WebViews,
                // do not use if you have other WebViews still alive.
                // If you create another WebView after calling this,
                // make sure to call mWebView.resumeTimers().
                //view.pauseTimers();

                // NOTE: This can occasionally cause a segfault below API 17 (4.2)

                //view.destroy();
                ((Activity) view.getParent()).finish();

                // Null out the reference so that you don't end up re-using it.
                //view = null;
                //Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                // perform your action here
                return true;
            } else {
                view.loadUrl(url);
                return true;
            }
        }
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void close() {
            ((Activity) mContext).finish();
        }

        @JavascriptInterface
        public void closeWebview() {
            ((Activity) mContext).finishActivity(1);
        }

        @JavascriptInterface
        public void closeThis() {
            ((Activity) mContext).moveTaskToBack(false);
        }
    }
}