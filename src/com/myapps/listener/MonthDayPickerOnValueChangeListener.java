package com.myapps.listener;

import android.widget.NumberPicker;

import com.myapps.Config;
import com.myapps.fragment.MonthDayPickerFragment;
import com.myapps.sample.monthdaypicker.R;

public class MonthDayPickerOnValueChangeListener implements NumberPicker.OnValueChangeListener {

	private	MonthDayPickerFragment _monthDayPickerFragment;

	public MonthDayPickerOnValueChangeListener( MonthDayPickerFragment monthDayPickerFragment ) {
		Config.DebugLog( "MonthDayPickerOnValueChangeListener >>> new" );
		this._monthDayPickerFragment = monthDayPickerFragment;
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		Config.DebugLog( "MonthDayPickerFragment >>> onValueChange" );
		switch ( picker.getId() ) {
			case R.id.monthPickerView : {
				Config.DebugLog( "MonthDayPickerFragment >>> onValueChange >>> Month" );
				this._monthDayPickerFragment.setSelectMonth( String.format( "%02d" , newVal ) );
				this._monthDayPickerFragment.getSelectMonthTextView().setText( String.format( "%s月" , this._monthDayPickerFragment.getSelectMonth() ) );
				break;
			}
			case R.id.dayPickerView : {
				Config.DebugLog( "MonthDayPickerFragment >>> onValueChange >>> Day" );
				this._monthDayPickerFragment.setSelectDay( String.format( "%02d" , newVal ) );
				this._monthDayPickerFragment.getSelectDayTextView().setText( String.format( "%s日" , this._monthDayPickerFragment.getSelectDay() ) );
				break;
			}
		}
	}

}
