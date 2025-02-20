import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        System.out.println("Results (Sorted by Candidate Name):");
        sortedVotes.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes + " votes"));
    }

    public void displayResultsByVotes() {
        System.out.println("Results (Sorted by Votes):");
        voteMap.entrySet()
               .stream()
               .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
               .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " votes"));
    }

    public void displayVotesInOrder() {
        System.out.println("Votes Cast in Order:");
        orderedVotes.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes + " votes"));
    }
}

public class Election {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        votingSystem.displayResultsSorted();
        System.out.println();
        votingSystem.displayResultsByVotes();
        System.out.println();
        votingSystem.displayVotesInOrder();
    }
}
