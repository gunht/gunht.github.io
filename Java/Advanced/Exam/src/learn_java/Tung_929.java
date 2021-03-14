package learn_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Tung_929 {
    public static void main(String[] args) {
//        String[] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String[] str = {"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};
        System.out.println(numUniqueEmails(str));
    }

    public static int numUniqueEmails(String[] emails) {
        int n = emails.length;
        int result = n;
        String[] nStr = new String[n];
        String s = "";
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            int m = emails[i].indexOf('@');
            for (int j = 0; j < m; j++) {
                if (emails[i].charAt(j) == '.') {
                    continue;
                } else if (emails[i].charAt(j) == '+') {
                    break;
                }
                s += emails[i].charAt(j);
            }
            s += emails[i].substring(m);
            nStr[i] = s;
            s = "";
        }
        for (int i = 0; i < n; i++) {
            set.add(nStr[i]);
        }
        return set.size();
    }
}
