public class SystemOfLinearEquations {
    public static double[] solveNotZeros(double[][] matrix_, double[] result) {
        double[][] matrix = solveNotZeroMatrix(matrix_.clone(), result);
        int n = matrix.length;
        double[] vector = new double[n];
        for (int i = n - 1; i > -1; i--) {
            double coff = matrix[i][i];
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * vector[j];
            }
            vector[i] = (result[i] - sum) / coff;
        }
        return vector;
    }

    private static double[][] solveNotZeroMatrix(double[][] matrix, double[] result) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];
            for (int j = i + 1; j < n; j++) {
                double coff = matrix[j][i] / pivot;
                for (int l = i; l < n; l++) {
                    matrix[j][l] -= coff * matrix[i][l];
                }
                result[j] -= coff * result[i];
            }
        }
        return matrix;
    }
}
