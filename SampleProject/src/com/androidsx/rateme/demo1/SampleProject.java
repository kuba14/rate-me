package com.androidsx.rateme.demo1;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidcourse.t4.t6.R;

import com.androidsx.rateme.RateMeDialogTimer;
import com.androidsx.rateme.DialogRateMe;

public class SampleProject extends Activity {
    private Button buttonRateMe;
    private static final String MY_PACKAGE_NAME = "com.androidsx.smileys";
    private static final String EMAIL = "yourmail@mail.com";
    private static final int INSTALL_DAYS = 20;
    private static final int LAUNCH_TIMES = 5;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts); 
		buttonRateMe = (Button)findViewById(R.id.buttonrateme);		
		buttonRateMe.setOnClickListener(new OnClickListener() {          
            @Override
            public void onClick(View v) {
                AlertMenu();            
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Take appropriate action for each action item click

		switch (item.getItemId()) {
		case R.id.RateMe:
		    AlertMenu();

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
    @Override
    protected void onStart() {
        super.onStart();
        RateMeDialogTimer rateDialog = new RateMeDialogTimer(INSTALL_DAYS,LAUNCH_TIMES);
        RateMeDialogTimer.onStart(this);
        if (RateMeDialogTimer.shouldShowRateDialog(this)) {
            DialogFragment dialog = DialogRateMe.newInstance(
                    MY_PACKAGE_NAME,EMAIL);
            dialog.show(getFragmentManager(), "dialog");
        }
        
    }
	
    private void AlertMenu (){
	    DialogFragment dialog = DialogRateMe.newInstance(
	            MY_PACKAGE_NAME,EMAIL);
	    dialog.show(getFragmentManager(), "dialog");
	}
}
