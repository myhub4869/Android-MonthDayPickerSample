package com.myapps;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;


public class Config {
	private	static	final	String	errorLine		= "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public	static	final	boolean isDebug			= true;

	public static final String	APP_TAG				= "MyApps-SampleProj";
	public static final String	PREF_NAME			= "SampleProj";

	public static final String	EMSG_SELECT_DATE	= "不正な日付です。";

	public static void ActivityFinishDialog( final Activity activity ) {
		AlertDialog.Builder werning = new AlertDialog.Builder( activity );
		werning.setTitle( "Warning!!" ).setMessage( "アプリを終了します\nよろしいですか?" ).setCancelable( false )
		.setPositiveButton("OK" , new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				activity.finish();
			}
		})
		.setNegativeButton( "NO" , new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		}).show();
	}

	public static void MethodStartLog() {
		StringBuffer		buffer	= new StringBuffer();
		StackTraceElement	stack	= new Throwable().getStackTrace()[ 1 ];
		Calendar			thisDate	= Calendar.getInstance();

		buffer.append( ( String )android.text.format.DateFormat.format( "YYYY-MM-dd HH:ii:ss" , thisDate ) );
		buffer.append( "[" );
		buffer.append( stack.getClassName() + " " + stack.getMethodName() );
		buffer.append( "]" );
		buffer.append( " ------------------------------------------------------------------------------------" );
	}
	public static void MethodEndLog() {
		StringBuffer		buffer	= new StringBuffer();
		StackTraceElement	stack	= new Throwable().getStackTrace()[ 1 ];
		Calendar			thisDate	= Calendar.getInstance();

		buffer.append( ( String )android.text.format.DateFormat.format( "YYYY-MM-dd HH:ii:ss" , thisDate ) );
		buffer.append( "[" );
		buffer.append( stack.getClassName() + " " + stack.getMethodName() );
		buffer.append( "]" );
		buffer.append( " ------------------------------------------------------------------------------------" );
	}
	public static void DebugLog( String logStr ) {
		if( isDebug ) {
			Log.d( APP_TAG , logStr );
		}
	}
	public static void DebugLog( String[] logStrs ) {
		if( isDebug )
			for( int i = 0 ; i < logStrs.length ; ++i )
				Log.d( APP_TAG ,logStrs[ i ] );
	}
	public static void ErrorLog( String logStr ) {
		if( isDebug ) {
			Log.e( APP_TAG , Config.errorLine );
			Log.e( APP_TAG , logStr );
			Log.e( APP_TAG , Config.errorLine );
		}
	}
	public static void ErrorLog( Exception e ) {
		if( isDebug ) {
			Log.e( APP_TAG , Config.errorLine );
			Log.e( APP_TAG , e.getClass().getSimpleName() );
			Log.e( APP_TAG , Config.errorLine );
			for( StackTraceElement stElement : e.getStackTrace() )
				Log.e( APP_TAG , stElement.toString() );
			Log.e( APP_TAG , Config.errorLine );
		}
	}

	public static boolean isNetworkConection( Context context ) {
		ConnectivityManager	conectManager	=  ( ConnectivityManager )context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo			networkInfo		= conectManager.getActiveNetworkInfo();
		if( networkInfo != null ){
			return networkInfo.isConnected();
		}
		else {
			return false;
		}
	}


	public static void shortToast( Context context , String showMsg ) {
		Toast.makeText( context , showMsg , Toast.LENGTH_SHORT ).show();
	}

	public static String toHex2String( int i ) {
		if( i >= 0 && i < 0x10 )	return "0" + Integer.toHexString( i );
		else						return Integer.toHexString( i & 0xff );
    }
    public static String toHexString( byte[] data ) {
    	String s = "";
    	for (int i = 0; i < data.length; i++) s += Config.toHex2String( data[ i ] );
        return s;
    }
}
