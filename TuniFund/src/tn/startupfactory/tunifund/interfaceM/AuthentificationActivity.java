
package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.HomeActivity;
import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactory.tunifund.session.ApplicationSession;
import tn.startupfactoy.tunifund.domain.User;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class AuthentificationActivity extends SherlockActivity implements
		View.OnClickListener {
	EditText cin, pass;
	Button valider, inscription;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authentification);
		cin = (EditText) findViewById(R.id.cin);
		pass = (EditText) findViewById(R.id.pass);
		valider = (Button) findViewById(R.id.valid);
		inscription = (Button) findViewById(R.id.inscri);
		valider.setOnClickListener(this);
		inscription.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		UserService userBdd = UserMock.getInstance();
		if (v == valider) {
			if ("".equals(cin) || "".equals(pass)) {
				Toast.makeText(AuthentificationActivity.this,
						"Please give your CIN and password", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			User user = userBdd.login(cin.getText().toString(), pass.getText()
					.toString());
			if (user == null) {
				Toast.makeText(AuthentificationActivity.this,
						"Your CIN/password is wrong", Toast.LENGTH_LONG)
						.show();
			} 
			
			
			else {
				Log.d("taag", ""+user.getId());
				ApplicationSession.id=user.getId();
				Intent intent = new Intent(AuthentificationActivity.this, HomeActivity.class);
				startActivity(intent);
				
			}

		}else if(v == inscription){
			Intent intent = new Intent(AuthentificationActivity.this, InscriptionActivity.class);
			AuthentificationActivity.this.startActivity(intent);
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		if(ApplicationSession.getInstance().getSession()<0){
		getSupportMenuInflater().inflate(R.menu.action_bar_disconnected, menu);}
		else{
			getSupportMenuInflater().inflate(R.menu.action_bar_connected, menu);}
			
		
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		Intent mIntent;
		switch (item.getItemId()) {
		case R.id.homeD:		
			Toast.makeText(AuthentificationActivity.this, "Home", Toast.LENGTH_SHORT).show();
			mIntent = new Intent(AuthentificationActivity.this,
					HomeActivity.class);
			AuthentificationActivity.this.startActivity(mIntent);
			return true;
		case R.id.sign_in:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	
}

