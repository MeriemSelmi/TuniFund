package tn.startupfactory.tunifund.copy;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.interfaceM.InscriptionActivity;
import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactory.tunifund.session.ApplicationSession;
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
	ApplicationSession appSession;
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
		if (name.equals("") || description.equals("")||amount.equals("")||country.equals("")||dayToGo.equals("")||theme.equals("")) {
			Toast.makeText(AddProjectActivity.this,
					"Les champs sont obligatoires",
					Toast.LENGTH_SHORT).show();
			return;
		}
		
		ProjectService projectService = ProjectMock.getInstance();
		Project project=new Project(name.getText().toString(),description.getText().toString(),Double.valueOf(amount.getText().toString()),Integer.parseInt(dayToGo.getText().toString()),theme.getText().toString(),new User(),country.getText().toString());
		String userid = appSession.getId();		
		projectService.add(Integer.parseInt(userid), project);
		Toast.makeText(AddProjectActivity.this,"projet ajouté!",Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(AddProjectActivity.this,HomeActivity.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_project, menu);
		return true;
	}

}
