package com.naveen.waterfalls;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class JogFalls extends BaseAdapter {
	private static LayoutInflater inflater=null;
	private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private ViewHolder holder = null;
    private  HashMap<String, String> fall;
	
	public JogFalls(Activity a, ArrayList<HashMap<String, String>>  d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
	
	static class ViewHolder {
		TextView title;
		ImageView image;
	}
    
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int pos) {
		return pos;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View contentview, ViewGroup parent) {
		View vi=contentview;
        if(contentview==null) {
        	vi = inflater.inflate(R.layout.falls_view, null);
        	holder = new ViewHolder();
        	holder.title=(TextView)vi.findViewById(R.id.title);
        	holder.image=(ImageView)vi.findViewById(R.id.symbol);
        	vi.setTag(holder);
        }else{
        	holder = (ViewHolder) vi.getTag();
        }
        vi.setTag(holder);
        
        fall = new HashMap<String, String>();
        fall = data.get(pos);
        holder.title.setText(fall.get(Mainfalls.KEY_TITLE));
        String url="drawable/"+fall.get(Mainfalls.KEY_ICON);
        int resource=activity.getApplicationContext().getResources().getIdentifier(url,null,activity.getPackageName());
        holder.image.setImageResource(resource);
        return vi;
	}

	protected void onCreate(Bundle savedInstanceState) {
	}
	

}
