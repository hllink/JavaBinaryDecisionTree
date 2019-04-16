package foodnator.com.foodnator.com.decision.tree;

public class BinaryDecisionTree {


    private Node rootNode;
    private Node currentNode;

    public BinaryDecisionTree() {
    }

    public void init(Node rootNode){
        this.rootNode = rootNode;
        this.currentNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public void reset(){
        this.currentNode = this.rootNode;
    }
}
