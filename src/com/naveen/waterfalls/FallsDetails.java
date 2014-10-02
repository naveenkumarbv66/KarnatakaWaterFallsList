package com.naveen.waterfalls;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FallsDetails extends Activity implements OnClickListener {
	private ImageView img,img2;
	private TextView t;
	private Intent i1,i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.falls_details);
		i=getIntent();
		
		String falls=i.getStringExtra("KEY_FALLS");
		String info=i.getStringExtra("KEY_INFO");
		
		
		img=(ImageView)findViewById(R.id.imageView1);
		img2=(ImageView)findViewById(R.id.imageView2);
		t=(TextView)findViewById(R.id.textView1);
			String image="drawable/"+falls;
			int res=getApplicationContext().getResources().getIdentifier(image, null, getPackageName());
			img.setImageResource(res);
			
			t.setText(info);
			img2.setOnClickListener(this);
			ImageView im1=(ImageView)findViewById(R.id.imageView3);
			im1.setOnClickListener(this);
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.falls_details, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.imageView2:
		i=getIntent();
		i1=new Intent(Intent.ACTION_VIEW);
		String map=i.getStringExtra("KEY_MAP");
		i1.setData(Uri.parse(map));
		startActivity(i1);
		break;
	case R.id.imageView3:
		i=getIntent();
		String fullscreen=i.getStringExtra("KEY_FULLSCREEN");
		i1=new Intent(this,FullScreen.class);
		i1.putExtra("KEY",fullscreen);
		startActivity(i1);
		break;
	default:
		break;
	}
		
	}

}
