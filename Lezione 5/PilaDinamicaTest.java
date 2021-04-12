public class PilaDinamicaTest{
    public static void main(String[] args){
        PilaDinamica p = new PilaDinamica();
        p.push(13);
        p.push(20);
        p.push(3);
        p.push(56);

        int[] a = p.toArray();
        System.out.println("length: " + a.length);
        for(int i=0; i<a.length; ++i)
            System.out.print(a[i] + " | ");
        System.out.println();
        
    }//main
}//class