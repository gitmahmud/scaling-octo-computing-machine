package model;


public class SkiPath{
    private int length;
    private int drop;
    public SkiPath(){
        this.length = 1;
        this.drop = 0;
    }

    public SkiPath(int length, int drop) {
        this.length = length;
        this.drop = drop;
    }

    public int getLength() {
        return length;
    }

    public int getDrop() {
        return drop;
    }
}