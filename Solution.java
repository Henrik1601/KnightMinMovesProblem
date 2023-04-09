public class Solution{

public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
    int[][] moves = new int[n][n];
    for (int[] row : moves) {
        Arrays.fill(row, -1);
    }
    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {startRow, startCol});
    moves[startRow][startCol] = 0;
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int row = cur[0];
        int col = cur[1];
        if (row == endRow && col == endCol) {
            return moves[row][col];
        }
        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && moves[newRow][newCol] == -1) {
                moves[newRow][newCol] = moves[row][col] + 1;
                q.add(new int[] {newRow, newCol});
            }
        }
    }
    return -1;
}

public static void main(String args[])
{
   Solution oject = new Solution();
   System.out.println(object.minMoves(4,4,4,8)); /* first two parameters denotes current position of a knight in chess board (i.e Knight is placed at (4,4) position) and Last two parameters denotes the destination corrindates (i.e Knight has to go to destination (4,8)) */
}
}