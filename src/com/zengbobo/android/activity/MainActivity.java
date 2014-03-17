package com.zengbobo.android.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zengbobo.android.MyApplication;
import com.zengbobo.android.R;
import com.zengbobo.android.testActivity.TestActivity;

public class MainActivity extends Activity {
	private TextView tv, tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("MYTAG MainActivity.....onCreate");
		setContentView(R.layout.activity_main);
		MyApplication.getInstance().addActivity(this);
		tv = (TextView) findViewById(R.id.tv);
		System.out.println("MYTAG onclick:" + android.os.Process.myPid());
//		tv1.setText("11");
		// Intent intent = new Intent(this, TestActivity.class);
		// startActivity(intent);
		tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 Intent intent = new Intent(MainActivity.this,
				 TestActivity.class);
				 Bundle bundle = new Bundle();
				 bundle.putString("key", "values");
				 intent.putExtra("bundle", bundle);
				 startActivity(intent);
			}
		});

	}



	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("MYTAG MainActivity.....onDestroy");
	}

}
