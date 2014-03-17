package com.zengbobo.android.testActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zengbobo.android.MyApplication;
import com.zengbobo.android.R;

public class TestActivity extends Activity {
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("MYTAG TestActivity.....onCreate");
		setContentView(R.layout.activity_main);
		MyApplication.getInstance().addActivity(this);
		
		Bundle bundle = getIntent().getBundleExtra("bundle");
		System.out.println("ZBB bundle:"+bundle);
		if(bundle !=null){
			String key = bundle.getString("key");
			System.out.println("ZBB KEY:"+key);
		}

		System.out.println("ZBB savedInstanceState:"+savedInstanceState);
		if(savedInstanceState !=null ){
			String save = bundle.getString("save");
			System.out.println("ZBB save:"+save);
		}
		
//		tv.setText("11");

	
	}
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("MYTAG TestActivity.....onResume");
		tv.setText("11");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("save", "save");
		super.onSaveInstanceState(outState);
		System.out.println("MYTAG TestActivity.....onSaveInstanceState");
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("MYTAG TestActivity.....onDestroy");
		
	}
}
