package tn.startupfactory.tunifund.interfaceM;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tutos.android.ui.MainActivity;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InscriptionActivity extends Activity implements View.OnClickListener{
	EditText cin,name,lastname,email,telephone,address,password;
	ImageButton valider,annuler;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        
        cin=(EditText)findViewById(R.id.cin);
        name=(EditText)findViewById(R.id.name);
        lastname=(EditText)findViewById(R.id.lastname);
        email=(EditText)findViewById(R.id.email);
        telephone=(EditText)findViewById(R.id.telephone);
        address=(EditText)findViewById(R.id.address);
        password=(EditText)findViewById(R.id.pass);
        valider=(ImageButton)findViewById(R.id.valid);
        annuler=(ImageButton)findViewById(R.id.annuler);
        
        valider.setOnClickListener(this);
        annuler.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		
		UserService userBdd= UserMock.getInstance();
		if(v==valider)
		{
			//cr�er un nouveau utilisateur
			User user = new User(cin.getText().toString(),name.getText().toString(),lastname.getText().toString(),email.getText().toString(),telephone.getText().toString(),address.getText().toString(),password.getText().toString());
			if (cin.equals("") || name.equals("")||lastname.equals("")||email.equals("")||telephone.equals("")||address.equals("")||password.equals("")) {
				Toast.makeText(InscriptionActivity.this,
						"Les champs sont obligatoires",
						Toast.LENGTH_SHORT).show();
				return;
			}

			// On d�clare le pattern que l�on doit suivre
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			// On d�clare un matcher, qui comparera le pattern avec la
			// string pass�e en argument
			Matcher m = p.matcher(email.toString());
			// Si l�adresse mail saisie ne correspond au format d�une
			// adresse mail
			if (!m.matches()) {
				// Toast est une classe fournie par le SDK Android
				// pour afficher les messages dans des minis pop up
				// Le premier argument est le Context, puis
				// le message et � la fin la dur�e de ce dernier
				Toast.makeText(InscriptionActivity.this,
						"Le champs email ne correspond pas au format d'une adresse mail", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			
			
			//ouvrir la base des donn�es
			userBdd.add(user);
			//insertion
			long i=userBdd.add(user);
			if(i>=0)
				
			Toast.makeText(InscriptionActivity.this,"utilisateur ajout�!",Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(InscriptionActivity.this,"probl�me d'ajout!",Toast.LENGTH_SHORT).show();	
			
			Intent intent=new Intent(InscriptionActivity.this,ActivitySuivante.class);
			startActivity(intent);
			
		}
		if(v==annuler)
		{
			Intent intent=new Intent(InscriptionActivity.this,ActivitySuivante.class);
			startActivity(intent);
			
		}
	}

}
