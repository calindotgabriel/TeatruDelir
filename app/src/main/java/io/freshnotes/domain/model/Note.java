package io.freshnotes.domain.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Model class used for notes.
 */
public class Note extends SugarRecord implements Serializable {

    private String title;
    private String content;

    public Note() {
    } //required.

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
