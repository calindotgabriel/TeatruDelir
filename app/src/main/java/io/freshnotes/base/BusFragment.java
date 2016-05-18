package io.freshnotes.base;

/**
 * Created by motan on 02.11.2015.
 */
public class BusFragment extends BaseBusFragment {

    @Override
    public void onStart() {
        bus().register(this);
        super.onStart();
    }

}
