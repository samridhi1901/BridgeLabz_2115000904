import java.util.*;
import java.time.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate;
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

    public String getCoverageType() {
        return coverageType;
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

public class policy {
    private Set<Policy> policySet = new HashSet<>();

    public void addPolicy(Policy policy) {
        policySet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies:");
        policySet.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Within the Next 30 Days:");
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        for (Policy policy : policySet) {
            LocalDate expiry = LocalDate.parse(policy.getExpiryDate());
            if (!expiry.isAfter(threshold)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : policySet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Map<String, Integer> countMap = new HashMap<>();
        for (Policy policy : policySet) {
            countMap.put(policy.getPolicyNumber(), countMap.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number: " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P001", "Alice", "2025-12-01", "Health", 5000));
        manager.addPolicy(new Policy("P002", "Bob", "2024-06-15", "Auto", 3000));
        manager.addPolicy(new Policy("P003", "Charlie", "2026-08-10", "Home", 7000));
        manager.addPolicy(new Policy("P004", "David", "2023-11-20", "Health", 4000));
        manager.addPolicy(new Policy("P005", "Eve", LocalDate.now().plusDays(10).toString(), "Auto", 2500));
        manager.addPolicy(new Policy("P006", "Frank", LocalDate.now().plusDays(25).toString(), "Home", 4800));
        manager.addPolicy(new Policy("P002", "George", "2024-06-15", "Auto", 3000));

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Auto");
        manager.displayDuplicatePolicies();
    }
}
