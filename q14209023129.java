public class Main {

    public static void main(String[] args) {
        for(int S = 1; S < 10; S++) {
            for(int E = 0; E < 10; E++) {
                if (E == S) continue;
                for(int N = 0; N < 10; N++) {
                    if(N == S || N == E) continue;
                    for(int D = 0; D < 10; D++) {
                        if(D == S || D == E || D == N) continue;
                        for(int M = 1; M < 10; M++) {
                            if(M == S || M == E || M == N || M == D) continue;
                            for(int O = 0; O < 10; O++) {
                                if(O == S || O == E || O == N || O == D || O == M) continue;
                                for(int R = 0; R < 10; R++) {
                                    if(R == S || R == E || R == N || R == D || R == M || R == O) continue;
                                    for(int Y = 0; Y < 10; Y++) {
                                        if(Y == S || Y == E || Y == N || Y == D || Y == M || Y == O || Y == R) continue;
                                        if(1000 * S + 100 * E + 10 * N + 1 * D //   SEND
                                         + 1000 * M + 100 * O + 10 * R + 1 * E // + MORE
                            // -----------------------------------------------   -------
                            == 10000 * M + 1000 * O + 100 * N + 10 * E + 1 * Y)//  MONEY
                                            System.out.printf("S=%d, E=%d, N=%d, D=%d, M=%d, O=%d, R=%d, Y=%d%n",S,E,N,D,M,O,R,Y);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
