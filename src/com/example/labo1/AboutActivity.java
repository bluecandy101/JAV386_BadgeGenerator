package com.example.labo1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Une simple vue qui affiche du contenu web
 * 
 * @author francois.legare1
 */

@SuppressLint("SetJavaScriptEnabled")
public class AboutActivity extends Activity {

	private static final String TAG = AboutActivity.class.getName();
	private WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		init();
	}

	/**
	 * Nous allons initialiser la vue dans cette m�thode
	 */
	private void init() {

		/*
		 * Une webview est comme un petit fureteur internet qui consome et
		 * affiche du html. Les sources du html peuvent �tre un fichier local ou
		 * sur le net.
		 * 
		 * Dans le deuxi�me cas, il ne faut pas oublier de mettre la permission
		 * INTERNET dans le manifest pour que ceci soit fonctionnel!
		 */

		wv = (WebView) findViewById(R.id.about_webview);
		wv.loadUrl("http://twitter.github.io/bootstrap/examples/starter-template.html");
		wv.setWebViewClient(new WebViewClient() {

			// On va capturer un timestam pour voir la rapiditer d'ex�cution
			private long ts;

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				Log.d(TAG, "Loaded in: " + (System.currentTimeMillis() - ts));
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				ts = System.currentTimeMillis();
			}
		});

		// Permet l'ex�cution de javascript, attention aux risques de Cross-site
		// scripting (XSS)
		wv.getSettings().setJavaScriptEnabled(true);

	}

	@Override
	public void onBackPressed() {
		// On quitte cette activit� seulement si la webview peut
		// revenir en arriere.
		if (wv.canGoBack()) {
			wv.goBack();
		} else {
			super.onBackPressed();
		}
	}

}
