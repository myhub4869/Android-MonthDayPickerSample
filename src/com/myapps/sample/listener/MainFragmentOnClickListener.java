package com.myapps.sample.listener;

import java.util.Calendar;

import android.text.format.DateFormat;
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
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton01" );
				MonthDayPickerFragment monthDayPickerFragment	= new MonthDayPickerFragment();
				monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
			case R.id.showPickerButton02 :{
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton02" );
				Calendar	thisDate	= Calendar.getInstance();
				String		month		= ( String )DateFormat.format( "MM" , thisDate );
				String		day			= ( String )DateFormat.format( "dd" , thisDate );

				MonthDayPickerFragment monthDayPickerFragment	= new MonthDayPickerFragment( month , day );
				monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
			case R.id.showPickerButton03 : {
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton03" );
				Calendar	thisDate	= Calendar.getInstance();
				String		month		= ( String )DateFormat.format( "MM" , thisDate );
				String		day			= ( String )DateFormat.format( "dd" , thisDate );

				MonthDayPickerFragment monthDayPickerFragment	= new MonthDayPickerFragment( month , day , false );
				monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
		}
	}

}
