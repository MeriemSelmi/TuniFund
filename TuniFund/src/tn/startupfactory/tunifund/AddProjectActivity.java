package tn.startupfactory.tunifund;

import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProjectActivity extends Activity {
	EditText name;
	EditText description;
	EditText amount;
	EditText country;
	EditText dayToGo;
	EditText theme;
	Button valider;
	Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_project);
		
		name=(EditText)findViewById(R.id.projectName);
		description=(EditText)findViewById(R.id.projectDescription);
		amount=(EditText)findViewById(R.id.projectAmount);
		country=(EditText)findViewById(R.id.projectCountry);
		dayToGo=(EditText)findViewById(R.id.projectDaysToGo);
		theme=(EditText)findViewById(R.id.projectTheme);

	}
	
	public void addProject(View v){
		ProjectService ProjectService = ProjectMock.getInstance();
		Project project=new Project(name.getText().toString(),description.getText().toString(),Double.valueOf(amount.getText().toString()),Integer.parseInt(dayToGo.getText().toString()),theme.getText().toString(),new User(),.getText().toString());
		Toast.makeText(InscriptionActivity.this,"projet ajouté!",Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(InscriptionActivity.this,MainActivity.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_project, menu);
		return true;
	}

}
