package solutions.math;

public class ComplementOfBase10Integer1009 {
    public static int bitwiseComplement(int N) {
        String binaryString = Integer.toBinaryString(N);
        String complement = "";
        for(int i=0;i<binaryString.length();i++){
            complement += binaryString.charAt(i)=='0'?'1':'0';
        }
        return Integer.parseInt(complement,2);
    }

    public int bitwiseComplement2(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return N ^ X;
    }

    public int bitwiseComplement3(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return N - X;
    }

    public static void main(String[] args) {
        bitwiseComplement(5);
    }

}
