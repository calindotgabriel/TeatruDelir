package io.freshnotes.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import io.freshnotes.R;
import io.freshnotes.domain.event.OnNotePressedEvent;
import io.freshnotes.domain.model.Note;
import io.freshnotes.domain.persistence.DbContext;

/**
 * Created by motan on 20.10.2015.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final String TAG = this.getClass().getCanonicalName();
    private final Context mContext;
    private List<Note> mNotes;


    public NoteAdapter(Context context, List<Note> notes) {
        this.mNotes = notes;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.note_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mContent.setText(mNotes.get(position).getContent());
        holder.mTitle.setText(mNotes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void animateTo(List<Note> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateAdditions(List<Note> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Note model = newModels.get(i);
            if (!mNotes.contains(model)) {
                addNote(i, model);
            }
        }
    }

    private void applyAndAnimateRemovals(List<Note> newModels) {
        for (int i = mNotes.size() - 1; i >= 0; i--) {
            final Note model = mNotes.get(i);
            if (!newModels.contains(model)) {
                removeNote(i);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Note> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Note model = newModels.get(toPosition);
            final int fromPosition = mNotes.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveNote(fromPosition, toPosition);
            }
        }
    }

    private void deleteNote(int position) {
        final Note note = removeNote(position);
        DbContext.Notes.delete(note);
    }

    public Note removeNote(int position) {
        final Note model = mNotes.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    private void addNote(int position, Note note) {
        mNotes.add(position, note);
        notifyItemInserted(position);
    }

    private void moveNote(int fromPosition, int toPosition) {
        final Note note = mNotes.remove(fromPosition);
        mNotes.add(toPosition, note);
        notifyItemMoved(fromPosition, toPosition);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.note_content_tv)
        TextView mContent;
        @Bind(R.id.note_title_tv)
        TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container_nrvi)
        void onNotePresed() {
            EventBus.getDefault().post(new OnNotePressedEvent(getNoteId()));
        }

        @OnClick(R.id.note_item_delete)
        void onDeletePressed() {
            deleteNote(getAdapterPosition());
        }


        @OnClick(R.id.note_item_share)
        void onSharePressed() {
            startSharingIntent();
        }


        private void startSharingIntent() {
            Note note = mNotes.get(getAdapterPosition());
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, note.getTitle());
            sharingIntent.putExtra(Intent.EXTRA_TEXT, note.getContent());
            mContext.startActivity(Intent.createChooser(sharingIntent, mContext.getString(R.string.share_note)));
        }




        /**
         * Given a position inside the adapter, returns the Id of the note.
         */
        private Long getNoteId() {
            return mNotes.get(getAdapterPosition()).getId();
        }



    }

}
