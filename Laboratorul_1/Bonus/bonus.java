import java.util.Arrays;

public class bonus
{
    public static void main(String[] args)
    {
        if(args.length < 2)
        {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        int nodes = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[][] matrix = new int[nodes + 1][nodes + 1];

        for(int i = 1; i < k; i++)
        {
            for(int j = i+1; j <= k; j++)
            {
                matrix[i][j] = matrix[j][i] = 0;
            }
        }

        for(int i = k + 1; i < 2*k; i++)
        {
            for(int j = i + 1; j <= 2*k; j++)
            {
                matrix[i][j] = matrix[j][i] = 1;
            }
        }

        for(int i = 2 * k + 1; i < nodes; i++)
        {
            for(int j = 1; j <= nodes; j++)
            {
                double temp = Math.random();
                if(temp < 0.5)
                    matrix[i][j] = matrix[j][i] = 0;
                else
                    matrix[i][j] = matrix[j][i] = 1;
            }
        }

        bonus method_calling = new bonus();
        int[] nodesInSubgraph = new int[nodes + 1];
        int[] nodesAddedInSubraph = new int[k];
        method_calling.printMatrix(matrix);
        method_calling.createSubgraph(matrix, nodes, k, 0, nodesInSubgraph, nodesAddedInSubraph);

    }

    public void printMatrix(int[][] matrix)
    {
        for(int i = 1 ; i <= nodes; i++)
        {
            for(int j = 1; j <= nodes; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void createSubgraph(int[][] matrix, int nodes, int k, int nodesAdded, int[] nodesInSubgraph, int[] nodesAddedInSubraph)
    {
        if(nodesAdded == k)
        {
            verifyClique(matrix, k, nodesAddedInSubraph);
            verifyStableSet(matrix, k, nodesAddedInSubraph);
        }
        else
        {
            for(int i = (nodesAdded == 0 ? 1 : nodesAddedInSubraph[nodesAdded - 1] + 1); i <= nodes; i++)
            {
                if(nodesInSubgraph[i] == 0)
                {
                    nodesAddedInSubraph[nodesAdded] = i;
                    nodesInSubgraph[i] = 1;
                    createSubgraph(matrix, nodes, k, nodesAdded + 1, nodesInSubgraph, nodesAddedInSubraph);
                    nodesAddedInSubraph[nodesAdded] = 0;
                    nodesInSubgraph[i] = 0;
                }
            }
        }
    }

    public void verifyClique(int[][] matrix, int k, int[] nodesAddedInSubgraph)
    {
        boolean isClique = true;
        for(int i = 0; i < k - 1; i++)
        {
            for(int j = i + 1; j < k; j++)
            {
                if(matrix[nodesAddedInSubgraph[i]][nodesAddedInSubgraph[j]] == 0)
                {
                    isClique = false;
                    break;
                }
            }
            if(!isClique)
                break;
        }
        if(isClique)
        {
            System.out.println("Clique: " + Arrays.toString(nodesAddedInSubgraph));
        }
    }

    public void verifyStableSet(int[][] matrix, int k, int[] nodesAddedInSubgraph)
    {
        boolean isStableSet = true;
        for(int i = 0; i < k - 1; i++)
        {
            for(int j = i + 1; j < k; j++)
            {
                if(matrix[nodesAddedInSubgraph[i]][nodesAddedInSubgraph[j]] == 1)
                {
                    isStableSet = false;
                    break;
                }
            }
            if(!isStableSet)
                break;
        }
        if(isStableSet)
        {
            System.out.println("Stable set: " + Arrays.toString(nodesAddedInSubgraph));
        }
    }
}