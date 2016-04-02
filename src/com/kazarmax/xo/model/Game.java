package com.kazarmax.xo.model;

public class Game {

    private final Player[] players;

    private final Field field;

    private final String name;

    public Game(final Player[] players, final Field field, final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayerByFigure(final Figure figure) {

        for (Player player : getPlayers()) {
            if (player.getFigure() == figure)
                return player;
        }
        return null;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

}
