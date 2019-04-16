package foodnator.com.foodnator.com.decision.tree;

public class Node {
    String name;
    String attribute;
    Node yesOption;
    Node noOption;

    public Node() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getYesOption() {
        return yesOption;
    }

    public void setYesOption(Node yesOption) {
        this.yesOption = yesOption;
    }

    public Node getNoOption() {
        return noOption;
    }

    public void setNoOption(Node noOption) {
        this.noOption = noOption;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
