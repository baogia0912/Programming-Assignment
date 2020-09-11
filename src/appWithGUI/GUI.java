package appWithGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private final Validation validation;
    private final ManageLeads manageLeads;
    private final ManageInteraction manageInteraction;
    private final Summary summary;

    public GUI(Validation validation, ManageLeads manageLeads, ManageInteraction manageInteraction, Summary summary) {
        this.validation = validation;
        this.manageLeads = manageLeads;
        this.manageInteraction = manageInteraction;
        this.summary = summary;
    }

    JFrame jFrame;
    JButton managingLeads;
    JButton managingInteractions;
    JButton viewSummaries;
    JPanel jPanel;
    JButton exit;

    JButton viewLeads;
    JButton addLeads;
    JButton deleteLeads;
    JButton updateLeads;

    JButton viewInteractions;
    JButton addInteractions;
    JButton deleteInteractions;
    JButton updateInteractions;

    JButton viewAgeSummary;
    JButton viewPotentialSummary;
    JButton viewInteractionSummary;

    public void gui() {
        jFrame = new JFrame();

        managingLeads = new JButton("Manage Leads");
        managingInteractions = new JButton("Manage Interactions");
        viewSummaries = new JButton("View Summaries");
        exit = new JButton("");

        viewLeads = new JButton("View Leads");
        addLeads = new JButton("Add Leads");
        deleteLeads = new JButton("Delete Leads");
        updateLeads = new JButton("Update Leads");

        viewInteractions = new JButton("View Interactions");
        addInteractions = new JButton("Add Interactions");
        deleteInteractions = new JButton("Delete Interactions");
        updateInteractions = new JButton("Update Interactions");

        viewAgeSummary = new JButton("View Age Summary");
        viewPotentialSummary = new JButton("View Potential Summary");
        viewInteractionSummary = new JButton("view Interaction Summary");

        managingLeads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.remove(managingLeads);
                jPanel.remove(managingInteractions);
                jPanel.remove(viewSummaries);

                jPanel.add(viewLeads);
                jPanel.add(addLeads);
                jPanel.add(deleteLeads);
                jPanel.add(updateLeads);

                jPanel.updateUI();
            }
        });
        managingInteractions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.remove(managingLeads);
                jPanel.remove(managingInteractions);
                jPanel.remove(viewSummaries);

                jPanel.add(viewInteractions);
                jPanel.add(addInteractions);
                jPanel.add(deleteInteractions);
                jPanel.add(updateInteractions);

                jPanel.updateUI();
            }
        });
        viewSummaries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.remove(managingLeads);
                jPanel.remove(managingInteractions);
                jPanel.remove(viewSummaries);

                jPanel.add(viewAgeSummary);
                jPanel.add(viewPotentialSummary);
                jPanel.add(viewInteractionSummary);

                jPanel.updateUI();
            }
        });

        viewLeads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                jPanel.updateUI();
            }
        });

        addLeads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteLeads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        updateLeads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewInteractions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addInteractions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteInteractions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewAgeSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewPotentialSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewInteractionSummary.addActionListener(e -> {

        });

        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        jPanel.add(managingLeads);
        jPanel.add(managingInteractions);
        jPanel.add(viewSummaries);

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Customer Relationship Management");
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
