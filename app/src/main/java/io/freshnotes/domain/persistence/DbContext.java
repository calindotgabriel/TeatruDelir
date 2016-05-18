package io.freshnotes.domain.persistence;

import java.util.List;

import io.freshnotes.domain.model.Note;

/**
 * Created by calin on 5/18/2016.
 */
public class DbContext {

    public static class Notes {

        public static Note findById(Long id) {
            return Note.findById(Note.class, id);
        }

        public static List<Note> listAll() {
            return Note.listAll(Note.class);
        }

        public static void save(Note note) {
            note.save();
        }

        public static void delete(Note note) {
            note.delete();
        }
    }
}
