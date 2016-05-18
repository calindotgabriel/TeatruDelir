package io.freshnotes.base;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import io.freshnotes.R;


public class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    public interface OnBackStackPoppedListener {
        void onPopped();
    }

    private OnBackStackPoppedListener mListener;

    public void setOnBackStackPoppedListener(OnBackStackPoppedListener listener) {
        this.mListener = listener;
    }

    /**
     * Back button support for fragments.
     */
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Pops the back stack of fragments and signals it to listener, if set.
     */
    private void popBackStack() {
        getFragmentManager().popBackStack();
        signalBackStackPopped();
    }

    private void signalBackStackPopped() {
        if (mListener != null) {
            mListener.onPopped();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                popBackStack();
                break;
        }
        return true;
    }

    /**
     * Back as home "up" button support.
     */
    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }


}
