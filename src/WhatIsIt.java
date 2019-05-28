public class WhatIsIt {

    private int[][] tableCayley;
    private int size, indElem;

    public WhatIsIt(int[][] tableCayley, int size) {

        this.tableCayley = tableCayley;
        this.size = size;
    }

    private enum type {
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
            if (IdentityElem()) {
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

        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                if (tableCayley[a][b] >= size) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean Associative() {

        int z1, z2;
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                for (int c = 0; c < size; c++) {
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

    private boolean IdentityElem() {

        for (int e = 0; e < size; e++) {
            boolean flag = true;
            for (int x = 0; x < size; x++) {
                if (tableCayley[e][x] != x || tableCayley[x][e] != x) {
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
        for (int x = 0; x < size; x++) {
            for (int a = 0; a < size; a ++) {
                if (tableCayley[x][a] == indElem && tableCayley[a][x] == indElem) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            flag = false;
        }
        return true;
    }

    private boolean Commutative() {

        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                if (tableCayley[a][b] != tableCayley[b][a]) {
                    return false;
                }
            }
        }
        return true;
    }
}
