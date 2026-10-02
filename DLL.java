// AAAAAAAAA I'm soooo sorryyyyyyyy please


public class DLL<E> { // other classes allowed to use DLL class

    // Nested node class

    class Node<E> { // creating clss (for one node)
        private E element; // stores value
        private Node<E> prev; //points to node before this
        private Node<E> next; // points to next node

        public Node() { // creating empty node!!!!!
            this.element = null;
            this.prev = null;
            this.next = null;

        }

        public Node(E element) { // creating node holding an element!!!!!
            this.element = element;
            this.prev = null;
            this.next= null;

        }

        public Node(E element, Node<E> prev, Node<E> next) { // creating a node and guess what! identifying its neighbors
            this.element = element;
            this.prev = prev;
            this.next = next;

        }

        public E getElement() { return element; } // returns nodes element
        public void setElement(E element) { this.element = element; } // chaning the element

        public Node<E> getPrev() { return prev; } // changing node that comes before
        public void setPrev(Node<E> prev) { this.prev = prev;}

        public Node<E> getNext() { return next; } // changing the next node
        public void setNext(Node<E> next) { this.next = next; }

    }

    // DLL fields

    private Node<E> head; // pointing to first node
    private Node<E> tail; // pointing to last node
    private int counter; // counting nodes!!!!

    // constructor

    public DLL() {
        head = null;
        tail = null;
        counter = 0;

    }

    // basic methods

    public int size() { // if counter is x, returns x for size :)
        return counter;

    }

    public boolean isEmpty() { // if counter is zero, true
        return counter == 0;

    }

    public E first() { // hmmmm, i wonder what this does hmmmmm hmmmm hmmmmm hmmmmm hmmmmm
        if (head == null) {
            return null;

        }

        return head.getElement();

    }

    public E last() { // return whats last twin
        if (tail == null) {
            return null;

        }

        return tail.getElement();

    }

    // add methods

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element); // create new node

        if (isEmpty()) {
            head = tail = newNode; // if its empty, he is the head and tail
        } else {
            newNode.setNext(head); // new node points to the original head!
            head.setPrev(newNode); // original head pointing to the new one!
            head = newNode; // the new kid becomes the head

        }
        counter++; // hmmmm, i wonder

        }

        public void addLast(E element) {
            Node<E> newNode = new Node<>(element); // creating a node!

            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.setNext(newNode); // making tail point to new node
                newNode.setPrev(tail); // new node pointing to tail
                tail = newNode; // new kid becomes tail
            }
            counter++; // ?????????????? jk ik what this is T-T
            }

            //Remove first 

            public E removeFirst() {
                if (isEmpty()) return null; 

                E element = head.getElement(); // saving the element we're removing, see you later boss

                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.getNext(); // moveing head forward
                    head.setPrev(null); // since next node is head now, it must not point to anything behind it!!!!

                }

                counter--; // 141.12
                return element; // return the brodie that was removed

                }

                public E removeLast() {
                    if (isEmpty()) return null;

                    E element = tail.getElement(); // saving the tail's element

                    if (head == tail) { 
                        head = tail = null;
                    } else {
                        tail = tail.getPrev(); // move back 
                        tail.setNext(null); // if its a tail, it shouldnt point to anything infront!!!

                    }

                    counter--;
                    return element; // return homie
                    }

                    // to string

                    public String toString() {
                        if (isEmpty()) {
                            return "null";

                        }
                        StringBuilder sb = new StringBuilder(); // build build build
                        sb.append("null<--"); // start of text

                        Node<E> current = head; // each node will be typed out, we temporarily set each node starting from the head as the current one, it prints out, and then the current moves to the next node, until no more nodes

                        while (current != null) { // keep going through all nodes
                            sb.append(current.getElement()); // add current nodes value

                            if (current.getNext() != null) { // if node betweem add a double arrow
                                sb.append("<-->");

                            }

                            current = current.getNext(); // forcing the program to move to za next node

                        }

                        sb.append("-->null"); // the end

                        return sb.toString();
                    }

                    // clone

                    public DLL<E> clone() {
                        DLL<E> copy = new DLL<>(); // creating new DLL 

                        Node<E> current = head; // we use the original list head
                        while (current != null) { // force it through the whole list
                            copy.addLast(current.getElement()); // creates new node, puts the same element from other list
                            current = current.getNext(); // force it to go to next node in the original list

                        }

                        return copy;
                    }

                    // deepClone

                    public DLL<E> deepClone() {
                        DLL<E> copy = new DLL<>(); // create new DLL

                        Node<E> current = head; // use original head

                        while (current != null) { // keep going through it all!!
                            try { // try your best java
                                E clonedElement = (E) current.getElement().getClass().getMethod("clone").invoke(current.getElement());
                                // getting object, then the class, finding clone method and telling it to use it!
                                copy.addLast(clonedElement);
                            } catch (Exception e) { // catch an error java, please, catch the opps
                                throw new RuntimeException("Could not deep clone element twin", e);

                            }

                            current = current.getNext();

                            }

                            return copy;
                        }
                        


                        // insert (index)

                        public void insert(int index, E element) { 
                            if (index < 0 || index > counter) return; // nothing if the index you pick is less that 0, or bigger than the list

                            if (index == 0) { // add to head
                                addFirst(element);
                                return;

                            }

                            if (index == counter) { // add to tail
                                addLast(element);
                                return;

                            }

                            Node<E> current = head; // start at head, and move until current moves to the index
                            for (int i = 0; i < index; i++)
                                current = current.getNext();

                            Node<E> newNode = new Node<>(element, current.getPrev(), current);
                            current.getPrev().setNext(newNode);
                            current.setPrev(newNode);

                            counter++;

                        }


                        // get(index)

                        public E get(int index) {
                            if (index < 0 || index >= counter) return null; // return nothing if index you ask is less than 0 or bigger than list

                            Node<E> current = head; // start at start
                            for (int i = 0; i < index; i++) { // running through the 90's until you reach the specific node
                            current = current.getNext();
                            }

                            return current.getElement(); // gimme the value!

                        }

                        // remove(index)

                        public E remove(int index) {
                            if (index < 0 || index >= counter) return null; // if index is number not in the list, do nothing

                            if (index == 0) return removeFirst(); 
                            if (index == counter - 1) return removeLast();

                            Node<E> current = head; // finding node
                            for (int i = 0; i < index; i++)
                                current = current.getNext();

                            E element = current.getElement(); // save the nodes element please java, i beg

                            current.getPrev().setNext(current.getNext()); // making node before the removed one point to the node after the removed one
                            current.getNext().setPrev(current.getPrev()); // setting previous as the one before the removed one

                            counter--; // less
                            return element; 

                        }

                        // remove(node)
                        public void remove(Node<E> x) {
                            if (x == null || isEmpty()) return; // if bizarre number you guessed it
                            // removing node now that we have object, right? right?
                            if (x == head) {
                                removeFirst();
                                return;

                            }

                            if (x == tail) {
                                removeLast();
                                return;

                            }

                            x.getPrev().setNext(x.getNext()); // conecting the nodes around the removed one
                            x.getNext().setPrev(x.getPrev());

                            counter--;

                        }

                        // find (element)

                        public Node<E> find(E element) {
                            Node<E> current = head; // start at the head brodie

                            while (current != null) { // move along
                                if (current.getElement().equals(element)) // if node has the element you've been needing
                                    return current; // return the node 
                                current = current.getNext(); // move if no ;(

                            }
                            
                            return null; // bro couldn't find it if this happens

                        }

                        // clear ()

                        public void clear() {
                            head = null;
                            tail = null;
                            counter = 0;
                            // this compleletley im sorry for spelling that wrong,) obliterates the list of nodes
                        }

                        // set (index)

                        public E set(int index, E element) {
                            if (index < 0 || index >= counter) return null;

                            Node<E> current = head;
                            for (int i = 0; i < index; i++)
                                current = current.getNext();

                            E old = current.getElement(); // save old value
                            current.setElement(element); // and replace him....

                            return old;
                        }
                    }
                
            

        
    
