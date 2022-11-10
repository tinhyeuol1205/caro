package caro.Model;

import java.util.ArrayList;

public class Board {
    private int[][] data;
    private int size = 19;

    public Board() {
        data = new int[21][21];
        for(int row = 0;row<=size+1;row++)
            for(int col=0;col<=size+1;col++){
                data[row][col] = 0;
            }
    }
    public Board(Board board) {
        int[][] matrixToCopy = board.getData();
        data = new int[21][21];
        for(int i=0;i<matrixToCopy.length; i++) {
            for(int j=0; j<matrixToCopy.length; j++) {
                data[i][j] = matrixToCopy[i][j];
            }
        }
    }
    public void printBoardMatrix() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void addMove(Board board, int player,int row, int col){
        board.getData()[row][col] = player;
    }

    public ArrayList<int[]> allNeighbours(){
        ArrayList<int[]> neighbourList = new ArrayList<int[]>();
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                if(data[i][j]!=0) continue;
                if(data[i][j-1]!=0||data[i][j+1]!=0||data[i-1][j]!=0||data[i+1][j]!=0
                        ||data[i-1][j-1]!=0||data[i+1][j-1]!=0||data[i-1][j+1]!=0||data[i+1][j+1]!=0){
                    int[] neighbour = {i,j};
                    neighbourList.add(neighbour);
                }
            }
        }
        return neighbourList;
    }

    public boolean checkWin(int player){
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size-4;j++){
                //hang
                if(j<=size-4)
                    if(data[i][j]+data[i][j+1]+data[i][j+1]+data[i][j+3]+data[i][j+4]==5*player)
                        return true;
                //cot
                if(i<=size-4)
                    if(data[i][j]+data[i+1][j]+data[i+2][j]+data[i+3][j]+data[i+4][j]==5*player)
                        return true;
                //cheo xuoi
                if(i<=size-4&&j<=size-4)
                    if(data[i][j]+data[i+1][j+1]+data[i+2][j+2]+data[i+3][j+3]+data[i+4][j+4]==5*player)
                        return  true;
                //cheo nguoc
                if(i<=size-4&&j>=5)
                    if(data[i][j]+data[i+1][j-1]+data[i+2][j-2]+data[i+3][j-3]+data[i+4][j-4]==5*player)
                        return true;
            }
        }
        return false;
    }

    public boolean isFull(){
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size ; j++) {
                if(data[i][j]==0) return false;
            }
        }
        return true;
    }
    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

}