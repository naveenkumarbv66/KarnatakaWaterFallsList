package com.naveen.waterfalls;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;

public class FullScreen extends Activity {
	Intent i;
	ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen);
		img=(ImageView)findViewById(R.id.imageView1);
		i=getIntent();
		String full=i.getStringExtra("KEY");
		String image="drawable/"+full;
		int res=getApplicationContext().getResources().getIdentifier(image, null, getPackageName());
		img.setBackgroundResource(res);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.full_screen, menu);
		return true;
	}

}
