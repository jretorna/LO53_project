package fr.utbm.retornaz.connnexionwifi.Positioning;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PointView extends View {
	private float cx;
	private float cy;

	public PointView(	final Context context,
						final AttributeSet attrs,
						final float x,
						final float _y) {
		super(context, attrs);
		cx = x;
		cy = _y;
	}

	public PointView(final Context context, final float x, final float y) {
		super(context);
		cx = x;
		cy = y;
	}
	public PointView(	final Context context,
						final AttributeSet attrs,
						final int defStyle,
						final float x,
						final float y) {
		super(context, attrs, defStyle);
		cx = x;
		cy = y;
	}
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(final Canvas canvas) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.GREEN);
		float radius = Math.min(cx, cy);
		canvas.drawCircle(cx - 100, cy - 100, radius, paint);
		canvas.setDensity(10);
		super.onDraw(canvas);
	}
}