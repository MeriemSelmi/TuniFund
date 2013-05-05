package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.HomeActivity;
import tn.startupfactory.tunifund.R;
<<<<<<< HEAD
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.User;
=======
>>>>>>> dc1bd705c12396f4645d3a33d251b4fcf187dc92
import tn.startupfactory.tunifund.session.ApplicationSession;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
<<<<<<< HEAD
=======

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
>>>>>>> dc1bd705c12396f4645d3a33d251b4fcf187dc92

public class DonateActivity extends SherlockActivity implements View.OnClickListener {

	Button donate;
	RadioGroup radioDonations;
	ProjectMock projectMock;
	int idUser;
	int idProject;
	double donation;
	EditText amountText;
	ApplicationSession appSession;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);

		donate = (Button) findViewById(R.id.donate);
		donate.setOnClickListener(this);
		amountText = (EditText) findViewById(R.id.amount);
		
		idProject = getIntent().getExtras().getInt("idProject");
		idUser = getIntent().getExtras().getInt("idUser");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		int userid = ApplicationSession.getInstance().getSession();
		if (userid<0) {
			getSupportMenuInflater().inflate(R.menu.action_bar_disconnected, menu);
			return true;
		}
		else{
			getSupportMenuInflater().inflate(R.menu.action_bar_connected, menu);
			return true;
		}
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
			donation = Double.parseDouble(((EditText) findViewById(R.id.amount)).getText().toString());
			Log.d("eeee" , donation+"");
			projectMock = ProjectMock.getInstance();
			projectMock.donate(1, idProject, donation); ////////////////////:
			Intent intent=new Intent(DonateActivity.this,PdfActivity.class);
			intent.putExtra("idProject", idProject);
			intent.putExtra("idUser", 1);
			intent.putExtra("donation", donation);
			Log.d("donate", UserMock.getInstance().getById(1).getAccount()+""); /////////////////////
			startActivity(intent);
		}catch(Exception e){
			Toast.makeText(getApplicationContext(), "Please enter a numeric value", Toast.LENGTH_LONG);
		}
		
	}
		@Override
		public boolean onOptionsItemSelected(MenuItem item){
			switch (item.getItemId()) {
			case R.id.homeD:		
				Toast.makeText(DonateActivity.this, "Home", Toast.LENGTH_SHORT).show();
				Intent mIntent = new Intent(DonateActivity.this,
						HomeActivity.class);
				DonateActivity.this.startActivity(mIntent);
				return true;
			case R.id.sign_in:return true;
			default:
				return super.onOptionsItemSelected(item);
			}
			
		}
	}


