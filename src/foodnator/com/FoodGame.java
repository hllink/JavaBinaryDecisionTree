package foodnator.com;

import foodnator.com.foodnator.com.decision.tree.BinaryDecisionTree;
import foodnator.com.foodnator.com.decision.tree.Node;

import javax.swing.*;

public class FoodGame {

    BinaryDecisionTree decisionTree;
    JFrame frame;

    public FoodGame() {
        this.decisionTree = loadTree();
        this.frame = new JFrame("Foodnator 3000");
        this.showQuestion();
    }


    private BinaryDecisionTree loadTree() {
        decisionTree = new BinaryDecisionTree();

        Node rootNode = new Node();
        rootNode.setName("Init");
        rootNode.setAttribute("massa");

        Node massaYesOption = new Node();
        massaYesOption.setName("Lasanha");
        massaYesOption.setAttribute("Lasanha");

        Node massaNoOption = new Node();
        massaNoOption.setName("Chocolate");
        massaNoOption.setAttribute("Chocolate");

        rootNode.setYesOption(massaYesOption);
        rootNode.setNoOption(massaNoOption);

        decisionTree.init(rootNode);
        return decisionTree;
    }

    private void chooseOption(Boolean option) {
        Node node = this.decisionTree.getCurrentNode();
        if (option) {
            if (node.getYesOption() != null) {
                this.decisionTree.setCurrentNode(node.getYesOption());
                showQuestion();
                return;
            }
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(frame,
                    "Eu sabia!", "Sou bom.",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            endGame();
        } else {
            if (node.getNoOption() != null) {
                this.decisionTree.setCurrentNode(node.getNoOption());
                showQuestion();
                return;
            }
            String name = JOptionPane.showInputDialog("Qual é o nome do alimento?");
            String attribute = JOptionPane.showInputDialog("O que é diferente neste alimento?");

            Node nodeInsert = new Node();
            nodeInsert.setName(name);
            nodeInsert.setAttribute(attribute);
            node.setNoOption(nodeInsert);
            decisionTree.reset();
            showQuestion();
        }
    }

    private void showQuestion() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "sua comida é " + this.decisionTree.getCurrentNode().getAttribute() + "?",
                "Foodnator 3000",
                JOptionPane.YES_NO_OPTION);
        chooseOption(dialogResult == 0);
    }

    private void endGame() {
        System.exit(1);
    }
}
