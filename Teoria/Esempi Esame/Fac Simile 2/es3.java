public class es3 {
    public static float metodo(int[] a) {
        assert check(a) : "NOPE";
        float ris = 0;
        for (int i = 0; i < a.length; i++)
            ris += 1 / (float) a[i];
        return ris / a.length;
    }

    public static boolean check (int[] a){
        if(a == null || a.length == 0)
            return false;
        for (int i : a) {
            if(i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = new int[0];
        int[] b = new int[3];
        for(int i=0; i<b.length; ++i){
            b[i] = i+2;
        }

        //System.out.println(metodo(a));
        System.out.println(metodo(b));
        System.out.println(metodo(null));
    }
}
