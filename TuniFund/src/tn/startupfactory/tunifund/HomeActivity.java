package tn.startupfactory.tunifund;

import java.util.List;
import java.util.Vector;

import tn.startupfactory.tunifund.adapter.ViewPagerAdapter;
import tn.startupfactory.tunifund.fragments.AllFragment;
import tn.startupfactory.tunifund.fragments.NewFragment;
import tn.startupfactory.tunifund.fragments.PopularFragment;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class HomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//getActionBar().hide();
		
		
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this,
				NewFragment.class.getName()));
		fragments
				.add(Fragment.instantiate(this, PopularFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,
				AllFragment.class.getName()));
		
		ViewPagerAdapter adapter = new ViewPagerAdapter(
				super.getSupportFragmentManager(), fragments);
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		pager.setAdapter(adapter);

		pager.setOffscreenPageLimit(2);
		pager.setCurrentItem(3);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
