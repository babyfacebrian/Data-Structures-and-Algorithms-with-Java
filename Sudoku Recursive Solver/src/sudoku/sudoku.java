/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.*;

public class sudoku {
    
    private int[][] board;
    private int BacktrackCount;
    
    public sudoku(int[][] board){
        this.board = board;
        this.BacktrackCount = 0;
        
    }
    
    public void solveSudoku(int[][] board){
        if(solve(board)){
            System.out.println("Backtracking Cycles: " + this.BacktrackCount + "\n");
            for(int[] row : board){
                System.out.println(Arrays.toString(row));
            }
        }else{
            System.out.println("Invalid board");
        } 
    }
    
    public boolean solve(int[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != 0){
                    continue;
                }
                for(int k=1; k<=9; k++){
                    board[i][j] = k;
                    if(isValid(board, i, j) && solve(board)){
                        BacktrackCount--;
                        return true;
                    }
                    BacktrackCount++;
                    board[i][j] = 0;
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(int[][] board, int i, int j){
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int k=0; k<9; k++){
            if(set.contains(board[i][k])){
                return false;
            }    
            if(board[i][k]!= 0){
                set.add(board[i][k]);
            }
        }
        set.clear();
 
        for(int k=0; k<9; k++){
            if(set.contains(board[k][j])){
                return false;
            }
            if(board[k][j]!= 0 ){
                set.add(board[k][j]);
            }
        }
        set.clear();
        
        for(int m=0; m<3; m++){
            for(int n=0; n<3; n++){
                int x=i/3*3+m;
                int y=j/3*3+n;
                if(set.contains(board[x][y])){
                    return false;
                }    
                if(board[x][y]!= 0){
                    set.add(board[x][y]);
                }    
            }
        }
        return true;

    }
    
    
}
