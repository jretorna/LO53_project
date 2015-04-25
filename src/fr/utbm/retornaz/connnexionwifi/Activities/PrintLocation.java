package fr.utbm.retornaz.connnexionwifi.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PrintLocation extends Activity {

	private ImageView mapImageView;
	private ImageButton settingBtn;
	private ImageButton startLocation;
	private ImageView marker;

	private Bundle bundle;
	private float x, y;
	private Rect bounds;
	private Rect markerBounds;
	private int viewHeight, viewWidth;
	private Matrix matrix;
	private float[] imageValues = new float[9];
	private int[] imgPosition = new int[2];

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_location);

		// getBundle();
		// XXX Jeremy supprimer ce print
		Log.d("bundle", "x: " + x + " | y: " + y);

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
				// XXX Jeremy supprimer ce print
				Log.w("CLIC", "******** CLIC ********");

				RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

				marker = new ImageView(getApplicationContext());
				marker.setImageResource(R.drawable.map_marker);
				markerBounds = marker.getDrawable().getBounds();
				getBounds();
				// XXX Jeremy supprimer ce print
				Log.d("Bounds", "left: " + bounds.left + " | right: "
						+ bounds.right);
				getViewDimension();
				// XXX Jeremy supprimer ce print
				Log.d("ViewDimension", "height: " + viewHeight + " | width: "
						+ viewWidth);
				/*--- Get the location of the map ---*/
				mapImageView.getLocationOnScreen(imgPosition);
				// XXX Jeremy supprimer ce print
				Log.d("ImgLocation", "x: " + imgPosition[0] + " | y: "
						+ imgPosition[1]);

				getMatrix();
				marker.setX(imgPosition[0] - marker.getX() - 50);
				marker.setY(imgPosition[1] - 62 - marker.getY() / 2);
				relativeLayout.addView(marker);
			}

		});
	}
	private void getBundle() {
		bundle = getIntent().getExtras();
		x = bundle.getFloat("x");
		y = bundle.getFloat("y");
	}
	private void getBounds() {
		bounds = mapImageView.getDrawable().getBounds();
	}
	private void getViewDimension() {
		viewHeight = getResources().getDisplayMetrics().heightPixels;
		viewWidth = getResources().getDisplayMetrics().widthPixels;
	}
	private void getMatrix() {
		matrix = mapImageView.getImageMatrix();
		matrix.getValues(imageValues);
	}

}
