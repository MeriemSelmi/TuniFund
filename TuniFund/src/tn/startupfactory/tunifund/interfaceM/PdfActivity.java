package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PdfActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdf);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdf, menu);
		return true;
	}

}
