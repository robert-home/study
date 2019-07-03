package pl.rbudner.study.codility;

public class BridgeMethod {

    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data;
    }

}

class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }

}

class MyNode extends Node<Integer> {

    public MyNode(Integer data) { super(data); }

    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

    /*public void setData(Object data) {
        System.out.println("bridge method");
        setData((Integer) data);
    }*/

}
