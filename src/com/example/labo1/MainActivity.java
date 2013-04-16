package com.example.labo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activit� principale de notre g�n�rateur de badge
 * 
 * Exercices possibles: 
 * - Ajouter un nouveau bouton qui lance une nouvelle activit� 
 * - Modifier l'appel � "About" afin de lui sp�cifier l'URL d�sir�	 
 * TODO: Traduire certain commentaires...
 * 
 * @author francois.legare1
 */
public class MainActivity extends Activity {

	/*
	 * GRANDE SECTIONS
	 * 
	 * - CONSTANTES ET VARIABLES
	 * - GESTION CYCLE DE VIE DE L'ACTIVITE 
	 * - INITIALISATION DE LA VUE 
	 * - ACTIONS
	 */

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// CONSTANTES ET VARIABLES
	//
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	// Cette constante est utile pour logger des informations
	private static final String TAG = MainActivity.class.getName();

	// References aux composantes de la vue pour utilisation dans
	// l'activit�
	private Button btSubmit;
	private EditText edName;

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// GESTION CYCLE DE VIE DE L'ACTIVITE
	//
	// Afin de voir les diff�rentes �tapes du cycle de vie d'une application
	// nous allons impl�menter toutes les m�thodes du cycle de vie de
	// l'application
	//
	// onCreate(Bundle savedInstanceState);
	// onStart();
	// onRestart();
	// onResume();
	// onPause();
	// onStop();
	// onDestroy();
	//
	// Pour les visuels:
	// http://developer.android.com/images/activity_lifecycle.png
	//
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Appel� lorsque l'activit� est cr�� pour la premi�re fois. C'est l� que vous devez
	 * initialis� la vue et mettre en place les composantes qui seront utilis� par votre
	 * activit�. La m�thode re�oit en param�tre un "bundle" qui contient
	 * les donn�es d'�tat sauvegard�s avant la destruction de l'activit�.
	 * Cette m�thode est toujour suivit de: onStart ()
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {			
		super.onCreate(savedInstanceState);
		
		/*
		 * On indique � notre activit� qu'elle doit charger ce fichier
		 * XML de layout pour s'afficher. On aurait �galement pus
		 * cr�er nous m�me la vue en code au besoin.
		 */
		setContentView(R.layout.activity_main);

		/*
		 * Afin de voir le cycle de vie d'une activit� Nous allons laisser des
		 * traces dans les log sur tout les �v�nements principaux du cycle de
		 * vie de l'application
		 */
		Log.d(TAG, "onCreate");

		/*
		 * Pour les activit�s complexe, la gestion de la vue peut prendre
		 * beaucoup de code pour simplement "mapper" les composantes de la vue
		 * et le code. Comme ce code est souvent long il est recommand� de
		 * l'isoler dans une m�thode utilitaire. Ceci est compl�tement
		 * facultatif!
		 */
		init();
	}
	
		
	/* 
	 * Called after your activity has been stopped, prior to it being started again.
	 * Always followed by onStart()
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
	}
	
	/* 
	 * Called when the activity is becoming visible to the user.
	 * Followed by onResume() if the activity comes to the foreground, or onStop()
	 * if it becomes hidden.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}
	
	/* 
	 * Called when the activity will start interacting with the user. 
	 * At this point your activity is at the top of the activity stack,
	 * with user input going to it.
	 * Always followed by onPause().
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onRestart");
	}
	
	/* 
	 * Called when the system is about to start resuming a previous activity. 
	 * This is typically used to commit unsaved changes to persistent data, 
	 * stop animations and other things that may be consuming CPU, etc. 
	 * Implementations of this method must be very quick because the next 
	 * activity will not be resumed until this method returns.
	 * Followed by either onResume() if the activity returns back to the front, 
	 * or onStop() if it becomes invisible to the user.
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}
	
	/* 
	 * Called when the activity is no longer visible to the user, because
	 * another activity has been resumed and is covering this one. 
	 * This may happen either because a new activity is being started, an existing
	 * one is being brought in front of this one, or this one is being destroyed.
	 * Followed by either onRestart() if this activity is coming back to interact
	 * with the user, or onDestroy() if this activity is going away.
	 */
	@Override
	protected void onStop() {
		super.onPause();
		Log.d(TAG, "onStop");
	}
	
	/* 
	 * The final call you receive before your activity is destroyed.
	 * This can happen either because the activity is finishing 
	 * (someone called finish() on it, or because the system is temporarily
	 * destroying this instance of the activity to save space.
	 * You can distinguish between these two scenarios with the isFinishing() method.
	 * (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onPause();
		Log.d(TAG, "onDestroy");
	}
	

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// INITIALISATION DE LA VUE
	//
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Cette m�thode s'occupe de retrouver les identifiants des composantes
	 * cr�ees dans le xml et au besoin ajoute des "listeners"
	 */
	private void init() {
		/*
		 * La m�thode findViewById fait la jonction entre la vue xml et le code.
		 * On doit caster la View selon le type de composante. On pourrait
		 * utiliser RoboGuice afin de faciliter ce genre de travail :
		 * https://github.com/roboguice/roboguice
		 */
		edName = (EditText) findViewById(R.id.main_edt_name);
		btSubmit = (Button) findViewById(R.id.main_bt_submit);

		/*
		 * On applique un click Listener � ce boutton qui sera ex�cuter quand
		 * l'usager appuie sur le bouton. Il existe plusieurs type de listener
		 * disponible sur une composante View.
		 * 
		 * Voir: http://developer.android.com/reference/android/view/View.html
		 * 
		 * On utilise frequement des classes anonymes sous android pour faire ce
		 * genre d'actions.
		 */
		btSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				/*
				 * On utilise frequement des classes anonymes pour g�rer le code
				 * du listener le plus propre reste d'ex�cuter une m�thode �
				 * l'ext�rieur de cette classe afin de maximiser la
				 * r�utilisation et la lecture du code.
				 */
				launchBadgeActivity();
			}
		});

	}

	/**
	 * Lance l'activit� BadgeActivity
	 */
	private void launchBadgeActivity() {
		/*
		 * On utilise un intent pour lancer une autre activit�. Pour ce faire on
		 * indique la classe que l'on d�sire ex�cuter. Les intents peuvent
		 * �galement lancer des activit� qui ne font pas parti de notre
		 * application.
		 */
		Intent i = new Intent(this, BadgeActivity.class);

		/*
		 * L'intent peut �galement contenir des param�tres qui seront re�ues par
		 * l'activit� cible. Pour ce faire on encapsule dans des "extras". Dans
		 * l'exemple ci-dessou on capture le nom de l'usager pr�sent dans le
		 * EditText
		 */

		String nomUsager = "" + edName.getText();
		i.putExtra(BadgeActivity.INTENT_EXTRA_NAME_OF_USER, nomUsager);

		/*
		 * On lance l'intent dans le "BUS", l'OS s'occupera d'ex�cuter celle-ci
		 */
		startActivity(i);
	}
	
	
	// /////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// ACTIONS
	//
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * On a vu comment lancer une activit� via un click listener sur le bouton.
	 * Voici maintenant une technique beaucoup plus simple. Il s'agit de d�finir
	 * le nom de la m�thode a ex�cuter directement dans la vue XML via
	 * l'attribut onClick
	 * 
	 * Regarder le fichier activity_main.xml et regarder le bouton
	 * "main_bt_about" on y retrouve notre m�thode "launchAboutActivity"
	 * 
	 * Pour que cette technique fonctionne, il faut les conditions suivantes:
	 * 
	 * 1) Le nom onClick correspont � cette m�thode 
	 * 2) La m�thode est publique
	 * 3) La m�thode a View en param�tre d'entr� 
	 * 4) La m�thode retourne Void
	 * 
	 */
	public void launchAboutActivity(View v) {
		startActivity(new Intent(this, AboutActivity.class));
	}

	/**
	 * M�thode pour lancer l'activit� de la config
	 */
	public void launchConfigActivity(View v) {
		startActivity(new Intent(this, ConfigActivity.class));
	}

}
