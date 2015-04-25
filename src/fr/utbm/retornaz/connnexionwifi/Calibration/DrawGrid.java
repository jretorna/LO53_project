package fr.utbm.retornaz.connnexionwifi.Calibration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView;

public class DrawGrid extends ImageView {

	public DrawGrid(final Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(final Canvas canvas) {
		super.onDraw(canvas);
		// XXX Jeremy supprimer ce print
		Log.d("je dessine", "DESSINONS");
		Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
		p.setColor(Color.RED);
		canvas.drawLine(100, 100, 1000, 1000, p);
		canvas.setDensity(10);

	}

}
