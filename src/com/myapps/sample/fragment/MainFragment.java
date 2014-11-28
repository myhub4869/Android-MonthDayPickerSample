package com.myapps.sample.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.myapps.Config;
import com.myapps.sample.listener.MainFragmentOnClickListener;
import com.myapps.sample.monthdaypicker.R;

public class MainFragment extends Fragment {

	private	Context						_context;
	private	Button						_showMonthDayPickerButtonView01;
	private	MainFragmentOnClickListener	_onClickListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Config.DebugLog( "AnniversaryListFragment >>> onCreate" );
		super.onCreate(savedInstanceState);
		setHasOptionsMenu( true );

		this._context			= this.getActivity();
		this._onClickListener	= new MainFragmentOnClickListener();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Config.DebugLog( "AnniversaryListFragment >>> onCreateView" );
		View	rootView						= inflater.inflate( R.layout.main_fragment , container , false );
		this._showMonthDayPickerButtonView01	= ( Button	)rootView.findViewById( R.id.showPickerButton01 );

		this._showMonthDayPickerButtonView01.setOnClickListener( this._onClickListener );

		return rootView;
	}
	@Override
	public void onResume() {
		Config.DebugLog( "AnniversaryListFragment >>> onResume" );
		super.onResume();
	}
	@Override
	public void onPause() {
		Config.DebugLog( "AnniversaryListFragment >>> onPause" );
		super.onPause();
	}

	public Context getContext() {
		return this._context;
	}
}
