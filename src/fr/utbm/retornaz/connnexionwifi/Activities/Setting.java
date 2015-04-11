package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import fr.utbm.retornaz.connnexionwifi.Utils.TraitementChaine;

public class Setting extends Activity {

	/*--------------------*/
	private EditText serverAddressEt, serverPortEt;
	private Button confirmBtn;

	public static final String myPreferences = "settingPrefs";
	private static final String serverAddress = "serverAddress";
	private static final String serverPort = "serverPort";
	SharedPreferences sharedpreferences;

	/*--------------------*/
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_main);

		serverAddressEt = (EditText) findViewById(R.id.serverAddressEditText);
		serverPortEt = (EditText) findViewById(R.id.serverPortEditText);
		confirmBtn = (Button) findViewById(R.id.confirmSettingBtn);

		/*---- Preferences ----*/
		initPreferences();

		/*---- Listeners ----*/
		initListeners();
	}

	private void initListeners() {
		confirmBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				if (saveInPreferences()) {
					Toast.makeText(getApplicationContext(), "Datas uploaded",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Impossible to store yours datas",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		// serverAddressEt.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(final View v) {
		// serverAddressEt.getText().clear();
		// }
		// });

		// serverAddressEt.setOnFocusChangeListener(new OnFocusChangeListener()
		// {
		//
		// @Override
		// public void onFocusChange(final View v, final boolean hasFocus) {
		// // XXX Trooper supprimer ce print
		// Log.d("prout", "focus changed");
		// if (!serverAddressEt.getText().toString().equals(
		// R.string.serverAddressEditText)) {
		// serverAddressEt.getText().clear();
		// } else {
		// // XXX Trooper supprimer ce print
		// Log.w("eee", "isempty");
		// serverAddressEt.setText(R.string.serverAddressEditText);
		// }
		// }
		// });

		// serverPortEt.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(final View v) {
		// if (serverPortEt.getText().equals(R.string.serverPortTextView)) {
		// serverPortEt.setText("");
		// }
		// }
		// });
	}

	private void initPreferences() {
		sharedpreferences = getSharedPreferences(myPreferences,
				Context.MODE_PRIVATE);
		if (sharedpreferences.contains(serverAddress))
			serverAddressEt.setText(sharedpreferences.getString(serverAddress,
					String.valueOf(R.string.serverAddressEditText)));
		if (sharedpreferences.contains(serverPort))
			serverPortEt.setText(sharedpreferences.getString(serverPort,
					String.valueOf(R.string.serverPortEditText)));
	}

	private boolean saveInPreferences() {
		if (TraitementChaine.isAnIp(serverAddressEt.getText().toString())
				&& TraitementChaine.isANumber(serverPortEt.getText().toString())) {
			if (sharedpreferences != null) {
				Editor editor = sharedpreferences.edit();
				editor.putString(serverAddress,
						serverAddressEt.getText().toString());
				editor.putString(serverPort, serverPortEt.getText().toString());
				editor.commit();
				return true;
			}
		}
		return false;
	}
}
