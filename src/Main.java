import model.SkiPath;
import util.TimerX;

import java.io.*;
import java.util.*;


public class Main {

    public static boolean debug = true;

    public static void findPath(int[][] map  , SkiPath[][] alreadyExplored, int i , int j){
        if(alreadyExplored[i][j] != null){
            return ;
        }

        int currentMaxLength = 0 ;
        int currentMaxDrop = 0;
        if(i-1>=0 && map[i-1][j] <map[i][j] ){
            findPath(map, alreadyExplored, i - 1, j);
            if(alreadyExplored[i-1][j].getLength() >= currentMaxLength){
                currentMaxLength = alreadyExplored[i-1][j].getLength();
                currentMaxDrop = Math.max(currentMaxDrop,alreadyExplored[i-1][j].getDrop()+ (map[i][j] - map[i-1][j]));
            }
        }
        if(i+1<map.length && map[i+1][j] <map[i][j]){
            findPath(map,alreadyExplored,i+1,j);
            if(alreadyExplored[i+1][j].getLength() >= currentMaxLength){
                currentMaxLength = alreadyExplored[i+1][j].getLength();
                currentMaxDrop = Math.max(currentMaxDrop,alreadyExplored[i+1][j].getDrop()+ (map[i][j] - map[i+1][j]));
            }
        }
        if(j-1 >=0 && map[i][j-1] <map[i][j] ){
            findPath(map,alreadyExplored,i,j-1);
            if(alreadyExplored[i][j-1].getLength() >= currentMaxLength){
                currentMaxLength = alreadyExplored[i][j-1].getLength();
                currentMaxDrop = Math.max(currentMaxDrop,alreadyExplored[i][j-1].getDrop()+ (map[i][j] - map[i][j-1]));
            }
        }
        if(j+1 <map[0].length && map[i][j+1] <map[i][j]){
            findPath(map,alreadyExplored,i,j+1);
            if(alreadyExplored[i][j+1].getLength() >= currentMaxLength){
                currentMaxLength = alreadyExplored[i][j+1].getLength();
                currentMaxDrop = Math.max(currentMaxDrop,alreadyExplored[i][j+1].getDrop()+ (map[i][j] - map[i][j+1]));
            }
        }
        if(currentMaxLength == 0){
            alreadyExplored[i][j] = new SkiPath();
        }
        else {
            alreadyExplored[i][j] = new SkiPath(currentMaxLength+1, currentMaxDrop);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        TimerX.start();
        Scanner scanner = debug ? new Scanner(new File("map.txt")) : new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        if(row <=0 || column <=0){
            throw  new IllegalArgumentException();
        }

        int[][] map= new int[row][column];
        for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<column && scanner.hasNextInt() ; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        SkiPath[][] alreadyExplored = new SkiPath[row][column];

        int maxPathLength = 0 ;
        int maxPathDrop = 0;

        for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<column ; j++){
                if(alreadyExplored[i][j] == null){
                    findPath(map,alreadyExplored,i,j);
                    if(alreadyExplored[i][j].getLength() >= maxPathLength){
                        if(alreadyExplored[i][j].getLength() == maxPathLength){
                            maxPathDrop = alreadyExplored[i][j].getDrop();
                        }
                        else{
                            maxPathDrop = Math.max(maxPathDrop,alreadyExplored[i][j].getDrop());
                        }
                        maxPathLength = alreadyExplored[i][j].getLength();

                    }
                }
            }
        }

        System.out.println("Email id "+maxPathLength+maxPathDrop+"@redmart.com");

        TimerX.end(debug);
    }





}

