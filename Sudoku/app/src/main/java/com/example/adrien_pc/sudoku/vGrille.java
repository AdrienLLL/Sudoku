package com.example.adrien_pc.sudoku;

public class vGrille{
    int level;
    int number;
    int Done;
    String grid;

    public vGrille(int level, int num, int done, String Grid){
        this.level = level;
        this.number=num;
        this.Done=done;
        this.grid = Grid;
    }

    public String toString(){
        return "level : " + " " + level + " " + "Number : " + " " + number + " " + "Done : " + " " + Done;
    }

    public int getLevel(){
        return level;
    }

    public String getGrid(){
        return grid;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getDone(){
        return Done;
    }

    public void setDone(int Done){
        this.Done = Done;
    }
}
