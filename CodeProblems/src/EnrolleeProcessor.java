import java.io.*;
import java.nio.file.*;
import java.util.*;


class Enrollee implements Comparable<Enrollee>{
    String userId;
    String firstName;
    String lastName;
    int version;
    String insuranceCompany;

    public Enrollee(String userId, String firstName, String lastName, int version, String insuranceCompany) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public String toString() {
        return userId + "," + firstName + "," + lastName + "," + version + "," + insuranceCompany;
    }

    @Override
    public int compareTo(Enrollee other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollee enrollee = (Enrollee) o;
        if (this.version != enrollee.version) {
            enrollee.version = this.version;
        }
       
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, insuranceCompany);
    }
}


public class EnrolleeProcessor {
    public static void main(String[] args) {
        String inputFilePath = "CodeProblems/src/data.csv";

        Set<Enrollee> enrollees = readCsv(inputFilePath);
        Map<String, Set<Enrollee>> groupedEnrollees = groupEnrolleesByInsuranceCompany(enrollees);
        
        for (Map.Entry<String, Set<Enrollee>> entry : groupedEnrollees.entrySet()) {
            String insuranceCompany = entry.getKey();
            System.out.println("Insurance Company: " + insuranceCompany);
            for (Enrollee enrollee : entry.getValue()) {
                System.out.println(enrollee.toString());
            }
            System.out.println(); 
        }
  
    }

    private static Set<Enrollee> readCsv(String filePath){
        Set<Enrollee> enrollees = new HashSet<>();
        BufferedReader br;
        try {
            br = Files.newBufferedReader(Paths.get(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String userId = values[0];
                String firstName = values[1];
                String lastName = values[2];
                int version = Integer.parseInt(values[3]);
                String insuranceCompany = values[4];
                enrollees.add(new Enrollee(userId, firstName, lastName, version, insuranceCompany));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return enrollees;
    }

    private static Map<String, Set<Enrollee>> groupEnrolleesByInsuranceCompany(Set<Enrollee> enrollees) {
        Map<String, Set<Enrollee>> groupedEnrollees = new HashMap<>();

        for (Enrollee enrollee : enrollees) {
            if (!groupedEnrollees.containsKey(enrollee.insuranceCompany)) {
                groupedEnrollees.put(enrollee.insuranceCompany, new HashSet<>());
            }
            groupedEnrollees.get(enrollee.insuranceCompany).add(enrollee);
        }

        return groupedEnrollees;
    }

    // private static void writeGroupedEnrollees(Map<String, List<Enrollee>> groupedEnrollees) throws IOException {
    //     for (Map.Entry<String, List<Enrollee>> entry : groupedEnrollees.entrySet()) {
    //         String fileName = entry.getKey().replaceAll("\\s+", "_") + ".csv";
    //         try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
    //             for (Enrollee enrollee : entry.getValue()) {
    //                 writer.write(enrollee.toString());
    //                 writer.newLine();
    //             }
    //         }
    //     }
    // }
}

