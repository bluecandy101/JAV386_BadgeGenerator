package com.example.labo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activit� principale de notre g�n�rateur de badge
 * 
 * @author francois.legare1
 *
 */
public class MainActivity extends Activity {
		
    private Button btSubmit;
	private EditText edName;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_main);       
        //On appel notre m�thode au d�marrage de l'activit�
        init();        
    }

    /**
     * Nous allons initialiser la vue dans cette m�thode
     */
    private void init() {
    	//on retrouve le boutton de la vue
    	btSubmit = (Button)findViewById(R.id.main_bt_submit);
    	//On applique un click Listener � ce boutton
    	btSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("MainActiviy", "Boutton activ�");
				createBadge();
			}
		});
    	    	
    	edName = (EditText)findViewById(R.id.main_edt_name);    	    	        	    
	}
             
	/**
	 * Lance la nouvelle activit� avec le nom dans l intent
	 */
	private void createBadge() {		
		Intent i = new Intent(this, BadgeActivity.class);
		i.putExtra(BadgeActivity.INTENT_EXTRA_NAME_OF_USER, ""+edName.getText());			
		startActivity(i);
	}
	
		
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
	/**
	 * Methode appeller par le boutton About
	 * le mapping ce fait via le onClick attribute
	 * du xml. Cette m�thode doit:
	 * 1) �tre publique
	 * 2) recevoir une vue en parametre
	 * 3) retourner void
	 */
	public void launchAboutActivity(View v) {
		startActivity(new Intent(this,AboutActivity.class));		
	}
	
	/**
	 * Methode pour lancer l'activit� de la config
	 */
	public void launchConfigActivity(View v) {
		startActivity(new Intent(this,ConfigActivity.class));		
	}
    
}
