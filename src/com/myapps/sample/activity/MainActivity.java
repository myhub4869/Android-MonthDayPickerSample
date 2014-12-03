package com.myapps.sample.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.myapps.Config;
import com.myapps.sample.fragment.MainFragment;
import com.myapps.sample.monthdaypicker.R;

public class MainActivity extends FragmentActivity {

	private	Context	_context;

	@Override
	protected void onCreate(Bundle arg0) {
		Config.DebugLog( "MainActivity >>> onCreate" );
		super.onCreate(arg0);

		setContentView(R.layout.main_activity);

		this._context	= this;

		getFragmentManager().beginTransaction().replace( R.id.mainFragment, new MainFragment() ).commit();
	}

	@Override
	protected void onDestroy() {
		Config.DebugLog( "MainActivity >>> onDestroy" );
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Config.DebugLog( "MainActivity >>> onPause" );
		super.onPause();
	}

	@Override
	protected void onResume() {
		Config.DebugLog( "MainActivity >>> onResume" );
		super.onResume();
	}

	@Override
	protected void onResumeFragments() {
		Config.DebugLog( "MainActivity >>> onResumeFragments" );
		super.onResumeFragments();
	}

	@Override
	protected void onStart() {
		Config.DebugLog( "MainActivity >>> onStart" );
		super.onStart();
	}

	@Override
	protected void onStop() {
		Config.DebugLog( "MainActivity >>> onStop" );
		super.onStop();
	}

	@Override
	public boolean dispatchKeyEvent( KeyEvent ke ) {
		Config.ActivityFinishDialog( this );
		return true;
	}

	public Context getContext() {
		return this._context;
	}
}
