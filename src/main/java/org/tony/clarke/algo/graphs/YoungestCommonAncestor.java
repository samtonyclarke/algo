package org.tony.clarke.algo.graphs;

import java.util.ArrayList;
import java.util.List;

public class YoungestCommonAncestor {

    public static void main(String args[]) {

        AncestralTree A = new AncestralTree('A');
        AncestralTree H = new AncestralTree('H');
        AncestralTree I = new AncestralTree('I');
        AncestralTree D = new AncestralTree('D');
        AncestralTree E = new AncestralTree('E');
        H.ancestor = D;
        I.ancestor = D;
        AncestralTree B = new AncestralTree('B');
        D.ancestor = B;
        E.ancestor = B;
        B.ancestor = A;
        AncestralTree F = new AncestralTree('F');
        AncestralTree G = new AncestralTree('G');
        AncestralTree C = new AncestralTree('C');
        F.ancestor = C;
        G.ancestor = C;
        C.ancestor = A;

        AncestralTree A1 = new AncestralTree('A');
        AncestralTree B1 = new AncestralTree('B');
        B1.ancestor = A1;

        AncestralTree youngestCommonAncestor = getYoungestCommonAncestor(A1, A1, B1);
//        AncestralTree youngestCommonAncestor = getYoungestCommonAncestor(A, E, I);
        System.out.println(youngestCommonAncestor.name);

    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        AncestralTree d1 = descendantOne;
        AncestralTree d2 = descendantTwo;

        List<AncestralTree> d1s = new ArrayList<>();

        while (d1.ancestor != null) {
            d1s.add(d1);
            d1 = d1.ancestor;
        }
        d1s.add(d1);

        while (d2.ancestor != null) {
            if (d1s.contains(d2)) {
                return d2;
            }
            d2 = d2.ancestor;
        }
        if (d1s.contains(d2)) {
            return d2;
        }

        return null;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
