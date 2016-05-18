package io.freshnotes.base;

import android.app.Fragment;

import de.greenrobot.event.EventBus;

/**
 * Created by motan on 02.11.2015.
 */
public class BaseBusFragment extends BaseFragment {

    @Override
    public void onStop() {
        bus().unregister(this);
        super.onStop();
    }


}
