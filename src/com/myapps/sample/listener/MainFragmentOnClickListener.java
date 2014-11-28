package com.myapps.sample.listener;

import android.view.View;
import android.view.View.OnClickListener;

import com.myapps.Config;
import com.myapps.fragment.MonthDayPickerFragment;
import com.myapps.sample.fragment.MainFragment;
import com.myapps.sample.monthdaypicker.R;

public class MainFragmentOnClickListener implements OnClickListener {

	private	MainFragment	_mainFragment;

	public MainFragmentOnClickListener( MainFragment mainFragment ) {
		this._mainFragment = mainFragment;
	}

	@Override
	public void onClick(View v) {
		Config.DebugLog( "MainFragmentOnClickListener >>> onClick" );
		switch ( v.getId() ) {
			case R.id.showPickerButton01 :{
				MonthDayPickerFragment monthDayPickerFragment	= new MonthDayPickerFragment();
				monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
		}
	}

}
