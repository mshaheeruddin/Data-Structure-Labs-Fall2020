package L3LinkedList;

public class Driver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SinglyLinkList sList = new SinglyLinkList();
        //For Task 2
        SinglyLinkList p = new SinglyLinkList();
        SinglyLinkList q = new SinglyLinkList();

        //Add nodes to the list    
        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(9);
        sList.addNode(4);
       /*
       //To check

        sList.addAtStart(0);
        sList.addAtEnd(5);
        sList.searchNode(3);
        sList.deleteFromStart();
        sList.deleteFromEnd();

        */
        //List p
        p.addNode(10);
        p.addNode(11);
        p.addNode(12);
        p.addNode(13);
     
        //List q
        q.addNode(14);
        q.addNode(15);
        q.addNode(16);
        q.addNode(17);


        SinglyLinkList List;
        List = p.joinLists(p,q);


        List.display();
        //Displays the nodes present in the list    
        //sList.display();

    }
}