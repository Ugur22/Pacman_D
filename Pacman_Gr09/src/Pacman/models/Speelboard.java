/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.util.ArrayList;

/**
 *
 * @author ugur
 */
public class Speelboard {

    private ArrayList<Vakje> vakjes;
    public ArrayList<SpelElement> spelElements;

    public Speelboard(int level) {
        ArrayList<Speelboard> Levels = new ArrayList<Speelboard>();
        ArrayList<SpelElement> SpelElementenLevel1 = new ArrayList<SpelElement>();
        ArrayList<Vakje> VakjesLevel1 = new ArrayList<Vakje>();
        int level1Width = 11;
        int level1Height = 11;
        int columnWidth = 45;
        int rowHeight = 45;
        int calcY = 0;
        int calcX = 0;
        for (int i = 0; i < 121; i++) {
            if (i % level1Width == 0 && i != 0) {
                calcY += rowHeight;
            }
            if (i % level1Width == 0) {
                calcX = 0;
            } else {
                calcX += columnWidth;
            }
            VakjesLevel1.add(new Vakje(calcX, calcY, rowHeight, columnWidth));
        }

        /* Top row */
        for (int i = 0; i < level1Width; i++) {
            SpelElementenLevel1.add(new Muur(VakjesLevel1.get(i), VakjesLevel1.get(i).xPos, VakjesLevel1.get(i).yPos, VakjesLevel1.get(i).height, VakjesLevel1.get(i).width));

        }
        /* Left row (without first and last) */
        for (int i = level1Height; i < (level1Height * level1Width - level1Width); i += level1Width) {
            SpelElementenLevel1.add(new Muur(VakjesLevel1.get(i), VakjesLevel1.get(i).xPos, VakjesLevel1.get(i).yPos, VakjesLevel1.get(i).height, VakjesLevel1.get(i).width));
        }

        /*  bottom row */
        for (int i = (level1Height * level1Width - level1Width); i < (level1Height * level1Width); i++) {
            SpelElementenLevel1.add(new Muur(VakjesLevel1.get(i), VakjesLevel1.get(i).xPos, VakjesLevel1.get(i).yPos, VakjesLevel1.get(i).height, VakjesLevel1.get(i).width));
        }

        /* Right row (without first and last) */
        for (int i = level1Height; i < (level1Height * level1Width - level1Width); i += level1Width) {
            SpelElementenLevel1.add(new Muur(VakjesLevel1.get(i + level1Width - 1), VakjesLevel1.get(i + level1Width - 1).xPos, VakjesLevel1.get(i + level1Width - 1).yPos, VakjesLevel1.get(i + level1Width - 1).height, VakjesLevel1.get(i + level1Width - 1).width));
        }
        SpelElementenLevel1.add(new SmartGhost(VakjesLevel1.get(level1Height * 8 +4), VakjesLevel1.get(level1Height * 8 + 4).xPos, VakjesLevel1.get(level1Height * 8 + 4).yPos, VakjesLevel1.get(level1Height * 8 + 4).height, VakjesLevel1.get(level1Height * 8 + 4).width));

        SpelElementenLevel1.add(new DrunkSpook(VakjesLevel1.get(level1Height * 7 + 7), VakjesLevel1.get(level1Height * 7 + 7).xPos, VakjesLevel1.get(level1Height * 7 + 7).yPos, VakjesLevel1.get(level1Height * 7 + 7).height, VakjesLevel1.get(level1Height * 7 + 7).width));
        SpelElementenLevel1.add(new DrunkSpook(VakjesLevel1.get(level1Height * 4 + 5), VakjesLevel1.get(level1Height * 4 + 5).xPos, VakjesLevel1.get(level1Height * 4 + 5).yPos, VakjesLevel1.get(level1Height * 4 + 5).height, VakjesLevel1.get(level1Height * 4 + 5).width));
        SpelElementenLevel1.add(new Muur(VakjesLevel1.get(level1Height * 2 + 2), VakjesLevel1.get(level1Height * 2 + 2).xPos, VakjesLevel1.get(level1Height * 2 + 2).yPos, VakjesLevel1.get(level1Height * 2 + 2).height, VakjesLevel1.get(level1Height * 2 + 2).width));
        SpelElementenLevel1.add(new Muur(VakjesLevel1.get(level1Height * 2 + 3), VakjesLevel1.get(level1Height * 2 + 3).xPos, VakjesLevel1.get(level1Height * 2 + 3).yPos, VakjesLevel1.get(level1Height * 2 + 3).height, VakjesLevel1.get(level1Height * 2 + 3).width));
        SpelElementenLevel1.add(new SmartGhost(VakjesLevel1.get(level1Height * 3 + 3), VakjesLevel1.get(level1Height * 3 + 3).xPos, VakjesLevel1.get(level1Height * 3 + 3).yPos, VakjesLevel1.get(level1Height * 3 + 3).height, VakjesLevel1.get(level1Height * 3 + 3).width));
        SpelElementenLevel1.add(new Bolletje(VakjesLevel1.get(level1Height * 1 + 2), VakjesLevel1.get(level1Height * 1 + 2).xPos, VakjesLevel1.get(level1Height * 1 + 2).yPos, VakjesLevel1.get(level1Height * 1 + 2).height, VakjesLevel1.get(level1Height * 1 + 2).width));
        SpelElementenLevel1.add(new Bolletje(VakjesLevel1.get(level1Height * 1 + 3), VakjesLevel1.get(level1Height * 1 + 3).xPos, VakjesLevel1.get(level1Height * 1 + 3).yPos, VakjesLevel1.get(level1Height * 1 + 3).height, VakjesLevel1.get(level1Height * 1 + 3).width));
        SpelElementenLevel1.add(new Pacman(VakjesLevel1.get(level1Height * 1 + 1), VakjesLevel1.get(level1Height * 1 + 1).xPos, VakjesLevel1.get(level1Height * 1 + 1).yPos, VakjesLevel1.get(level1Height * 1 + 1).height, VakjesLevel1.get(level1Height * 1 + 1).width));
        Levels.add(new Speelboard(SpelElementenLevel1, VakjesLevel1));
        vakjes = Levels.get(level - 1).getVakjes();
        spelElements = Levels.get(level - 1).getSpelElements();
    }

    public Speelboard(ArrayList<SpelElement> spelElements, ArrayList<Vakje> vakjes) {
        this.spelElements = spelElements;
        this.vakjes = vakjes;
    }

    public ArrayList<Vakje> getVakjes() {
        return vakjes;
    }

    public ArrayList<SpelElement> getSpelElements() {
        return spelElements;
    }

}
