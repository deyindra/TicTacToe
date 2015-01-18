package com.opentable.tictactoe.game;

/**
 * A final class represents player
 * @author indranil dey
 */
public final class Player {
    /**
     * Define Player index which is 1 based index
     */
    private int playerId;
    private String playerName;

    public Player(int playerId, String playerName) {
        if(playerId<=0){
            throw new IllegalArgumentException("Invalid Player id");
        }
        if(playerName==null || ("").equals(playerName.trim())){
            throw new IllegalArgumentException("Invalid Player name");
        }
        this.playerId = playerId;
        this.playerName = playerName.trim();
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerId != player.playerId) return false;
        if (playerName != null ? !playerName.equals(player.playerName) : player.playerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId;
        result = 31 * result + (playerName != null ? playerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return playerName;
    }
}
