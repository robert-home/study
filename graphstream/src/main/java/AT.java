import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class AT {

    public static void main(String args[]) {
        Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C").setAttribute("ui.label", "Node C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        graph.display();

    }

}
