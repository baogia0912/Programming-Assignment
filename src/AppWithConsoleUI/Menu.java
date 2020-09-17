package AppWithConsoleUI;

import java.util.Scanner;

public class Menu {
    private final Validation validation;
    private final ManageLeads manageLeads;
    private final ManageInteraction manageInteraction;
    private final Summary summary;

    public Menu(Validation validation, ManageLeads manageLeads, ManageInteraction manageInteraction, Summary summary) {
        this.validation = validation;
        this.manageLeads = manageLeads;
        this.manageInteraction = manageInteraction;
        this.summary = summary;
    }

    public void menu() {
        int option;
        do {//display menu and record user's option with validation
            Scanner scanner = new Scanner(System.in);
            System.out.println("(1: manage leads), (2: manage interactions), (3: view summary), (4: Exit)");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // this is important!
            }
            option = scanner.nextInt();

            if (option == 1) {//manage leads
                do {//display menu for managing leads and record user's option with validation
                    System.out.println("(1: view leads), (2: add leads), (3: delete leads), (4: update leads), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    option = scanner.nextInt();

                    if (option == 1) {//view leads
                        option = 0;
                        manageLeads.viewLeads();
                    } else if (option == 2) {//add new lead
                        option = 0;
                        manageLeads.addLeads(manageLeads.getLeadInput());
                    } else if (option == 3) {//delete an existing lead
                        option = 0;
                        scanner = new Scanner(System.in);
                        //get a validated lead ID
                        System.out.println("Enter LeadID: ");
                        String leadID = scanner.nextLine();
                        while (!validation.isValidLeadID(leadID) || !validation.isLeadExist(leadID)) {
                            System.out.println("Invalid! \nEnter LeadID: ");
                            leadID = scanner.nextLine();
                        }
                        //asking for option to delete interaction connected to the lead
                        System.out.println("Do you want to delete interaction for this lead as well?(yes: true), (no = false): ");
                        String deleteInteractions = scanner.nextLine();
                        while (!deleteInteractions.equalsIgnoreCase("true") && !deleteInteractions.equalsIgnoreCase("false")) {
                            System.out.println("Invalid! \n(true/false): ");
                            deleteInteractions = scanner.nextLine();
                        }
                        manageLeads.deleteLeads(leadID, Boolean.parseBoolean(deleteInteractions));
                    } else if (option == 4) {//update a lead, field and what it going to be edited to
                        option = 0;
                        //getting leadID that needs to be update
                        scanner = new Scanner(System.in);
                        System.out.println("Enter LeadID(lead_XXX): ");
                        String leadID = scanner.nextLine();
                        while (!validation.isValidLeadID(leadID) || !validation.isLeadExist(leadID)) {
                            System.out.println("Invalid! \nEnter LeadID(lead_XXX): ");
                            leadID = scanner.nextLine();
                        }
                        //getting parameter to be update
                        System.out.println("Enter index (1: name), (2: date), (3: gender), (4: phone#), (5: email), (6: address): ");
                        String index = scanner.nextLine();
                        while (!validation.isValidLeadIndex(index)) {
                            System.out.println("Invalid! \nEnter index (1: name), (2: date), (3: gender), (4: phone#), (5: email), (6: address): ");
                            index = scanner.nextLine();
                        }
                        //getting edited content
                        if (Integer.parseInt(index) == 1) {
                            System.out.println("Enter Name: ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidName(editedContent)) {
                                System.out.println("Invalid! \nNo numbers or special characters: ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 2) {

                            System.out.println("Enter Date of Birth(YYYY-MM-DD): ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidDate(editedContent)) {
                                System.out.println("Invalid! \nFollow the format(YYYY-MM-DD): ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 3) {

                            System.out.println("Enter Gender(True = Male/False = Female): ");
                            String editedContent = scanner.nextLine();
                            while (!editedContent.equalsIgnoreCase("true") && !editedContent.equalsIgnoreCase("false")) {
                                System.out.println("Invalid! \n(true/false): ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 4) {

                            System.out.println("Enter Phone Number: ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidPhoneNumber(editedContent)) {
                                System.out.println("Invalid! \nOnly digits are accepted: ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 5) {
                            System.out.println("Enter Email: ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidEmail(editedContent)) {
                                System.out.println("Invalid! \nEnter Email: ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 6) {

                            System.out.println("Enter Address ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidAddress(editedContent)) {
                                System.out.println("Invalid! \nEnter Address: ");
                                editedContent = scanner.nextLine();
                            }
                            manageLeads.updateLeads(leadID, Integer.parseInt(index), editedContent);
                        }
                    }
                } while (option != 5);
                option = 0;

            } else if (option == 2) {//manage interactions
                do {//display options to manage interactions
                    System.out.println("(1: view interactions), (2: add interactions), (3: delete interactions), (4: update interactions), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    option = scanner.nextInt();

                    if (option == 1) {//view interactions
                        option = 0;
                        manageInteraction.viewInteractions();
                    } else if (option == 2) {//add new interactions with validated input
                        option = 0;
                        manageInteraction.addInteractions(manageInteraction.getInteractionInput());
                    } else if (option == 3) {//delete existing interaction with a validated interaction ID input
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter InteractionID: ");
                        String interactionID = scanner.nextLine();
                        while (!validation.isValidInteractionID(interactionID) || !validation.isInteractionExist(interactionID)) {
                            System.out.println("Invalid! \nEnter InteractionID: ");
                            interactionID = scanner.nextLine();
                        }
                        manageInteraction.deleteInteractions(interactionID);
                    } else if (option == 4) {//update an existing interaction, field and edited content
                        option = 0;
                        //getting an existing interaction ID
                        scanner = new Scanner(System.in);
                        System.out.println("Enter InteractionID: ");
                        String interactionID = scanner.nextLine();
                        while (!validation.isValidInteractionID(interactionID) || !validation.isInteractionExist(interactionID)) {
                            System.out.println("Invalid! \nEnter InteractionID: ");
                            interactionID = scanner.nextLine();
                        }
                        //getting option for the updating parameter
                        System.out.println("Enter index (1: date), (2: leadID), (3: means of contact), (4: potential)");
                        String index = scanner.nextLine();
                        while (!validation.isValidInteractionIndex(index)) {
                            System.out.println("Invalid! \nEnter index (1: date), (2: leadID), (3: means of contact), (4: potential)");
                            index = scanner.nextLine();
                        }
                        //getting edited content
                        if (Integer.parseInt(index) == 1) {

                            System.out.println("Enter Date of Interaction(YYYY-MM-DD): ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidDate(editedContent)) {
                                System.out.println("Invalid! \nEnter Date of Interaction(YYYY-MM-DD): ");
                                editedContent = scanner.nextLine();
                            }
                            manageInteraction.updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 2) {

                            System.out.println("Enter LeadID: ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidLeadID(editedContent) || !validation.isLeadExist(editedContent)) {
                                System.out.println("Invalid! \nEnter LeadID: ");
                                editedContent = scanner.nextLine();
                            }
                            manageInteraction.updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 3) {

                            System.out.println("Enter Means Of Contact: ");
                            String editedContent = scanner.nextLine();
                            while (!validation.isValidMeansOfContact(editedContent) || !validation.isValidMeansOfContact(editedContent)) {
                                System.out.println("Invalid! \nMeans can not contains special characters: ");
                                editedContent = scanner.nextLine();
                            }
                            manageInteraction.updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 4) {
                            System.out.println("Enter potential(positive,neutral,negative): ");
                            String editedContent = scanner.nextLine();
                            while (!(editedContent.equalsIgnoreCase("positive") || editedContent.equalsIgnoreCase("neutral") || editedContent.equalsIgnoreCase("negative"))) {
                                System.out.println("Invalid! \nEnter potential(positive,neutral,negative): ");
                                editedContent = scanner.nextLine();
                            }
                            manageInteraction.updateInteractions(interactionID, Integer.parseInt(index), editedContent);
                        }
                    }
                } while (option != 5);
                option = 0;
            } else if (option == 3) {//view summaries
                option = 0;
                do {//getting options for which summary to view
                    System.out.println("(1: Age summary), (2: Potential summary), (3: Interaction summary), (4: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    option = scanner.nextInt();
                    if (option == 1) {//age summary
                        option = 0;
                        summary.ageSummary();
                    } else if (option == 2) {//getting date for potential summary and view it
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter start date(YYYY-MM-DD): ");
                        String startDate = scanner.nextLine();
                        while (!validation.isValidDate(startDate)) {
                            System.out.println("Invalid! \nEnter start date(YYYY-MM-DD): ");
                            startDate = scanner.nextLine();
                        }
                        System.out.println("Enter end date(YYYY-MM-DD): ");
                        String endDate = scanner.nextLine();
                        while (!validation.isValidDate(endDate)) {
                            System.out.println("Invalid! \nEnter end date(YYYY-MM-DD): ");
                            endDate = scanner.nextLine();
                        }
                        summary.potentialSummary(startDate, endDate);
                    } else if (option == 3) {//getting date for interactions summary and view it
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter start date(YYYY-MM-DD): ");
                        String startDate = scanner.nextLine();
                        while (!validation.isValidDate(startDate)) {
                            System.out.println("Invalid! \nEnter start date(YYYY-MM-DD): ");
                            startDate = scanner.nextLine();
                        }
                        System.out.println("Enter end date(YYYY-MM-DD): ");
                        String endDate = scanner.nextLine();
                        while (!validation.isValidDate(endDate)) {
                            System.out.println("Invalid! \nEnter end date(YYYY-MM-DD): ");
                            endDate = scanner.nextLine();
                        }
                        summary.interactionSummary(startDate, endDate);
                    }
                } while (option != 4);
            }
        } while(option !=4);
    }
}
