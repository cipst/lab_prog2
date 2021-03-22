public class Esercizio1 {
    public static void main(String[] args) {
        String[] arr = { "ciao", "cane", "pippo", "stefano", "supercalifragile", "alessio", "sium" };
        System.out.println("Longest > " + longest(arr));
        System.out.println("ConcatAll > " + concatAll(arr));
        System.out.println("Trim > #" + trim("  Elimina gli spazi iniziali e finali   ") + "#");
    }

    private static String longest(String[] a) {
        assert a != null : "Array inesistente!";
        assert a.length > 0 : "Riempire l'array!";
        int max = 0;
        for (int i = 1; i < a.length; ++i) {
            if (a[i].length() > a[max].length())
                max = i;
        }
        return a[max];
    }

    private static String concatAll(String[] a) {
        assert a != null : "Array inesistente!";
        assert a.length > 0 : "Riempire l'array!";
        String txt = "";
        for (int i = 0; i < a.length; ++i) {
            txt = txt.concat(a[i]);
        }
        return txt;
    }

    private static String trim(String txt) {
        int i_start = 0, i_end = 0;
        for (int i = 0; i < txt.length() && txt.charAt(i) == ' '; ++i)
            i_start = i + 1;

        for (int i = txt.length() - 1; i >= 0 && txt.charAt(i) == ' '; --i)
            i_end = i - 1;

        return txt.substring(i_start, i_end + 1);
    }
}
