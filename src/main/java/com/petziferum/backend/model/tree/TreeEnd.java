package com.petziferum.backend.model.tree;

public class TreeEnd extends TreeNode {

    private boolean finished = true;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}