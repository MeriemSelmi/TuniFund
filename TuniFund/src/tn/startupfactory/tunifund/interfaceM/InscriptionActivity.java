package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends Activity implements View.OnClickListener{
	EditText cin,name,lastname,email,telephone,address,password;
	Button valider,annuler;
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
        valider=(Button)findViewById(R.id.valid);
        annuler=(Button)findViewById(R.id.annuler);
        
        valider.setOnClickListener(this);
        annuler.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		
		UserService userBdd= UserMock.getInstance();
		if(v==valider)
		{
			//créer un nouveau utilisateur
			User user = new User(cin.getText().toString(),name.getText().toString(),lastname.getText().toString(),email.getText().toString(),telephone.getText().toString(),address.getText().toString(),password.getText().toString());
			if ("".equals(cin) || "".equals(name)||"".equals(lastname)||"".equals(email)||"".equals(telephone)||"".equals(address)||"".equals(password)) {
				Toast.makeText(InscriptionActivity.this,
						"Please provide all the informations",
						Toast.LENGTH_SHORT).show();
				return;
			}
		
			long i=userBdd.add(user);
			if(i>=0){
				Toast.makeText(InscriptionActivity.this,"You have been added successfully",Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(InscriptionActivity.this,AuthentificationActivity.class);
				startActivity(intent);
			}
			else
				Toast.makeText(InscriptionActivity.this,"This CIN already exists",Toast.LENGTH_SHORT).show();	
			
		}
		if(v==annuler){
			Intent intent=new Intent(InscriptionActivity.this,AuthentificationActivity.class);
			startActivity(intent);
		}
	}

}

