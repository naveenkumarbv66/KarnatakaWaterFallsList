package com.naveen.waterfalls;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Mainfalls extends Activity implements OnClickListener,OnItemClickListener{
	private ArrayList<HashMap<String,String>> fallslist=new ArrayList<HashMap<String,String>>();
	private ListView l1;
	private TypedArray icon, info,name,falls, maps,fullscreen;
	private JogFalls jogFalls;
	static final String KEY_TITLE="name";
	static final String KEY_ICON="icon";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainfalls);
		name=getResources().obtainTypedArray(R.array.name);
		icon=getResources().obtainTypedArray(R.array.icon);
		
		for (int i = 0; i < name.length(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KEY_TITLE, name.getString(i));
            map.put(KEY_ICON,icon.getString(i));
            fallslist.add(map);
		}
		
		l1=(ListView)findViewById(R.id.listView1);
		jogFalls=new JogFalls(this,fallslist);
		 l1.setOnItemClickListener(this);
		 l1.setAdapter(jogFalls);
       
	}
	
	@Override
	public void onClick(View arg0) {
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int pos, long arg3) {
		Intent i1=new Intent(this, FallsDetails.class);
		maps=getResources().obtainTypedArray(R.array.maps);
		falls=getResources().obtainTypedArray(R.array.falls);
		info=getResources().obtainTypedArray(R.array.info);
		fullscreen=getResources().obtainTypedArray(R.array.fullscreen);
		i1.putExtra("KEY_MAP",maps.getString(pos));
		i1.putExtra("KEY_FALLS",falls.getString(pos));
		i1.putExtra("KEY_INFO",info.getString(pos));
		i1.putExtra("KEY_FULLSCREEN",fullscreen.getString(pos));
		startActivity(i1);
	}
}
