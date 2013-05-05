package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import tn.startupfactory.tunifund.session.ApplicationSession;
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

public class DonateActivity extends Activity implements View.OnClickListener {

	Button donate;
	RadioGroup radioDonations;
	EditText amountText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);

		donate = (Button) findViewById(R.id.donate);
		donate.setOnClickListener(this);
		amountText = (EditText) findViewById(R.id.amount);
		
		
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
		String amount = amountText.getText().toString(); 

		Intent intent=new Intent(DonateActivity.this,PdfActivity.class);		
		intent.putExtra("choice",selected);
		intent.putExtra("amount",amount);
		startActivity(intent);
		
	}

}
