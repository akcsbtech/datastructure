/**
 * 
 */
package leetcodeproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetNQueen2 {

	/**
	 * @param args
	 */
	
	static List<List<String>> res=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(4));
	}
	
	public static  List<List<String>> solveNQueens(int n){
		placeQueens(new int [n][n],0,new HashSet<>(),new HashSet<>(),new HashSet<>());
		return res;
	}
	public static void placeQueens(int [][] board, int i, Set<Integer> digonal1,Set<Integer> digonal2,Set<Integer> vertical) {
	if(i==board.length) {
		//addtolist
		addToList(board);
		return ;
	}
	
	for(int j=0;j<board.length;j++) {
	if(!digonal1.contains(i+j) && !digonal2.contains(j-i) && !vertical.contains(j)) {
		board[i][j]=1;
		digonal1.add(i+j);
		digonal2.add(j-i);
		vertical.add(j);
		placeQueens(board, i+1, digonal1, digonal2, vertical);
		board[i][j]=0;
		digonal1.remove(i+j);
		digonal2.remove(j-i);
		vertical.remove(j);
	}	
	}
	}
	
	public static void addToList(int [][] board) {
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<board.length;++i) {
			String temp="";
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==0) {
					temp+=".";
				}else {
					temp+="Q";
				}
			}
			list.add(temp);
		}
		res.add(list);
	}

}
