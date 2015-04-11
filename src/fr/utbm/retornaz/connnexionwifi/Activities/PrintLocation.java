package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class PrintLocation extends Activity {
	
	private ImageView mapImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_location);
		
		this.mapImageView = (ImageView) findViewById(R.id.imageViewMap);
	}
	
	private void initListeners() 
	{	
		//this.mapImageView
	}
	
}
