package com.myapps.listener;

import java.util.Calendar;

import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;

import com.myapps.Config;
import com.myapps.fragment.MonthDayPickerFragment;
import com.myapps.sample.monthdaypicker.R;

public class MonthDayPickerOnClickListener implements OnClickListener {

	private	MonthDayPickerFragment _monthDayPickerFragment;

	public MonthDayPickerOnClickListener( MonthDayPickerFragment monthDayPickerFragment ) {
		Config.DebugLog( "MonthDayPickerOnClickListener >>> new" );
		this._monthDayPickerFragment = monthDayPickerFragment;
	}

	@Override
	public void onClick(View v) {
		Config.DebugLog( "MonthDayPickerOnClickListener >>> onClick" );
		switch( v.getId() ) {
			case R.id.selectMonthDayButtonView : {
				Config.DebugLog( "MonthDayPickerOnClickListener >>> onClick >>> selectMonthDayButtonView" );
				this._monthDayPickerFragment.refreshSelectValues();
				break;
			}
			case R.id.pickerDismissButttonView : {
				Config.DebugLog( "MonthDayPickerOnClickListener >>> onClick >>> pickerDismissButttonView" );
				this._monthDayPickerFragment.dismiss();
				break;
			}
			case R.id.todaySelectButtonView : {
				Config.DebugLog( "MonthDayPickerOnClickListener >>> onClick >>> todaySelectButtonView" );
				Calendar 	thisDate		= Calendar.getInstance();
				this._monthDayPickerFragment.setSelectMonth(	( String )DateFormat.format( "MM" , thisDate ) );
				this._monthDayPickerFragment.setSelectDay(		( String )DateFormat.format( "dd" , thisDate ) );
				this._monthDayPickerFragment.refreshSelectValues();
				break;
			}
		}
	}
}
