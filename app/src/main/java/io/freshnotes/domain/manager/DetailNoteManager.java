package io.freshnotes.domain.manager;

import io.freshnotes.domain.model.Note;

/**
 * Created by calin on 5/18/2016.
 */
public class DetailNoteManager {

    private Note note;


    public void set(Note note) {
        this.note = note;
    }

    public Note get() {
        return note;
    }
}
