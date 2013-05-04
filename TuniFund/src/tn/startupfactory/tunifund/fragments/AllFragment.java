package tn.startupfactory.tunifund.fragments;

import java.util.List;

import tn.startupfactory.tunifund.R;
import tn.startupfactory.tunifund.adapter.ProjectsAdapter;
import tn.startupfactoy.tunifund.domain.Project;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class AllFragment extends Fragment{
	
	GridView gridView;
	View v;
	LayoutInflater inflater;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout, container, false);
		gridView= (GridView) v.findViewById(R.id.gridview);
		this.inflater = inflater;
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		AllAsyncTask NewAsync = new AllAsyncTask();
		NewAsync.execute();
	}
	private class AllAsyncTask extends AsyncTask<Void, Void, List<Project>> {

		@Override
		protected List<Project> doInBackground(Void... params) {
			List<Project> hotels = null;
			try {
				ProjectService mockHotel = new ProjectMock();
				projects = mockHotel.getAll();
			} catch (Exception e) {
				cancel(false);
			}
			return hotels;
		}

		@Override
		protected void onPostExecute(List<Project> hotels) {
			gridView.setAdapter(new ProjectsAdapter(inflater, hotels));
		}
	}
	

}
