package com.duduv.angels.model;

import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * angels : Created by Philippe on 27-12-22
 */
@Data
public class Draw {

    private String name;
    private Game game ;

    private Map<Player, Player> draws = new HashMap<>();

    public Collection<Player> getAllTarget() {
        return draws.values();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n");
        sb.append("################################################################################################\r\n");
        sb.append("Game : " + name + "\r\n");
        for (Map.Entry<Player, Player> draw : draws.entrySet()) {
            sb.append(draw.getKey().getName() + " =>  " + draw.getValue().getName() + "\r\n");
        }
        sb.append("################################################################################################" + "\r\n");
        return sb.toString();
    }



}
