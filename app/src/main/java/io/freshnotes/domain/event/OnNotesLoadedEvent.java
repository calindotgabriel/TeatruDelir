package io.freshnotes.domain.event;

import java.util.List;

import io.freshnotes.domain.model.Note;


/**
 * Created by motan on 02.11.2015.
 */
public class OnNotesLoadedEvent {

    public final List<Note> notes;

    public OnNotesLoadedEvent(List<Note> notes) {
        this.notes = notes;
    }

}
