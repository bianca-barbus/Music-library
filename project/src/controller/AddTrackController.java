package controller;

import model.TrackModel;
import repository.TrackRepository;
import view.AddTrackView;

import java.sql.SQLException;

public class AddTrackController {
    TrackRepository trackRepository;
    AddTrackView addTrackView = new AddTrackView();

    public AddTrackController() {
        this.trackRepository = new TrackRepository();
        this.addTrackView.setVisibility(true);
        this.addTrackView.setAddTrackController(this);
    }

    public void addTrack() {
        try {
            TrackModel model = new TrackModel();
            model.setTitle(this.addTrackView.getTitle());
            model.setArtist(this.addTrackView.getArtist());
            model.setAlbum(this.addTrackView.getAlbum());
            model.setGenre(this.addTrackView.getGenre());
            model.setDuration(this.addTrackView.getDuration());
            trackRepository.addTrack(model);
            this.addTrackView.showMessage("Track added successfully", 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}