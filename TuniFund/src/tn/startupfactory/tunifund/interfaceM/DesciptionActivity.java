package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.HomeActivity;
import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactory.tunifund.session.ApplicationSession;
import tn.startupfactoy.tunifund.domain.Project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class DesciptionActivity extends SherlockActivity implements
		View.OnClickListener {

	TextView proj, category, funded, pledged, to_go, required, text_descrip;
	ImageView project_image;
	ProjectService projectMock;
	Project project;
	Button donate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desciption_projet);

		proj = (TextView) findViewById(R.id.projet);
		category = (TextView) findViewById(R.id.categorie);
		funded = (TextView) findViewById(R.id.funded);
		pledged = (TextView) findViewById(R.id.pledged);
		to_go = (TextView) findViewById(R.id.to_go);
		required = (TextView) findViewById(R.id.required);
		text_descrip = (TextView) findViewById(R.id.text_descrip);
		project_image = (ImageView) findViewById(R.id.image);
		donate = (Button) findViewById(R.id.donate);

		projectMock = ProjectMock.getInstance();
		
		int id = getIntent().getExtras().getInt("idProject");
		project = projectMock.getById(id);

		proj.append(project.getName());
		category.append(project.getTheme());
		funded.append(project.getFundedPercentage() + "");
		pledged.append(project.getPledged() + "");
		to_go.append(project.getDaysToGo() + "");
		required.append(project.getRequired() + "");
		text_descrip.setText(project.getDescription() + "");
		project_image.setImageResource(project.getImage());
		donate.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(DesciptionActivity.this,DonateActivity.class);
		if(ApplicationSession.getId()!=""){
			intent.putExtra("idUser", Integer.parseInt(ApplicationSession.getId()));
		}
		intent.putExtra("idProject", project.getId());
		startActivity(intent);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		String userid = appSession.getId();
		if (userid.equals("")) {
			getSupportMenuInflater().inflate(R.menu.action_bar_disconnected, menu);
			return true;
		}
		else{
			getSupportMenuInflater().inflate(R.menu.action_bar_connected, menu);
			return true;
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.sign_in:		
			Toast.makeText(DesciptionActivity.this, "", Toast.LENGTH_SHORT).show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
