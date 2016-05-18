package io.freshnotes.domain.event;


import io.freshnotes.domain.model.Note;
import io.freshnotes.domain.persistence.DbContext;

/**
 * Created by motan on 02.11.2015.
 */
public class OnNotePressedEvent {

    public final Note note;

    public OnNotePressedEvent(Long id) {
        this.note = DbContext.Notes.findById(id);
    }
}
