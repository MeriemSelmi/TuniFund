
package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class AuthentificationActivity extends Activity implements
		View.OnClickListener {
	EditText cin, pass;
	Button valider, inscription;

	@Override
	public void onCreate(Bundle savedInstanceState) {
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
			// ****validation des login et de mot de passe

			// récupérer l'utilisateur s'il existe avec le login et le mot de
			// passe entrés
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
						"Authentification non valide!", Toast.LENGTH_LONG)
						.show();
			} else {

				String nom = user.getName();

				/*
				 * Intent intent = new Intent(AuthentificationActivity.this,
				 * ActivitySuiv.class); // intent.putExtra("nom",nom);
				 * startActivity(intent);
				 * 
				 * } } else if (v == inscription) { Intent intent = new
				 * Intent(AuthentificationActivity.this,
				 * InscriptionActivity.class); startActivity(intent);
				 */

			}

		}

	}
}

