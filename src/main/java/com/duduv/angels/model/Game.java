package com.duduv.angels.model;

import lombok.Data;

import java.util.List;

/**
 * angels : Created by Philippe on 27-12-22
 */
@Data
public class Game {

    private String name;
    private List<Player> players;
    private String  mailSubject;

}
