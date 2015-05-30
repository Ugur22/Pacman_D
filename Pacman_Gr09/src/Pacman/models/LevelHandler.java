/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.util.List;

/**
 *
 * @author ugur
 */
public class LevelHandler {

    public final int rowMax = 9;

    public int[] level;

    public int[] level_one = {
        1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 0, 5, 0, 0, 0, 4, 0, 1,
        1, 3, 1, 1, 1, 1, 1, 0, 1,
        1, 0, 1, 0, 0, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 0, 1, 0, 1,
        1, 0, 1, 5, 1, 0, 2, 0, 1,
        1, 0, 0, 2, 0, 0, 1, 0, 1,
        1, 0, 1, 0, 1, 5, 1, 0, 1,
        1, 0, 4, 0, 0, 0, 0, 0, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1
    };

}
