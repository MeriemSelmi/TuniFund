package tn.startupfactory.tunifund.adapter;

import java.util.List;


import tn.startupfactory.tunifund.R;
import tn.startupfactoy.tunifund.domain.Project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectsAdapter extends BaseAdapter{
	
	
	private LayoutInflater inflater;
	Integer[] images;
	List<Project> titres;
	
	public ProjectsAdapter(LayoutInflater inflater,List<Project> titres) {
		super();
		this.inflater = inflater;
		this.titres = titres;
	}
	

	@Override
	public int getCount() {
		return titres.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public static class ViewHolder {
		ImageView image;
		TextView nom;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_project, null);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			holder.nom = (TextView) convertView.findViewById(R.id.nom);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.image.setImageResource(titres.get(position).getId());
		holder.nom.setText(titres.get(position).getName());
		return convertView;
	
	}

}
