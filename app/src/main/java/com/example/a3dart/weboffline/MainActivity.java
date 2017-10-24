package com.example.a3dart.weboffline;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView= (WebView)findViewById(R.id.webView);

        webView.getSettings().setAppCacheMaxSize(200*1024*1024 ); // 200MB
        webView.getSettings().setAppCachePath( getApplicationContext().getCacheDir().getAbsolutePath() );
        webView.getSettings().setAllowFileAccess( true );
        webView.getSettings().setAppCacheEnabled( true );
        webView.getSettings().setJavaScriptEnabled( true );
        //   webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT ); // load online by default
        if ( !isNetworkAvailable() ) { // loading offline
            webView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }

        webView.setVerticalScrollBarEnabled(false);
//This statement hides the Vertical scroll bar and does not remove it.

        webView.setHorizontalScrollBarEnabled(false);
//This statement hides the Horizontal scroll bar and does not remove it.

        webView.loadUrl("http://3dartvn.com/submission/lavita/360/250717/");
//This statement hides the scroll bar and does not remove it.
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}