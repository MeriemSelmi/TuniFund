package tn.startupfactory.tunifund;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.User;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ProfileActivity extends Activity {

	TextView project,information,donation;
	String name,lastname,cin,email,password,address,telephone, fundedProjects, donatedProjects;
	User user;
	ProjectService projectMock;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		project = (TextView)findViewById(R.id.project);
		information = (TextView)findViewById(R.id.information);
		donation = (TextView)findViewById(R.id.donation);
		
		UserMock userMock = UserMock.getInstance();
		int id = getIntent().getExtras().getInt("idUser");
		user  = userMock.getById(id);
		information.setText("");
		information.append(user.getName() + " " + user.getLastName()+ "\n");
		information.append("CIN : " + user.getCin()+ "\n");
		information.append("FROM : " + user.getAddress()+ "\n");
		information.append("Telephone : " + user.getTelephone()+ "\n");
		information.append("Email : " + user.getEmail()+ "\n");
		information.append("Credit : " + user.getAccount()+ "DT \n");
		
		fundedProjects = "";
		for (Project project : user.getFundedProjects()) {
			fundedProjects += project.getName()+"\n";
		}
		
		project.append("\n" +fundedProjects);
		Iterator it = user.getDonatedProjects().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        donatedProjects += pairs.getKey() + " : " + pairs.getValue() + "\n";
	    }
	    
	    donation.append("\n" + donatedProjects);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}