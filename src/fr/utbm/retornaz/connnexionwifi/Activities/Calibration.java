package fr.utbm.retornaz.connnexionwifi.Activities;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Calibration extends Activity {

	private ImageView mapImageView;
	private ImageButton settingBtn;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calibration);

		this.mapImageView = (ImageView) findViewById(R.id.imageViewMap);
		this.settingBtn = (ImageButton) findViewById(R.id.settingViewerBtn);

		initListeners();
		// setContentView(new RenderView(this));
		RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mapImageView.getLayoutParams();
		addContentView(new RenderView(this), lp);
	}
	private void initListeners() {
		/*----- Setting -----*/

		this.settingBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				startActivity(new Intent(Calibration.this, Setting.class));
			}
		});

	}

	// private void drawGridOnMap() {
	// /* Get the position on the map on the screen */
	// int[] locationWindows = new int[2];
	// int[] locationScreen = new int[2];
	// mapImageView.getLocationInWindow(locationWindows);
	// mapImageView.getLocationOnScreen(locationScreen);
	// Drawable img = mapImageView.getDrawable();
	// RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)
	// mapImageView.getLayoutParams();
	// int rightMargin = lp.rightMargin;
	// int topMargin = lp.topMargin;
	// // XXX Jeremy supprimer ce print
	// Log.w("test", "right : " + rightMargin + " * " + "top: " + topMargin);
	// int imgWidth = img.getIntrinsicWidth();
	// int imgHeight = img.getIntrinsicHeight();
	// int viewHeight = getResources().getDisplayMetrics().heightPixels;
	// int viewWidth = getResources().getDisplayMetrics().widthPixels;
	// int leftPosition = mapImageView.getLeft();
	// int topPosition = mapImageView.getTop();
	// // XXX Jeremy supprimer ce print
	// Log.d("....", "top : " + topPosition + " | left : " + leftPosition);
	// // XXX Jeremy supprimer ce print
	// Log.e("dimension", imgWidth + " * " + imgHeight);
	//
	// // XXX Jeremy supprimer ce print
	// Log.d("size", mapImageView.getX() + " * " + mapImageView.getY());
	// // XXX Jeremy supprimer ce print
	// // XXX Jeremy supprimer ce print
	// Log.w("size", "locationWindows: " + locationWindows.length
	// + " | locationScreen: " + locationScreen.length);
	// Log.w("locationWindows", locationWindows[0] + " * "
	// + locationWindows[1]);
	// Log.w("locationScreen", locationScreen[0] + " * " + locationScreen[1]);
	// }

	// Création d'une classe interne RenderView pour gérer un affichage simple
	// permettant
	// de montrer que nous occupons bien tout l'écran
	class RenderView extends View {
		/*----------------------------*/
		private ImageView mapImageView;
		private ImageButton settingBtn;
		/*----------------------------*/
		public RenderView(final Context context) {
			super(context);
			setContentView(R.layout.calibration);
			this.mapImageView = (ImageView) findViewById(R.id.imageViewMap);
			this.settingBtn = (ImageButton) findViewById(R.id.settingViewerBtn);
		}

		// Dessinons sur la totalité de l'écran
		protected void onDraw(final Canvas canvas) {
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint = new Paint();
			paint.setAntiAlias(true);

			// Nous allons dessiner nos points par rapport à la résolution de
			// l'écran
			int iWidth = canvas.getWidth(); // Largeur
			int iHeight = canvas.getHeight(); // Hauteur

			Random rand = new Random();
			// Affichons 100 segments de toutes les couleurs
			for (int i = 0; i < 10; i++) {
				// Affecter une couleur de manière aléatoire
				paint.setARGB(255, rand.nextInt(256), rand.nextInt(256),
						rand.nextInt(256));
				// Définir l'épaisseur du segment
				paint.setStrokeWidth(rand.nextInt(10));
				paint.setStyle(Style.FILL_AND_STROKE);
				paint.setPathEffect(new DashPathEffect(new float[]{5, 5, 2}, 0));
				// Puis dessiner nos points dans le cavenas
				canvas.drawLine(rand.nextInt(iWidth), rand.nextInt(iHeight),
						rand.nextInt(iWidth), rand.nextInt(iHeight), paint);
			}
		}
	}

}
