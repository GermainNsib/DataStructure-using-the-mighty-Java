package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        public class AgencyList {
            private List<String> agencies;

            public AgencyList() {
                agencies = new ArrayList<>();
            }

            public void addAgency(String agencyName) {
                agencies.add(agencyName);
            }

            public void removeAgency(String agencyName) {
                agencies.remove(agencyName);
            }

            public boolean containsAgency(String agencyName) {
                return agencies.contains(agencyName);
            }

            public List<String> getAgencies() {
                return agencies;
            }

            public static void main(String[] args) {
                AgencyList agencyList = new AgencyList();
                agencyList.addAgency("Agency A");
                agencyList.addAgency("Agency B");
                agencyList.addAgency("Agency C");

                System.out.println("Agencies:");
                for (String agency : agencyList.getAgencies()) {
                    System.out.println(agency);
                }

                System.out.println("\nRemoving 'Agency B'");
                agencyList.removeAgency("Agency B");

                System.out.println("Agencies after removal:");
                for (String agency : agencyList.getAgencies()) {
                    System.out.println(agency);
                }

                System.out.println("\nDoes the list contain 'Agency C'? " + agencyList.containsAgency("Agency C"));
            }
        }
    }
}
