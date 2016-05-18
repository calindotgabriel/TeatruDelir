package io.freshnotes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.freshnotes.R;
import io.freshnotes.activity.MainActivity;
import io.freshnotes.base.RecyclerViewEmptySupport;
import io.freshnotes.base.StickyBusFragment;
import io.freshnotes.domain.async.LoadNotesTask;
import io.freshnotes.domain.event.OnNotePressedEvent;
import io.freshnotes.domain.event.OnNotesLoadedEvent;
import io.freshnotes.domain.model.Note;
import io.freshnotes.fragment.adapter.NoteAdapter;
import io.freshnotes.utils.KeyboardUtils;

/**
 * Created by motan on 30.10.2015.
 */
@SuppressWarnings("ALL")
public class ListFragment extends StickyBusFragment implements SearchView.OnQueryTextListener {

    private final String TAG = this.getClass().getCanonicalName();

    @Bind(R.id.rv_fl)
    RecyclerViewEmptySupport mRecyclerView;

    @Bind(R.id.ev_fl)
    TextView mEmptyView;
    private List<Note> mNotes;
    private NoteAdapter mAdapter;


    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
        new LoadNotesTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().setDisplayShowTitleEnabled(true);
        KeyboardUtils.hideKeyboard(getActivity());
    }

    private void initList(List<Note> notes) {
        this.mNotes = notes;
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new NoteAdapter(getActivity(), new ArrayList<>(notes));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setEmptyView(mEmptyView);
    }


    /**
     * Called when the notes finished querying from the DB.
     */
    public void onEvent(OnNotesLoadedEvent event) {
        initList(event.notes);
    }

    /**
     * Called when a note was clicked in the adapter.
     */
    public void onEvent(OnNotePressedEvent event) {
        switchToDetailFragment(event.note);
    }

    @OnClick(R.id.fab)
    void onFabClicked() {
        switchToDetailFragment(null);
    }

    private void switchToDetailFragment(Note note) {
        getActivity().getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right,
                        R.anim.enter_from_left, R.anim.exit_to_left)
                .replace(R.id.fragment_container, DetailFragment.newInstance(note))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<Note> filteredList = filter(mNotes, query);
        mAdapter.animateTo(filteredList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    private List<Note> filter(List<Note> notes, String query) {
        query = query.toLowerCase();

        final List<Note> filteredModelList = new ArrayList<>();
        for (Note model : notes) {
            final String text = model.getContent().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
