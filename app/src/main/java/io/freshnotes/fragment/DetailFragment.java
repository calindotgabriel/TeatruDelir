package io.freshnotes.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.freshnotes.R;
import io.freshnotes.activity.MainActivity;
import io.freshnotes.base.BaseActivity;
import io.freshnotes.base.BaseFragment;
import io.freshnotes.domain.manager.DetailNoteManager;
import io.freshnotes.domain.model.Note;
import io.freshnotes.domain.persistence.DbContext;
import io.freshnotes.utils.Constants;
import io.freshnotes.utils.KeyboardUtils;

public class DetailFragment extends BaseFragment {

    MainActivity mMainActivity;

    @Bind(R.id.content_fd)
    EditText mContentEt;

    @Bind(R.id.title_fd)
    EditText mTitleEt;

    DetailNoteManager mDetailNoteManager;


    public DetailFragment() { }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDetailNoteManager = new DetailNoteManager();

        KeyboardUtils.showKeyboard(mContentEt);

        final Bundle args = getArguments();
        if (args != null) {
            Note note = (Note) args.getSerializable(Constants.KEY_NOTE);
            this.setTargetedNote(note);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainActivity = (MainActivity) getActivity();

        mMainActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        mMainActivity.setOnBackStackPoppedListener(new BaseActivity.OnBackStackPoppedListener() {
            @Override
            public void onPopped() {
                saveNoteIfNecessary();
            }
        });
    }

    private void saveNoteIfNecessary() {
        final String title = mTitleEt.getText().toString();
        final String content = mContentEt.getText().toString();

        final Note focusedNote = mDetailNoteManager.get();
        final boolean newNote = focusedNote == null;
        if (newNote) {
            Note note = new Note(title, content);
            DbContext.Notes.save(note);
        } else {
            focusedNote.setTitle(title);
            focusedNote.setContent(content);
            DbContext.Notes.save(focusedNote);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Creates a new instance of this fragment with a note coming from the list.
     * @param note note coming from the #ListFragment
     * @return instance of this fragment
     */
    public static Fragment newInstance(Note note) {
        final DetailFragment fragment = new DetailFragment();
        if (note != null) {
            Bundle args = new Bundle();
            args.putSerializable(Constants.KEY_NOTE, note);
            fragment.setArguments(args);
        }
        return fragment;
    }


    /**
     * Sets the fragment's focus to a note.
     * @param note note to focus to
     */
    public void setTargetedNote(Note note) {
        mDetailNoteManager.set(note);
        fillFields(note);
    }

    private void fillFields(Note targetedNote) {
        mTitleEt.setText(targetedNote.getTitle());
        mContentEt.setText(targetedNote.getContent());
    }


}
