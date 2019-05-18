public class WhatIsIt {

    private int[][] tableCayley;
    private int len, indElem;

    public WhatIsIt(int[][] tableCayley, int len) {

        this.tableCayley = tableCayley;
        this.len = len;
    }

    private enum type {
        //переименовать
        nothing,
        magma,
        semigroup,
        group,
        abeliangroup,
        monoid,
        commutativemonoid
    }

    public type whatIsIt() {

        if (!foo()) {
            return type.nothing;
        }

        if (Associative()) {
            if (IndentityElem()) {
                if (InverseElem()) {
                    if (Commutative()) {
                        return type.abeliangroup;
                    }
                    return type.group;
                }
                if (Commutative()) {
                    return type.commutativemonoid;
                }
                return type.monoid;
            }
            return type.semigroup;
        }
        return type.magma;
    }

    private boolean foo() {

        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                if (tableCayley[a][b] >= len) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean Associative() {

        int z1, z2;
        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                for (int c = 0; c < len; c++) {
                    z1 = tableCayley[a][b];
                    z2 = tableCayley[b][c];
                    if (tableCayley[z1][c] != tableCayley[a][z2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean IndentityElem() {

        boolean flag = false;
        for (int e = 0; e < len; e++) {
            for (int x = 0; x < len; x++) {
                if (tableCayley[e][x] == x && tableCayley[x][e] == x) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                indElem = e;
                return true;
            }
        }
        return false;
    }

    private boolean InverseElem()
    {
        boolean flag = false;
        for (int x = 0; x < len; x++) {
            for (int a = 0; a < len; a ++) {
                if (tableCayley[x][a] == indElem && tableCayley[a][x] == indElem) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private boolean Commutative() {

        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                if (tableCayley[a][b] != tableCayley[b][a]) {
                    return false;
                }
            }
        }
        return true;
    }
}
