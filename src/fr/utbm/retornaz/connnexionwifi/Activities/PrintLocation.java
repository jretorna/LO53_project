package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PrintLocation extends Activity {

	private ImageView mapImageView;
	private ImageButton settingBtn;
	private ImageButton startLocation;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_location);

		this.mapImageView = (ImageView) findViewById(R.id.imageViewMap);
		this.startLocation = (ImageButton) findViewById(R.id.locateMeBtn);

	}

	private void initListeners() {
		// this.mapImageView
	}

}
