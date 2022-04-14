package solutions.hashtable;

public class SudoKSolver37 {
    public void solveSudoku(int[][] board) {
        if(board==null||board.length==0) return;
        solve(board,0,0);
    }

    private boolean solve(int[][] b,int r,int c){
        for(int row=r;row<b.length;row++,c=0){
            for(int col=c;col<b[0].length;col++){
                if(b[row][col]==0){
                    for(int i=1;i<=9;i++){
                        if(isValid(b,row,col,i)) {
                            b[row][col]=i;
                            if(solve(b,row,col+1)) return true;
                            else b[row][col]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] b,int row, int col, int x){
        for(int i=0;i<b.length;i++){
            if(b[row][i]==x) return false;
            if(b[i][col]==x) return false;
            if(b[3*(row/3)+i/3][3*(col/3)+i%3]==x) return false;
        }
        return true;
    }
}
