public class homework {
    public static void main(String[] args)
    {
        if(args.length < 2)
        {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        long time_start_execution = System.currentTimeMillis();
        int nodes = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[][] matrix = new int[nodes + 1][nodes + 1];

        for(int i = 1; i < k; i++)
        {
            for(int j = i+1; j <= k; j++)
            {
                matrix[i][j] = matrix[j][i] = 1;
            }
        }

        for(int i = k + 1; i < 2*k; i++)
        {
            for(int j = i + 1; j <= 2*k; j++)
            {
                matrix[i][j] = matrix[j][i] = 0;
            }
        }

        for(int i = 2 * k + 1; i < nodes; i++)
        {
            for(int j = i + 1; j <= nodes; j++)
            {
                double temp = Math.random();
                if(temp < 0.5)
                    matrix[i][j] = matrix[j][i] = 0;
                else
                    matrix[i][j] = matrix[j][i] = 1;
            }
        }
        homework obj = new homework();
        if(nodes <= 30000)
            obj.printMatrix(matrix, nodes);
        System.out.println(obj.numberOfEdges(matrix, nodes));
        obj.displayMaximumDegree(matrix, nodes);
        obj.displayMinimumDegree(matrix, nodes);
        obj.verifyDegrees(matrix, nodes);

        if(nodes > 30000)
        {
            long time_finish_execution = System.currentTimeMillis();
            System.out.println("Time of execution: " + (time_finish_execution - time_start_execution)/1000 + " seconds");
        }

    }

    void printMatrix(int[][] matrix, int nodes)
    {
        for(int i = 1; i <= nodes; i++)
        {
            for(int j = 1; j <= nodes; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    int numberOfEdges(int[][] matrix, int nodes)
    {
        int count = 0;
        for(int i = 1; i <= nodes; i++)
        {
            for(int j = i + 1; j <= nodes; j++)
            {
                if(matrix[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    void displayMaximumDegree(int[][] matrix, int nodes)
    {
        int maxi = -1;
        for(int i = 1; i <= nodes; i++)
        {
            int count = 0;
            for(int j = 1; j <= nodes; j++)
            {
                if(matrix[i][j] == 1)
                    count++;
            }
            if(count > maxi)
                maxi = count;
        }
        System.out.println(maxi);
    }

    void displayMinimumDegree(int[][]matrix, int nodes)
    {
        int mini = nodes;
        for(int i = 1; i <= nodes; i++)
        {
            int count = 0;
            for(int j = 1; j <= nodes; j++)
            {
                if(matrix[i][j] == 1)
                    count++;
            }
            if(count < mini)
                mini = count;
        }
        System.out.println(mini);
    }

    void verifyDegrees(int[][] matrix, int nodes)
    {
        int count = 0;
        for(int i = 1; i <= nodes; i++) {
            for (int j = i+1; j <= nodes; j++)
                if (matrix[i][j] == 1)
                    count += 2;
        }
        homework obj = new homework();
        if(count == 2 * obj.numberOfEdges(matrix, nodes))
            System.out.println("Total number of degrees: " + count);
        else
            System.out.println("Total number of degrees is not 2 * number of edges");
    }



}
