package controller;

import model.TrackModel;
import repository.TrackRepository;
import view.AddTrackView;
import view.TracksView;

import java.util.List;

public class TrackController {
    TrackRepository trackRepository;
    TracksView tracksView = new TracksView();
    AddTrackView addTrackView = new AddTrackView();

    public TrackController() {
        this.trackRepository = new TrackRepository();
        this.tracksView.setVisibility(true);
        this.tracksView.setTrackController(this);
    }

    public void addTrackButtonClicked() {
        AddTrackController addTrackController = new AddTrackController();
    }

    public void getAllTracksAndDisplay() {
        List<TrackModel> tracks = trackRepository.getAllTracks();
        tracksView.displayTracks(tracks);
    }

    public void orderButtonClicked() {
        List<TrackModel> orderedTracks = trackRepository.getOderedTracks();
        tracksView.displayTracks(orderedTracks);
    }

}
