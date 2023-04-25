package org.tony.clarke.algo.famous;

import java.util.*;

public class StableInterns {

    public static void main(String args[]) {
        StableInterns stableInterns = new StableInterns();


        int[][] interns4 = {
                /*0*/ {0, 1},
                /*1*/ {0, 1},
        };
        int[][] teams4 = {
                /*0*/ {0, 1},
                /*1*/ {0, 1},
        };

        int[][] interns8 = {
                /*0*/ {0, 1, 2},
                /*1*/ {2, 1, 0},
                /*2*/ {1, 2, 0}
        };
        int[][] interns9 = {
                /*0*/ {0, 1, 2},
                /*1*/ {0, 2, 1},
                /*2*/ {1, 2, 0}
        };
        int[][] interns = {
                /*0*/ {0, 1, 2},
                /*1*/ {0, 2, 1},
                /*2*/ {1, 2, 0}
        };

        int[][] teams8 = {
                /*0*/ {2, 1, 0},
                /*1*/ {0, 1, 2},
                /*2*/ {0, 2, 1}
        };

        int[][] teams9 = {
                /*0*/ {2, 1, 0},
                /*1*/ {0, 1, 2},
                /*2*/ {0, 2, 1}
        };
        int[][] teams = {
                /*0*/ {2, 1, 0},
                /*1*/ {0, 1, 2},
                /*2*/ {0, 1, 2}
        };


        int[][] ints = stableInterns.stableInternships(interns8, teams8);
    }

    public int[][] stableInternships(int[][] interns, int[][] teams) {
        int N = interns.length;
        if (N == 0) {
            return new int[][]{};
        }

        Map<Integer, Map<Integer, Integer>> team2Intern2Preference = buildTeam2Intern2Preference(teams);


        Map<Integer, Integer> team2InternMatch = new HashMap<>();

        int[] latestInternPreference = new int[N]; // defaults to 0 for each index

        List<Integer> freeInterns = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            freeInterns.add(i);
        }

        while (freeInterns.size() > 0) {
            Integer intern = freeInterns.remove(0);
            int teamSelected = interns[intern][latestInternPreference[intern]];
            latestInternPreference[intern]++; // next time we evaluate this intern we would try the next preference
            if (!team2InternMatch.containsKey(teamSelected)) {
                // no mapping yet...so we are the best match
                team2InternMatch.put(teamSelected, intern);
            } else {
                // for the team that has multiple interested parties...settle the difference by letting the team decide
                Integer existingMatchedIntern = team2InternMatch.get(teamSelected);
                if (team2Intern2Preference.get(teamSelected).get(existingMatchedIntern) <
                        team2Intern2Preference.get(teamSelected).get(intern)) {
                    // existing match is preferred, so put intern back on the list to be processed
                    freeInterns.add(intern);
                } else {
                    // proposed match is preferred
                    freeInterns.add(existingMatchedIntern);
                    team2InternMatch.put(teamSelected, intern);
                }
            }
        }


        int[][] results = new int[interns.length][2];

        for (int i = 0; i < N; i++) {
            results[i] = new int[]{team2InternMatch.get(i), i};
        }

        return results;
    }

    // provide an easy lookup from team to intern to preference
    private Map<Integer, Map<Integer, Integer>> buildTeam2Intern2Preference(int[][] teams) {
        Map<Integer, Map<Integer, Integer>> teamPreferences = new HashMap<>();
        for (int i = 0; i < teams.length; i++) {
            Map<Integer, Integer> teamRank = new HashMap<>();
            int[] team = teams[i];
            for (int j = 0; j < team.length; j++) {
                teamRank.put(team[j], j);
            }
            teamPreferences.put(i, teamRank);
        }
        return teamPreferences;
    }
}