public class TestDynamicQueue{
    public static void main(String[] args) {
        /* 
            INTEGER QUEUE
        */
        DynamicQueue<Integer> q = new DynamicQueue<Integer>();
        System.out.println( "~INTEGER QUEUE~\n  q = {17,42,4} " );
        q.enqueue(17);
        q.enqueue(42);
        q.enqueue(4); 
        q.scriviOutput();

        System.out.println( "  q.empty() = " + q.empty());
        System.out.println( "  q.contains(4)  = " + q.contains(4)); 
        System.out.println( "  q.contains(40) = " + q.contains(40));
        System.out.println("  q.size() = " + q.size());  
        System.out.println("  q.front()= " + q.front()); 
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue()); 

        System.out.println( "  q.empty() = " + q.empty());
        System.out.println();

        /*
            DOUBLE QUEUE
        */
        DynamicQueue<Double> w = new DynamicQueue<Double>();
        System.out.println( "~DOUBLE QUEUE~\n  w = {17.2, 42.5, 4.89} " );
        w.enqueue(17.2);
        w.enqueue(42.5);
        w.enqueue(4.89); 
        w.scriviOutput();

        System.out.println( "  w.empty() = " + w.empty());
        System.out.println( "  w.contains(4.90)  = " + w.contains(4.89)); 
        System.out.println( "  w.contains(40.0) = " + w.contains(40.0));
        System.out.println("  w.size() = " + w.size());  
        System.out.println("  w.front()= " + w.front()); 
        System.out.println(w.dequeue());
        System.out.println(w.dequeue());
        System.out.println(w.dequeue());

        System.out.println( "  w.empty() = " + w.empty());
        System.out.println();
        
        /*
            STRING QUEUE
        */
        DynamicQueue<String> s = new DynamicQueue<String>();
        System.out.println( "~STRING QUEUE~\n  s = {'Stringa 1', 'Stringa 2', 'Stringa 3'} " );
        s.enqueue("Stringa 1");
        s.enqueue("Stringa 2");
        s.enqueue("Stringa 3"); 
        s.scriviOutput();

        System.out.println( "  s.empty() = " + s.empty());
        System.out.println( "  s.contains('Stringa 1')  = " + s.contains("Stringa 1")); 
        System.out.println( "  s.contains('Stringa 5') = " + s.contains("Stringa 5"));
        System.out.println("  s.size() = " + s.size());  
        System.out.println("  s.front()= " + s.front());  
        System.out.println(s.dequeue()); 
        System.out.println(s.dequeue()); 
        System.out.println(s.dequeue()); 

        System.out.println( "  s.empty() = " + s.empty());
        System.out.println();

        /*
            PERSON QUEUE
        */
        DynamicQueue<Person> p = new DynamicQueue<Person>();
        p.enqueue(new Person("Paolo", "Rossi"));
        p.enqueue(new Person("Francesco", "Verdi"));
        System.out.println( "~PERSON QUEUE~\n  p = {<Paolo,Rossi> <Francesco,Verdi> <Marta,Bianchi>} " );
        p.enqueue(new Person("Marta", "Bianchi")); 
        p.scriviOutput();

        System.out.println( "  p.empty() = " + p.empty());
        System.out.println( "  p.contains(<Paolo,Rossi>)  = " + p.contains(new Person("Paolo", "Rossi"))); 
        System.out.println( "  p.contains(<Luca,Rosa>) = " + p.contains(new Person("Luca", "Rosa")));
        System.out.println("  p.size() = " + p.size());  
        System.out.println("  p.front()= " + p.front());  
        System.out.println(p.dequeue()); 
        System.out.println(p.dequeue()); 
        System.out.println(p.dequeue()); 

        System.out.println( "  p.empty() = " + p.empty());
    }
}

