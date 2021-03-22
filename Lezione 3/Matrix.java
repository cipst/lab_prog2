public class Matrix {
    private int m; // righe
    private int n; // colonne
    private int[][] matrix; // matrice

    public Matrix(int m, int n) {
        assert m >= 0 : "Valori invalidi per le righe della matrice";
        assert n >= 0 : "Valori invalidi per le colonne della matrice";
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
    }

    public int get(int m, int n) {
        assert m >= 0 : "Valori invalidi per le righe della matrice";
        assert n >= 0 : "Valori invalidi per le colonne della matrice";
        return matrix[m][n];
    }

    public void set(int val, int m, int n) {
        assert m >= 0 : "Valori invalidi per le righe della matrice";
        assert n >= 0 : "Valori invalidi per le colonne della matrice";
        this.matrix[m][n] = val;
    }

    public int rows() {
        return m;
    }

    public int columns() {
        return n;
    }

    public Matrix add(Matrix m) {
        assert m.rows() == this.m : "Le righe delle due matrici sono diverse";
        assert m.columns() == this.n : "Le colonne delle due matrici sono diverse";

        Matrix newM = new Matrix(this.m, this.n);
        for (int i = 0; i < this.m; ++i) {
            for (int j = 0; j < this.n; ++j) {
                newM.set(this.matrix[i][j] + m.get(i, j), i, j);
            }
        }
        return newM;
    }

    public Matrix mul(Matrix m) {
        assert (this.n == m.rows()) : "Non e' possibile effettuare la moltiplicazione tra matrici incompatibili";

        Matrix newM = new Matrix(this.m, m.columns());
        int i, j, c;
        int ris = 0;
        int sum = 0;
        for (i = 0; i < newM.rows(); ++i) {
            for (j = 0; j < newM.columns(); ++j) {
                sum = 0;
                for (c = 0; c < this.columns(); ++c) {
                    ris = this.get(i, c) * m.get(c, j);
                    sum += ris;
                }
                newM.set(sum, i, j);
            }
        }
        return newM;
    }

    public Matrix pow(int n) {
        if(n == 0){
            Matrix m = new Matrix(this.m, this.n);
            for(int i=0; i<this.m; ++i)
                for(int j=0; j<this.n; ++j)
                    m.set((i==j)?1:0, i, j);
            return m;
        }else if (n > 1) {
            return this.mul(this.pow(n - 1));
        } else {
            return this;
        }
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 2);
        for (int i = 0; i < m.rows(); ++i) {
            for (int j = 0; j < m.columns(); ++j) {
                m.set(i * j, i, j);
                System.out.print(m.get(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("############");
        for (int i = 0; i < m2.rows(); ++i) {
            for (int j = 0; j < m2.columns(); ++j) {
                m2.set(i + j, i, j);
                System.out.print(m2.get(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("############");
        Matrix mul = m.mul(m2);
        for (int i = 0; i < m2.rows(); ++i) {
            for (int j = 0; j < m2.columns(); ++j) {
                System.out.print(mul.get(i, j) + " ");
            }
            System.out.println();
        }


        System.out.println("############");
        Matrix m3 = new Matrix(5, 5);
        m3.set(1, 0, 0);
        m3.set(2, 0, 1);
        m3.set(-1, 1, 0);
        m3.set(3, 1, 1);
        for (int i = 0; i < m3.rows(); ++i) {
            for (int j = 0; j < m3.columns(); ++j) {
                System.out.print(m3.get(i, j) + " ");
            }
            System.out.println();
        }
        
        System.out.println("############");
        Matrix pow = m3.pow(0);
        for (int i = 0; i < m3.rows(); ++i) {
            for (int j = 0; j < m3.columns(); ++j) {
                System.out.print(pow.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
