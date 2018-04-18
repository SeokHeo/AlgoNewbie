public class KMP {
    static int[] pi = new int[10];

    public static void main(String[] args) {
        char[] t = {'B', 'A', 'C', 'B', 'A', 'B', 'A', 'B', 'A', 'B', 'A', 'C', 'A', 'C', 'A'};
        char[] p = {'A', 'B', 'A', 'B', 'A', 'C', 'A'};

        int idx = KMP(t, 15, p, 7);
        System.out.println(idx);
    }

    static void makeFailTable(char[] arr, int size) {
        int i=1, j=0;
        pi[0]= 0;

        while(i<size) {
            if(arr[i] == arr[j]) {
                pi[i] = j+1;
                i++;
                j++;
            } else if(j>0)
                j = pi[j-1];
            else {
                pi[i] = 0;
                i++;
            }

        }
    }

    static int KMP(char[] T, int n, char[] P, int m) {
        int i=0, j=0;
        makeFailTable(P, m);

        while(i<n) {
            if(T[i] == P[j]) {
                if(j==m-1) {
                    return i-j;
                } else {
                    i++;
                    j++;
                }
            } else if(j>0){
                j = pi[j-1];
            } else {
                i++;
            }
        }

        return -1;
    }
}
