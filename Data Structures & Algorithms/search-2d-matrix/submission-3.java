class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n;
        while(left < right){
            int mid = left + (right - left) /2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left < m * n && matrix[left / n][left % n] == target ? true : false;
    }
}
