package org.example.pattern;

public class Linklist {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.next= null;
            this.data = data;
        }
    }

    public Node head= null;
    public Node tail= null;


    public void addNode(int data)
    {
        Node newNode = new Node(data);
        if(head==null){
            head= newNode;
            tail = newNode;
        }
        else {
            tail.next= newNode;
            tail = newNode;

        }

    }
    public void  reverseNode(){
        Node currentNode= head;
        Node preNode= null;
        Node nestNode = null;
        if(currentNode==null)
        {
            System.out.println("list is empty");
            return;
        }
        while (currentNode!=null){
            nestNode= currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nestNode;

        }
        head= preNode;
    }

    public void displayNode(){
        Node currentNode= head;
        if(currentNode==null)
        {
            System.out.println("list is empty");
            return;
        }
        while (currentNode!=null){
            System.out.print(currentNode.data);
            currentNode= currentNode.next;
        }
    }


    public static void main(String agrs[]) {

        Linklist sList = new Linklist();

        //Add nodes to the list
        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(4);

        //Displays the nodes present in the list
        sList.displayNode();
        sList.reverseNode();
        sList.displayNode();


    }
}
