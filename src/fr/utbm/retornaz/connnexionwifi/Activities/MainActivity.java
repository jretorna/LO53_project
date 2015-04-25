package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	/*---------------------*/
	private Button jbCalibration, jbPositioning;
	private ImageButton jbSetting, jbHelp;

	/*---------------------*/

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		jbSetting = (ImageButton) findViewById(R.id.settingBtn);
		jbHelp = (ImageButton) findViewById(R.id.helpBtn);
		jbCalibration = (Button) findViewById(R.id.configBtn);
		jbPositioning = (Button) findViewById(R.id.viewerBtn);

		jbSetting.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				launchSettingActivity(v);
			}
		});

		jbCalibration.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				launchCalibrationActivity(v);
			}
		});

		jbPositioning.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				launchPositioningActivity(v);
			}
		});

		jbHelp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				launchHelpActivity(v);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/************ Launch the activity **************/

	private void launchSettingActivity(final View v) {
		startActivity(new Intent(MainActivity.this, Setting.class));
	}

	private void launchHelpActivity(final View v) {
		startActivity(new Intent(MainActivity.this, Help.class));
	}

	private void launchCalibrationActivity(final View v) {
		Intent intent = new Intent(MainActivity.this, Calibration.class);
		startActivity(intent);
	}

	private void launchPositioningActivity(final View v) {
		startActivity(new Intent(MainActivity.this, PrintLocation.class));
	}
}
