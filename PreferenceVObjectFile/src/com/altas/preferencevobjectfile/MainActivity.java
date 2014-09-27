package com.altas.preferencevobjectfile;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.altas.lib.FileUtils;
import com.altas.lib.PreferenceUtils;
import com.altas.preferencevobjectfile.model.UserInfo;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final UserInfo userInfo = new UserInfo(1,"710d3d1a44c5de20861837093b6c2a18154aafce","altas","https://avatars3.githubusercontent.com/u/8937514?v=2&u=bec0a9c93d58a2a5686a721bd9478c8857c1d5d9&s=140","8615822222222",100000,100);
		findViewById(R.id.write_btn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuilder sBuilder = new StringBuilder("Preference:");
				long beginTime = new Date().getTime();
				PreferenceUtils.setObject(MainActivity.this, userInfo);
				sBuilder.append(new Date().getTime()-beginTime).append("\nObjectFile:");
				beginTime = new Date().getTime();
				FileUtils.writeObjectFile(MainActivity.this, UserInfo.class.getSimpleName(),userInfo);
				sBuilder.append(new Date().getTime()-beginTime);
				((TextView)findViewById(R.id.info_tv)).setText(sBuilder.toString());
			}
		});
		
		
		
	}
}
