package org.tony.clarke.algo.strings;

public class GenerateDocument {

    public static void main(String args[]) {
        GenerateDocument generateDocument = new GenerateDocument();
        boolean b = generateDocument.generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!");
        System.out.println(b);
    }

    public boolean generateDocument(String characters, String document) {
        for (int i = 0; i < document.length(); i++) {
            String updated = characters.replaceFirst(document.substring(i,i+1), "");
            if(updated.equals(characters)) {
                return false;
            }
            characters = updated;
        }
        return true;
    }
}
