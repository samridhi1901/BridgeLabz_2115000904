import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate; // Format: YYYY-MM-DD
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "[Policy Number: " + policyNumber + ", Holder: " + policyholderName + 
               ", Expiry: " + expiryDate + ", Type: " + coverageType + 
               ", Premium: $" + premiumAmount + "]";
    }
}

public class PolicyManager {
    public static void main(String[] args) {
        // Using HashSet for fast lookups
        Set<Policy> hashSet = new HashSet<>();

        // Using LinkedHashSet to maintain insertion order
        Set<Policy> linkedHashSet = new LinkedHashSet<>();

        // Using TreeSet to maintain sorting by expiry date
        Set<Policy> treeSet = new TreeSet<>();

        // Adding sample policies
        Policy p1 = new Policy("P001", "Alice", "2025-12-01", "Health", 5000);
        Policy p2 = new Policy("P002", "Bob", "2024-06-15", "Auto", 3000);
        Policy p3 = new Policy("P003", "Charlie", "2026-08-10", "Home", 7000);
        Policy p4 = new Policy("P004", "David", "2023-11-20", "Health", 4000);

        // Adding policies to sets
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        hashSet.add(p4);

        linkedHashSet.add(p1);
        linkedHashSet.add(p2);
        linkedHashSet.add(p3);
        linkedHashSet.add(p4);

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        // Displaying policies in different sets
        System.out.println("Policies in HashSet (Unordered, Fast Lookups):");
        System.out.println(hashSet);

        System.out.println("\nPolicies in LinkedHashSet (Maintains Insertion Order):");
        System.out.println(linkedHashSet);

        System.out.println("\nPolicies in TreeSet (Sorted by Expiry Date):");
        System.out.println(treeSet);
    }
}
