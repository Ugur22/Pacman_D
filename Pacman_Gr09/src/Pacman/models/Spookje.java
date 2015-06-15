/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ugur
 */
public abstract class Spookje extends Poppetje {

    private Queue<Vakje> vakjesToInspect = new LinkedList<Vakje>();
    private ArrayList<Vakje> visitedvakjes = new ArrayList<Vakje>();
    private ArrayList<Vakje> currentVakjes = new ArrayList<Vakje>();
    private ArrayList<Vakje> previousVakjes = new ArrayList<Vakje>();
    protected Stack<Vakje> movementStack = new Stack<Vakje>();
    protected boolean searching = false;

    @Override
    public void Bewegen(Direction direction) {

    }
    
    
      private void reset() {
        vakjesToInspect.clear();
        visitedvakjes.clear();
        movementStack.clear();
        currentVakjes.clear();
        previousVakjes.clear();
    }

    private void search() {
        while (!vakjesToInspect.isEmpty()) {
            Vakje current = vakjesToInspect.remove();
            visitedvakjes.add(current);
            checkNeighbors(current);
        }
    }

    private void checkNeighbors(final Vakje vakje) {

        for (Vakje u : vakje.buren.values()) {
            if (u.isPacman()) {
                if (!visitedvakjes.contains(u)) {
                    vakjesToInspect.add(u);
                    currentVakjes.add(u);
                    previousVakjes.add(vakje);
                }
                buildMovementStack(u);
                setSearching(false);
                break;
            } else {
                if (!visitedvakjes.contains(u)) {
                    vakjesToInspect.add(u);
                    currentVakjes.add(u);
                    previousVakjes.add(vakje);
                }
            }
        }

    }

    private void buildMovementStack(Vakje vakje) {
        Vakje current = vakje;

        while (current != this.vakje && !movementStack.contains(current)) {

            movementStack.push(current);
            int index = currentVakjes.indexOf(current);

            Vakje nextStep = previousVakjes.get(index);
            current = nextStep;
        }
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    private void createInitialState() {
        Vakje vakje = this.vakje;
        vakjesToInspect.add(vakje);
    }

    public void SearchIt() {
        reset();
        createInitialState();
        search();
    }

    protected void findPacman() {
        reset();
        createInitialState();
        search();
    }

}
