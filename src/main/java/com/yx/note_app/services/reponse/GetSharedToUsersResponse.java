package com.yx.note_app.services.reponse;

import java.util.List;

public class GetSharedToUsersResponse extends ApiResponse{
    private List<String> usernames;

    public List<String> getUsername() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
