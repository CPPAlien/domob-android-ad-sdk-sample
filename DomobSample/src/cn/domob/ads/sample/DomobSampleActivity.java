package cn.domob.ads.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DomobSampleActivity extends Activity {
	public static final String PUBLISHER_ID = "56OJyM1ouMGoaSnvCK";
	public static final String InlinePPID = "16TLwebvAchksY6iO_8oSb-i";
	public static final String InterstitialPPID = "16TLwebvAchksY6iOa7F4DXs";
	public static final String SplashPPID = "16TLwebvAchksY6iOGe3xcik";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button bannerBtn = (Button) findViewById(R.id.banner);
		Button rotatableFlexBannerBtn = (Button) findViewById(R.id.rotatableBannerAd);
		Button interstitialBtn = (Button) findViewById(R.id.interstitial);
		
		bannerBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(DomobSampleActivity.this, BannerAdActivity.class));
			}
		});
		
		rotatableFlexBannerBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(DomobSampleActivity.this, RotatableBannerAdActivity.class));
			}
		});

		interstitialBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(DomobSampleActivity.this, InterstitialAdActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "About");
		menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "Exit");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);

		switch (item.getItemId()) {
		case Menu.FIRST:
			new AlertDialog.Builder(this).setTitle("Sample Version").setMessage("4.0")
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
						}
					}).show();
			break;
		case Menu.FIRST + 1:
			finish();
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
		default:
			break;
		}

		return true;
	}
}