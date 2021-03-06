package tn.startupfactory.tunifund;

import java.util.List;
import java.util.Vector;


import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.adapter.MyPagerAdapter;
import tn.startupfactory.tunifund.fragments.AllFragment;
import tn.startupfactory.tunifund.fragments.NewFragment;
import tn.startupfactory.tunifund.fragments.PopularFragment;
import tn.startupfactory.tunifund.interfaceM.AuthentificationActivity;
import tn.startupfactory.tunifund.interfaceM.DesciptionActivity;
import tn.startupfactory.tunifund.session.ApplicationSession;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
public class HomeActivity extends SherlockFragmentActivity {

	private PagerAdapter mPagerAdapter;
	ApplicationSession appSession;
	public static Context HomeContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.viewpager);
		
		HomeContext = getApplicationContext();
		appSession = ApplicationSession.getInstance();
		List<Fragment> fragments = new Vector<Fragment>();

		fragments.add(Fragment.instantiate(this,NewFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, PopularFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,AllFragment.class.getName()));
		

	
		this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

		
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		pager.setAdapter(this.mPagerAdapter);
		pager.setOffscreenPageLimit(4);
		pager.setCurrentItem(3);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		int userid = ApplicationSession.id;
		if (userid <0) {
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
			//Toast.makeText(HomeActivity.this, "Sign in", Toast.LENGTH_SHORT).show();
			Intent mIntent = new Intent(HomeActivity.this,
					AuthentificationActivity.class);
			HomeActivity.this.startActivity(mIntent);
			return true;
			
		

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
}