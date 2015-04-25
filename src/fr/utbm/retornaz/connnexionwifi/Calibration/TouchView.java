package fr.utbm.retornaz.connnexionwifi.Calibration;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import fr.utbm.retornaz.connnexionwifi.Activities.R;

public class TouchView extends View {
	private float imageX;
	private float imageY;

	// Constructeur
	public TouchView(final Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		// Pour récupérer la position du doigt sur l'écrans
		float positionTouchX = event.getX();
		float positionTouchY = event.getY();

		imageX = positionTouchX;
		imageY = positionTouchY;
		return true;

	}

	protected void onDraw(final Canvas canvas) {
		Bitmap monImage = BitmapFactory.decodeResource(getResources(),
				R.drawable.map_marker);
		canvas.drawBitmap(monImage, imageX, imageY, null);
		invalidate(); // Efface pour redessiner.
	}

	// Cette fonction est appeler lorsque la taille de l'écran change, par
	// exemple si il y a rotation de l'écran.
	@Override
	public void onSizeChanged(	final int w,
								final int h,
								final int oldW,
								final int oldH) {

	}

}