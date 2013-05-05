package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DonateActivity extends Activity implements View.OnClickListener {

	Button donate;
	RadioGroup radioDonations;
	ProjectMock projectMock;
	int idUser;
	int idProject;
	double donation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);

		donate = (Button) findViewById(R.id.donate);
		donate.setOnClickListener(this);
		
		idProject = getIntent().getExtras().getInt("idProject");
		idUser = getIntent().getExtras().getInt("idUser");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		radioDonations = (RadioGroup) findViewById(R.id.radioDonations);
		int idSelected = radioDonations.getCheckedRadioButtonId();
		RadioButton radioButton = (RadioButton) radioDonations.findViewById(idSelected);
		String selected = (String) radioButton.getText();
		Log.d("aaaaaaaaaaaaaaaaaaaaaaaa" , selected);
		try{
			donation = Double.parseDouble(((EditText) findViewById(R.id.donation)).getText().toString());
			Log.d("eeee" , donation+"");
			projectMock = ProjectMock.getInstance();
			projectMock.donate(1, idProject, donation); ////////////////////:
			Intent intent=new Intent(DonateActivity.this,PdfActivity.class);
			intent.putExtra("idProject", idProject);
			intent.putExtra("idUser", idUser);
			intent.putExtra("donation", donation);
			Log.d("donate", UserMock.getInstance().getById(1).getAccount()+""); /////////////////////
			startActivity(intent);
		}catch(Exception e){
			Toast.makeText(getApplicationContext(), "Please enter a numeric value", Toast.LENGTH_LONG);
		}
		
	}

}
