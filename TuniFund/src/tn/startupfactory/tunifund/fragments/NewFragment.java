/*package tn.startupfactory.tunifund.fragments;

import java.util.List;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import tn.startupfactory.tunifund.R;

public class NewFragment extends Fragment{
	
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
		NewAsyncTask NewAsync = new NewAsyncTask();
		NewAsync.execute();
	}
	private class NewAsyncTask extends AsyncTask<Void, Void, List<Project>> {

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
			gridView.setAdapter(new ListProjectAdapter(inflater, hotels));
		}
	}
	

}*/
