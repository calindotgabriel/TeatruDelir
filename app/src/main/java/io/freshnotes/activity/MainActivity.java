package io.freshnotes.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.freshnotes.R;
import io.freshnotes.base.BaseActivity;
import io.freshnotes.fragment.ListFragment;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        setSupportActionBar(mToolbar);
        final Fragment listFragment = new ListFragment();
        final FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, listFragment)
                .commit();
    }


    public Toolbar getToolbar() {
        return mToolbar;
    }
}
