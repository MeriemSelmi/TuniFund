package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.HomeActivity;
import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.servicemock.ProjectMock;
import tn.startupfactory.tunifund.servicemock.UserMock;
import tn.startupfactory.tunifund.session.ApplicationSession;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class DonateActivity extends SherlockActivity implements View.OnClickListener {

	Button donate;
	RadioGroup radioDonations;
	ProjectMock projectMock;
	int idUser;
	int idProject;
	double donation;
	EditText amountText, actifText;
	ApplicationSession appSession;
	String actif;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);

		donate = (Button) findViewById(R.id.donate);
		donate.setOnClickListener(this);
		amountText = (EditText) findViewById(R.id.amount);
		actifText = (EditText) findViewById(R.id.amount);
		idProject = getIntent().getExtras().getInt("idProject");
		idUser = ApplicationSession.id;
		
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
		actif = actifText.getText().toString();
	//	String selected = (String) radioButton.getText();
		Log.d("aaaaaaaaaaaaaaaaaaaaaaaa" , idUser+"");
		try{
			if ("".equals(actif)) {
				Toast.makeText(DonateActivity.this,
						"Please provide all the informations",
						Toast.LENGTH_SHORT).show();
				return;
			}
			else
			{
			donation = Double.parseDouble(actif);
			Log.d("eeee" , donation+"");
			projectMock = ProjectMock.getInstance();
			projectMock.donate(idUser, idProject, donation); ////////////////////:
			Log.d("aaaaaaaaaaaaaaaaaaaaaaaa" , idUser+"");
			Intent intent=new Intent(DonateActivity.this,PdfActivity.class);
			intent.putExtra("idProject", idProject);
			Log.d("aaaaaaaaaaaaaaaaaaaaaaaa" , idUser+"");
			intent.putExtra("donation", donation);
			Log.d("donate", UserMock.getInstance().getById(idUser).getAccount()+""); /////////////////////
			startActivity(intent);
		}
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


