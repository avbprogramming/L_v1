    public class DLA {
        public static int cdDLA(CharSequence s1, CharSequence s2) {
            if (s1 == null || s2 == null) {
                throw new IllegalArgumentException("Параметр не может быть пустым");
            }
            int s1length = s1.length();
            int s2length = s2.length();
            if (s1length == 0) return s2length;
            if (s2length == 0) return s1length;
            int[][] dist = new int[s1length + 1][s2length + 1];
            for (int i = 0; i < s1length + 1; i++) {
                dist[i][0] = i;
            }
            for (int j = 0; j < s2length + 1; j++) {
                dist[0][j] = j;
            }
            for (int i = 1; i < s1length + 1; i++) {
                for (int j = 1; j < s2length + 1; j++) {
                    int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                    dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
                    if (i > 1 &&
                            j > 1 &&
                            s1.charAt(i - 1) == s2.charAt(j - 2) &&
                            s1.charAt(i - 2) == s2.charAt(j - 1)) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
                    }
                }
            }
            return dist[s1length][s2length];
        }
    }

