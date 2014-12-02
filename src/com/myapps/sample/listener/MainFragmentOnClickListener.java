package com.myapps.sample.listener;

import java.util.Calendar;

import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;

import com.myapps.Config;
import com.myapps.fragment.MonthDayPickerFragment;
import com.myapps.sample.fragment.MainFragment;
import com.myapps.sample.monthdaypicker.R;

public class MainFragmentOnClickListener implements OnClickListener , MonthDayPickerFragment.CallbacksInterface {

	private	MainFragment			_mainFragment;
	private	MonthDayPickerFragment	_monthDayPickerFragment;

	public MainFragmentOnClickListener( MainFragment mainFragment ) {
		this._mainFragment = mainFragment;
	}

	@Override
	public void onClick(View v) {
		Config.DebugLog( "MainFragmentOnClickListener >>> onClick" );
		switch ( v.getId() ) {
			case R.id.showPickerButton01 :{
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton01" );
				this._monthDayPickerFragment	= new MonthDayPickerFragment();
				this._monthDayPickerFragment.setCallbacksInterface( this );
				this._monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
			case R.id.showPickerButton02 :{
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton02" );
				Calendar	thisDate	= Calendar.getInstance();
				String		month		= ( String )DateFormat.format( "MM" , thisDate );
				String		day			= ( String )DateFormat.format( "dd" , thisDate );

				this._monthDayPickerFragment	= new MonthDayPickerFragment( month , day );
				this._monthDayPickerFragment.setCallbacksInterface( this );
				this._monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
			case R.id.showPickerButton03 : {
				Config.DebugLog( "MainFragmentOnClickListener >>> onClick >>> showPickerButton03" );
				Calendar	thisDate	= Calendar.getInstance();
				String		month		= ( String )DateFormat.format( "MM" , thisDate );
				String		day			= ( String )DateFormat.format( "dd" , thisDate );

				this._monthDayPickerFragment	= new MonthDayPickerFragment( month , day , false );
				this._monthDayPickerFragment.setCallbacksInterface( this );
				this._monthDayPickerFragment.show( this._mainFragment.getFragmentManager() ,  MonthDayPickerFragment.SHOW_TAG );
				break;
			}
		}
	}

	@Override
	public void dissmissDialog() {
		Config.DebugLog( "MainFragmentOnClickListener >>> dissmissDialog" );
		Config.shortToast( this._mainFragment.getContext() ,  String.format( "%s月%s日を選択" , _monthDayPickerFragment.getSelectMonth() , _monthDayPickerFragment.getSelectDay() ) );
		this._monthDayPickerFragment.dismiss();
	}

}
