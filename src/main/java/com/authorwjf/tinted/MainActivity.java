package com.authorwjf.tinted;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;

public class MainActivity extends Activity implements OnClickListener {

	private String[] colors = {"white", "magenta", "yellow", "cyan", "green"};
	private int index = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i=0; i<5; i++) {
			String name = "button_"+Integer.toString(i+1);
			findViewById(getIdFromName(name)).setOnClickListener(this);
		}
		onClick(null);
	}

	@Override
	public void onClick(View v) {
		for (int i=0; i<5; i++) {
			String name = "button_"+Integer.toString(i+1);
			((Button)findViewById(getIdFromName(name))).setText(colors[index]);
			int tint = Color.parseColor(colors[index]); 
			((Button)findViewById(getIdFromName(name))).getBackground().setColorFilter(tint, Mode.MULTIPLY);
		}
		index++;
		if (index>4) index=0;
	}
	
	private int getIdFromName(String name) {
		return getResources().getIdentifier(name,"id",getPackageName());
	}

    public void startAnother1(View view) {
        startActivity(new Intent(this,Another1.class));
    }
}
