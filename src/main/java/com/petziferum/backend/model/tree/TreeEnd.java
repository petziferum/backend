package com.petziferum.backend.model.tree;

public class TreeEnd extends Node {

    private boolean finished = true;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}