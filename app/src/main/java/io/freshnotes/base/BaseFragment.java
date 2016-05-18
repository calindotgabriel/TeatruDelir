package io.freshnotes.base;

import android.app.Fragment;

import de.greenrobot.event.EventBus;

/**
 * Created by motan on 10.11.2015.
 */
public class BaseFragment extends Fragment{
    protected EventBus bus() {
        return EventBus.getDefault();
    }
}
