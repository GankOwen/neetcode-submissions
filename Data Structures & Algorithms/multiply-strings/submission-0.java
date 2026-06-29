class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        for(int i = m-1; i >= 0; i--){
            int d1 = num1.charAt(i) - '0';
            for(int j = n-1; j >= 0; j--){
                int d2 = num2.charAt(j) - '0';
                int mul = d1*d2;

                int pos2 = i + j + 1;
                int pos1 = i + j;

                int sum = mul + res[pos2];
                res[pos2] = sum % 10;
                res[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < res.length && res[idx]==0) idx ++;

        while(idx < res.length){
            sb.append(res[idx]);
            idx++;
        }

        return sb.toString();
    }
}
