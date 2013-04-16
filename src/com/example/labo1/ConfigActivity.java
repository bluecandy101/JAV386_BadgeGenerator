package com.example.labo1;

import java.util.Map;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Cette activit� s'occupe de la configuration de l'application via un fichier
 * de p�f�rence.
 * 
 * @author francois.legare1
 * 
 */
public class ConfigActivity extends PreferenceActivity {

	private static final String TAG = ConfigActivity.class.getName();

	@SuppressWarnings("deprecation")
	// Afin de rester compatible avec Android 2.x+
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.config_preferences);
	}

	/**
	 * Petite methode pour v�rifier les valeurs en debug
	 */
	public void showConfigInDebug() {

		/*
		 * Le share preference permet de sauver et charger rapidement des
		 * donn�es pour votre application �videment, si vous avez beaucoup de
		 * donner il serait pr�f�rable d'utiliser une base de donn�e sql light
		 */
		SharedPreferences pm = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		Map<String, ?> keys = pm.getAll();
		for (Map.Entry<String, ?> e : keys.entrySet()) {
			Log.d(TAG, e.getKey() + ": " + e.getValue().toString());
		}
	}	
}