package tn.startupfactory.tunifund.interfaceM;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.R.layout;
import tn.startupfactory.tunifund.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DesciptionActivity extends Activity {
	
	TextView categorie,funded,pledged,to_go,required,text_descrip;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desciption_projet);
		
		categorie=(TextView)findViewById(R.id.categorie);
		funded=(TextView)findViewById(R.id.funded);
		pledged=(TextView)findViewById(R.id.pledged);
		to_go=(TextView)findViewById(R.id.to_go);
		required=(TextView)findViewById(R.id.required);
		text_descrip=(TextView)findViewById(R.id.text_descrip);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.desciption, menu);
		return true;
	}

}
