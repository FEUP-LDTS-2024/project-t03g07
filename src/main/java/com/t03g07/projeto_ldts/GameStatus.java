package com.t03g07.projeto_ldts;

public class GameStatus {
    private Status currentStatus;

    public GameStatus() {
        this.currentStatus = Status.PAUSED;
    }

    public void setCurrentStatus(Status status) {
        this.currentStatus = status;
    }

    public Status getStatus() {
        return this.currentStatus;
    }

    public boolean isPaused() {
        return currentStatus == Status.PAUSED;
    }

    public boolean isRunning() {
        return currentStatus == Status.RUNNING;
    }

    public boolean isGameOver() {
        return currentStatus == Status.GAME_OVER;
    }
}
