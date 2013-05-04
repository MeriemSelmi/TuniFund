package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DesciptionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desciption_projet);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.desciption, menu);
		return true;
	}

}
