
package tn.startupfactory.tunifund.interfaceM;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import tn.startupfactory.tunifund.HomeActivity;
import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactory.tunifund.session.ApplicationSession;
import tn.startupfactoy.tunifund.domain.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.view.View;

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
			User user = userBdd.login(cin.getText().toString(), pass.getText()
					.toString());

			if (cin.equals("") || pass.equals("")) {
				Toast.makeText(AuthentificationActivity.this,
						"Les champs sont obligatoires", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			if (user == null) {
				Toast.makeText(AuthentificationActivity.this,
						"Your CIN/password is wrong", Toast.LENGTH_LONG)
						.show();
			} else {

				ApplicationSession.getInstance().setSession(user.getId());
				Intent intent = new Intent(AuthentificationActivity.this, HomeActivity.class);
				startActivity(intent);
				
			}

		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		getSupportMenuInflater().inflate(R.menu.action_bar_disconnected, menu);
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.homeD:		
			Toast.makeText(AuthentificationActivity.this, "Home", Toast.LENGTH_SHORT).show();
			Intent mIntent = new Intent(AuthentificationActivity.this,
					HomeActivity.class);
			AuthentificationActivity.this.startActivity(mIntent);
			return true;
		case R.id.sign_in:return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	
}

