import java.util.*;
import java.util.Deque;
import java.util.LinkedList;
class Sofa {
    int fr, fc, sr, sc, mov = 0;
    char dir;
    public Sofa(int fr, int fc, int sr, int sc, int m, char d) {
        this.fr = fr;
        this.fc = fc;
        this.sr = sr;
        this.sc = sc;
        mov = m;
        dir = d;
    }
}
class Main {
        static boolean canAdd(int fsr, int fsc, int ssr, int ssc,
                          List<String> vis, char a[][]) {
        int r = a.length;
        int c = a[0].length;
        if (fsr<0 || fsr>= r || fsc< 0 || fsc >= c || ssr < 0 || ssr >= r || ssc < 0 || ssc >= c)
            return false;
        if (a[fsr][fsc] == 'H' || a[ssr][ssc] == 'H')
            return false;
        String t = fsr + "-" + fsc + "-" + ssr + "-" + ssc;
        if (vis.contains(t))
            return false;
        vis.add(t);
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char a[][] = new char[r][c];
        int fsr = -1, fsc = -1, ssr = -1, ssc = -1;
        int p = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = sc.next().charAt(0);
                a[i][j] = ch;
                if (ch == 's') {
                    if (p > 0) {
                        ssr = i;
                        ssc = j;
                    } else {
                        fsr = i;
                        fsc = j;
                        p++;
                    }
                }
            }
        }
        if (fsr > ssr || (fsr == ssr && fsc > ssc)) {
            int tr = fsr, tc = fsc;
            fsr = ssr;
            fsc = ssc;
            ssr = tr;
            ssc = tc;
        }
        Deque<Sofa> q = new LinkedList<>();
        List<String> vis = new ArrayList<>();
        vis.add(fsr + "-" + fsc + "-" + ssr + "-" + ssc);
        Sofa sof = new Sofa(fsr, fsc, ssr, ssc, 0,
                            (fsr == ssr) ? 'H' : 'V');
        q.addLast(sof);
        while (!q.isEmpty()) {
            Sofa s = q.pollFirst();
            if (a[s.fr][s.fc] == 'S' && a[s.sr][s.sc] == 'S') {
                System.out.println(s.mov);
                return;
            }
            if (s.dir == 'H') {
                // left
                if (canAdd(s.fr, s.fc - 1, s.sr, s.sc - 1, vis, a)) {
                    q.addLast(new Sofa(s.fr, s.fc-1, s.sr, s.sc - 1,
                                       s.mov + 1, 'H'));
                }
                // right
                if (canAdd(s.fr, s.fc + 1, s.sr, s.sc + 1, vis, a)) {
                    q.addLast(new Sofa(s.fr, s.fc+1, s.sr, s.sc + 1,
                                       s.mov+1, 'H'));
                }
                // up
                if (canAdd(s.fr - 1, s.fc, s.sr - 1, s.sc, vis, a)) {
                    q.addLast(new Sofa(s.fr - 1, s.fc, s.sr - 1, s.sc,
                                       s.mov + 1, 'H'));
                }
                // down
                if (canAdd(s.fr + 1, s.fc, s.sr + 1, s.sc, vis, a)) {
                    q.addLast(new Sofa(s.fr+1, s.fc, s.sr + 1, s.sc,
                                       s.mov + 1, 'H'));
                }
                // rotate down
                if (s.fr + 1 < r && s.fc + 1 < c &&
                    a[s.fr + 1][s.fc] != '1' &&
                    a[s.fr + 1][s.fc + 1] != '1') {
                    // first down
                    if (canAdd(s.fr, s.fc, s.fr+1, s.fc, vis, a)) {
                        q.addLast(new Sofa(s.fr, s.fc, s.fr + 1, s.fc,
                                           s.mov + 1, 'V'));
                    }
                    // second down
                    if (canAdd(s.fr, s.fc + 1, s.fr + 1, s.fc + 1, vis, a)) {
                        q.addLast(new Sofa(s.fr, s.fc + 1, s.fr + 1, s.fc + 1,
                                           s.mov + 1, 'V'));
                    }
                }
                // rotate up
                if (s.fr > 0 && s.fc + 1 < c &&
                    a[s.fr - 1][s.fc] != '1' &&
                    a[s.fr - 1][s.fc + 1] != '1') {
                    // first up
                    if (canAdd(s.fr - 1, s.fc, s.fr, s.fc, vis, a)) {
                        q.addLast(new Sofa(s.fr - 1, s.fc, s.fr, s.fc,
                                           s.mov + 1, 'V'));
                    }
                    // second up
                    if (canAdd(s.fr - 1, s.fc + 1, s.fr, s.fc + 1, vis, a)) {
                        q.addLast(new Sofa(s.fr - 1, s.fc + 1, s.fr, s.fc + 1,
                                           s.mov + 1, 'V'));
                    }
                }
            }

            if (s.dir == 'V') {
                // up
                if (canAdd(s.fr - 1, s.fc, s.sr - 1, s.sc, vis, a)) {
                    q.addLast(new Sofa(s.fr - 1, s.fc, s.sr - 1, s.sc,
                                       s.mov + 1, 'V'));
                }
                // down
                if (canAdd(s.fr + 1, s.fc, s.sr + 1, s.sc, vis, a)) {
                    q.addLast(new Sofa(s.fr + 1, s.fc, s.sr + 1, s.sc,
                                       s.mov + 1, 'V'));
                }
                // left
                if (canAdd(s.fr, s.fc - 1, s.sr, s.sc - 1, vis, a)) {
                    q.addLast(new Sofa(s.fr, s.fc - 1, s.sr, s.sc - 1,
                                       s.mov + 1, 'V'));
                }
                // right
                if (canAdd(s.fr, s.fc + 1, s.sr, s.sc + 1, vis, a)) {
                    q.addLast(new Sofa(s.fr, s.fc + 1, s.sr, s.sc + 1,
                                       s.mov + 1, 'V'));
                }
                // rotate right
                if (s.fc + 1 < c &&
                    a[s.fr][s.fc + 1] != '1' &&
                    a[s.sr][s.sc + 1] != '1') {

                    // first right
                    if (canAdd(s.fr, s.fc, s.fr, s.fc + 1, vis, a)) {
                        q.addLast(new Sofa(s.fr, s.fc, s.fr, s.fc + 1,
                                           s.mov + 1, 'H'));
                    }

                    // second right
                    if (canAdd(s.sr, s.sc, s.sr, s.sc + 1, vis, a)) {
                        q.addLast(new Sofa(s.sr, s.sc, s.sr, s.sc + 1,
                                           s.mov + 1, 'H'));
                    }
                }
                // rotate left
                if (s.fc > 0 &&
                    a[s.fr][s.fc - 1] != '1' &&
                    a[s.sr][s.sc - 1] != '1') {
                    // first left
                    if (canAdd(s.fr, s.fc - 1, s.fr, s.fc, vis, a)) {
                        q.addLast(new Sofa(s.fr, s.fc - 1, s.fr, s.fc,
                                           s.mov + 1, 'H'));
                    }
                    // second left
                    if (canAdd(s.sr, s.sc - 1, s.sr, s.sc, vis, a)) {
                        q.addLast(new Sofa(s.sr, s.sc - 1, s.sr, s.sc,
                                           s.mov + 1, 'H'));
                    }
                }
            }
        }

        System.out.println("-1");
    }
}
