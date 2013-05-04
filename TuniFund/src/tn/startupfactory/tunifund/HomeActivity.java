package tn.startupfactory.tunifund;

import java.util.List;
import java.util.Vector;


import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.adapter.MyPagerAdapter;
import tn.startupfactory.tunifund.fragments.AllFragment;
import tn.startupfactory.tunifund.fragments.NewFragment;
import tn.startupfactory.tunifund.fragments.PopularFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class HomeActivity extends FragmentActivity {

	private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.viewpager);

		List<Fragment> fragments = new Vector<Fragment>();

		fragments.add(Fragment.instantiate(this,NewFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, PopularFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,AllFragment.class.getName()));

	
		this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

		
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		pager.setAdapter(this.mPagerAdapter);
		pager.setOffscreenPageLimit(2);
		pager.setCurrentItem(3);
	}
}