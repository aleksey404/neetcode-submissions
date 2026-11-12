class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] row = new HashSet[9];
        Set<Integer>[] col = new HashSet[9];
        Set<Integer>[] box = new HashSet[9];

        for (int i =0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int val = board[i][j] - '0';
                int b = (i / 3) * 3 + (j / 3);
                if (row[i].contains(val)
                    || col[j].contains(val)
                    || box[b].contains(val)) {
                        return false;
                }
                row[i].add(val);
                col[j].add(val);
                box[b].add(val);

            }
        }
        return true;
    }
}
