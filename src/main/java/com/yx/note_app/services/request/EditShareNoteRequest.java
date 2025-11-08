package com.yx.note_app.services.request;

public class EditShareNoteRequest extends ApiRequest{
    private Integer shareNoteId;
    private String updatedShareNoteTitle;
    private String updatedShareNoteContent;

    public Integer getShareNoteId() {
        return shareNoteId;
    }

    public void setShareNoteId(Integer shareNoteId) {
        this.shareNoteId = shareNoteId;
    }

    public String getUpdatedShareNoteTitle() {
        return updatedShareNoteTitle;
    }

    public void setUpdatedShareNoteTitle(String updatedShareNoteTitle) {
        this.updatedShareNoteTitle = updatedShareNoteTitle;
    }

    public String getUpdatedShareNoteContent() {
        return updatedShareNoteContent;
    }

    public void setGetUpdatedShareNoteContent(String getUpdatedShareNoteContent) {
        this.updatedShareNoteContent = getUpdatedShareNoteContent;
    }
}
