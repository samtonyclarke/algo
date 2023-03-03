package org.tony.clarke.algo.arrays;

import java.util.*;

public class TournamentWinner {

    public static void main(String args[]) {
        TournamentWinner tournamentWinner = new TournamentWinner();
        ArrayList<ArrayList<String>> list = new ArrayList();
        ArrayList<String> first = new ArrayList<>();
        first.add("HTML");
        first.add("Java");
        ArrayList<String> second = new ArrayList<>();
        second.add("Java");
        second.add("Python");
        ArrayList<String> third = new ArrayList<>();
        third.add("Python");
        third.add("HTML");
        list.add(first);
        list.add(second);
        list.add(third);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(1);
        results.add(1);
        String winner = tournamentWinner.tournamentWinner(list, results);
        System.out.println(winner);
    }

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        Map<String, Integer> team2Score = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> teams = competitions.get(i);
            String homeTeam = teams.get(0);
            if (!team2Score.containsKey(homeTeam)) {
                team2Score.put(homeTeam, 0);
            }
            int homeTeamCurrentScore = team2Score.get(homeTeam);
            String awayTeam = teams.get(1);
            if (!team2Score.containsKey(awayTeam)) {
                team2Score.put(awayTeam, 0);
            }
            int awayTeamCurrentScore = team2Score.get(awayTeam);
            Integer result = results.get(i);
            if (result == 0) {
                team2Score.put(awayTeam, awayTeamCurrentScore + 3);
            } else {
                team2Score.put(homeTeam, homeTeamCurrentScore + 3);
            }
        }

        int maxPoints = -1;
        String winningTeam = "";
        Set<Map.Entry<String, Integer>> entries = team2Score.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > maxPoints) {
                winningTeam = entry.getKey();
                maxPoints = entry.getValue();
            }
        }

        return winningTeam;
    }
}
