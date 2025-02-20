import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate;
    }
}

class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> sortedByExpiry = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(days);
        return sortedByExpiry.subMap(today, true, threshold, true)
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        return policyMap.values()
                .stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .collect(Collectors.toList());
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedByExpiry.headMap(today, true).clear();
        policyMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        orderedPolicyMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    public void displayAllPolicies() {
        policyMap.values().forEach(System.out::println);
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.of(2025, 3, 10)));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.of(2025, 2, 25)));
        manager.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.of(2025, 2, 28)));

        System.out.println("All Policies:");
        manager.displayAllPolicies();

        System.out.println("\nPolicies Expiring Within 30 Days:");
        manager.getPoliciesExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nPolicies for Alice:");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);

        manager.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        manager.displayAllPolicies();
    }
}
