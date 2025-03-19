package controller;

import model.PlaylistModel;
import repository.PlaylistRepository;
import view.PlaylistsView;

import java.util.List;

public class PlaylistController {
    PlaylistsView playlistsView = new PlaylistsView();
    PlaylistRepository playlistRepository;

    public PlaylistController() {
        this.playlistRepository = new PlaylistRepository();
        this.playlistsView.setVisibility(true);
        this.playlistsView.setPlaylistController(this);
    }

    public void seePlaylistsButtonClicked() {
        List<PlaylistModel> playlists = playlistRepository.getAllPlaylists();
        playlistsView.displayPlaylists(playlists);

    }

    public void backButtonClicked() {
        this.playlistsView.setVisibility(false);
        UserMenuController userMenuController = new UserMenuController();
    }
}
