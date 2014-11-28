package com.myapps.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.myapps.Config;
import com.myapps.listener.MonthDayPickerOnClickListener;
import com.myapps.listener.MonthDayPickerOnValueChangeListener;
import com.myapps.sample.monthdaypicker.R;

public class MonthDayPickerFragment extends DialogFragment {

	public	static	final	String								SHOW_TAG					= "monthDayPickerDialog";
	private					Context								_context;
	private					String								_selectMonth;
	private					String								_selectDay;
	private					TextView							_selectMonthTextView;
	private					TextView							_selectDayTextView;
	private					NumberPicker						_monthPickerView;
	private					NumberPicker						_dayPickerView;
	private					Button								_selectMonthDayButton;
	private					Button								_dissmisDialogButton;
	private					Button								_todaySelectButton;
	private					boolean								_todaySelectButtonShowFlag;
	private					MonthDayPickerOnClickListener		_onClickListener;
	private					MonthDayPickerOnValueChangeListener	_onValueChangeListener;

	public MonthDayPickerFragment() {
		this( "01" , "01" );
	}
	public MonthDayPickerFragment( String month , String day ) {
		this( month , day , true );
	}
	public MonthDayPickerFragment( String month , String day , boolean todaySelectButtonShowFlag ) {
		this._selectMonth				= month;
		this._selectDay					= day;
		this._todaySelectButtonShowFlag	= todaySelectButtonShowFlag;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Config.DebugLog( "MonthDayPickerFragment >>> onCreate" );
		super.onCreate(savedInstanceState);

		this._context				= this.getActivity();
		this._onClickListener		= new MonthDayPickerOnClickListener( this );
		this._onValueChangeListener	= new MonthDayPickerOnValueChangeListener( this );
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Config.DebugLog( "MonthDayPickerFragment >>> onCreateView" );
		View	rootView	= inflater.inflate( R.layout.month_day_picker_fragment , container , false );

		this._selectMonthTextView	= ( TextView		)rootView.findViewById( R.id.selectMonthTextView );
		this._selectDayTextView		= ( TextView		)rootView.findViewById( R.id.selectDayTextView );
		this._monthPickerView		= ( NumberPicker	)rootView.findViewById( R.id.monthPickerView );
		this._dayPickerView			= ( NumberPicker	)rootView.findViewById( R.id.dayPickerView );
		this._selectMonthDayButton	= ( Button			)rootView.findViewById( R.id.selectMonthDayButtonView );
		this._dissmisDialogButton	= ( Button			)rootView.findViewById( R.id.pickerDismissButttonView );
		this._todaySelectButton		= ( Button			)rootView.findViewById( R.id.todaySelectButtonView );

		this._monthPickerView.setMinValue( 1 );
		this._monthPickerView.setMaxValue( 12 );
		this._monthPickerView.setValue( Integer.valueOf( this._selectMonth ) );
		this._monthPickerView.setOnValueChangedListener( this._onValueChangeListener );

		this._dayPickerView.setMinValue( 1 );
		this._dayPickerView.setMaxValue( 31 );
		this._dayPickerView.setValue( Integer.valueOf( this._selectDay ) );
		this._dayPickerView.setOnValueChangedListener( this._onValueChangeListener );

		this._selectMonthTextView.setText( String.format( "%s月" , this._selectMonth ) );

		this._selectDayTextView.setText( String.format( "%s日" , this._selectDay ) );

		this._selectMonthDayButton.setOnClickListener(	this._onClickListener );
		this._dissmisDialogButton.setOnClickListener(	this._onClickListener );
		this._todaySelectButton.setOnClickListener(		this._onClickListener );

		if( !this._todaySelectButtonShowFlag ) {
			Config.DebugLog( "Remove [Today Select Button] From View" );
			( ( ViewGroup )this._todaySelectButton.getParent() ).removeView( this._todaySelectButton );
		}

		return rootView;
	}

	public void refreshSelectValues() {
		int	month	= Integer.valueOf( this._selectMonth );
		int	day		= Integer.valueOf( this._selectDay );

		if( month == 2 && day > 28 ) {
			Config.shortToast( this._context , Config.EMSG_SELECT_DATE );
			return;
		}
		else if( month == 4 && day > 30 ) {
			Config.shortToast( this._context , Config.EMSG_SELECT_DATE );
			return;
		}
		else if( month == 6 && day > 30 ) {
			Config.shortToast( this._context , Config.EMSG_SELECT_DATE );
			return;
		}
		else if( month == 9 && day > 30 ) {
			Config.shortToast( this._context , Config.EMSG_SELECT_DATE );
			return;
		}
		else if( month == 11 && day > 30 ) {
			Config.shortToast( this._context , Config.EMSG_SELECT_DATE );
			return;
		}
		else {
			Config.shortToast( this._context , String.format( "%s月%s日を選択しました" , this._selectMonth , this._selectDay ) );
			this.dismiss();
		}
	}
	public NumberPicker getMonthPickerView() {
		return this._monthPickerView;
	}
	public NumberPicker getDayPickerView() {
		return this._dayPickerView;
	}
	public TextView getSelectMonthTextView() {
		return this._selectMonthTextView;
	}
	public TextView getSelectDayTextView() {
		return this._selectDayTextView;
	}
	public void setSelectMonth( String selectMonth ) {
		this._selectMonth = selectMonth;
	}
	public String getSelectMonth() {
		return this._selectMonth;
	}
	public void setSelectDay( String selectDay ) {
		this._selectDay = selectDay;
	}
	public String getSelectDay() {
		return this._selectDay;
	}
}
