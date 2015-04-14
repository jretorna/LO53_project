package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import fr.utbm.retornaz.connnexionwifi.Positioning.TouchView;

public class PrintLocation extends Activity {

	private ImageView mapImageView;
	private ImageButton settingBtn;
	private ImageButton startLocation;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_location);

		this.mapImageView = (ImageView) findViewById(R.id.imageViewMap);
		this.settingBtn = (ImageButton) findViewById(R.id.settingViewerBtn);
		this.startLocation = (ImageButton) findViewById(R.id.locateMeBtn);

		initListeners();

	}
	private void initListeners() {
		/*----- Setting -----*/

		this.settingBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				startActivity(new Intent(PrintLocation.this, Setting.class));
			}
		});

		/* ---- StartLocation ---- */

		this.startLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				// Start of the localisation
				TouchView touchView = new TouchView(getApplicationContext());
				// getWindow().setFlags(WindowManager.LayoutParams.ALPHA_CHANGED,
				// WindowManager.LayoutParams.ALPHA_CHANGED);
				// PrintLocation.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				// setContentView(touchView);
				v.draw(touchView.getCanvas());

			}
		});
	}
}
