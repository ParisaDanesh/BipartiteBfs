/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bipartitebfs;

/**
 *
 * @author F4BREGAS
 */
import java.util.ArrayList;
    import java.util.InputMismatchException;

    import java.util.LinkedList;

    import java.util.Queue;

    import java.util.Scanner;

     

    public class BipartiteBfs

    {

        private int numberOfVertices;

        private Queue<Integer> queue;

     

        public static final int NO_COLOR = 0;

        public static final int RED = 1;

        public static final int BLUE = 2;

        private static ArrayList<String> answr=new ArrayList<>();

        public BipartiteBfs(int numberOfVertices)

        {

            this.numberOfVertices = numberOfVertices;

            queue = new LinkedList<Integer>();

        }

     

        public boolean isBipartite(int Matrix[][], int source)

        {
            
            boolean flag=true;
            int[] colored = new int[numberOfVertices +  1];

            for (int vertex = 1; vertex <= numberOfVertices; vertex++)

            {

                //hame color ha 0 mishe
                colored[vertex] = NO_COLOR;

            
            }

            colored[source] = RED;

            queue.add(source);

     

            int element, neighbour;

            while (!queue.isEmpty())

            {

                element = queue.remove();

                neighbour = 1;

                while (neighbour <= numberOfVertices)

                { 

                    if (Matrix[element][neighbour] == 1 && colored[element]== colored[neighbour])

                    {

                        answr.add("("+element+","+neighbour+")");
                        flag=false;

                    }

                    if (Matrix[element][neighbour] == 1 && colored[neighbour]== NO_COLOR)

                    {

                        colored[neighbour] = (colored[element] == RED ) ? BLUE :RED;

                        queue.add(neighbour);

                    }

                    neighbour++;

                }

            }

           if(flag==false)
               return false;
           else
               return true;

        }

     

        public static void main(String... arg)

        {

            int number_of_nodes, source;

            Scanner scanner = null;

            try 

            {

               System.out.println("Enter the number of nodes in the graph");

               scanner = new Scanner(System.in);

               number_of_nodes = scanner.nextInt();

     

               int input_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];

               System.out.println("Enter the adjacency matrix");

               for (int i = 1; i <= number_of_nodes; i++)

               {

                   for (int j = 1; j <= number_of_nodes; j++)

                   {	

                       input_matrix[i][j] = scanner.nextInt();

                   }

               }

     

               for (int i = 1; i <= number_of_nodes; i++)

               {

                   for (int j = 1; j <= number_of_nodes; j++)

                   {	

                       if(input_matrix[i][j] == 1 && input_matrix[j][i] == 0)

                       {

                           input_matrix[j][i] = 1;

                       }

                   }

               }

     

               
               source = 1;//az rase 1 shuru mikonim

     

               BipartiteBfs bipartiteBfs = new BipartiteBfs(number_of_nodes);

               if (bipartiteBfs.isBipartite(input_matrix, source)) 

               {

                   System.out.println("Yes");

               } else

               {

                   System.out.println("No");
                   for(int i = 0;i<answr.size();i+=2)
                       System.out.println(answr.get(i));

               }

           } catch (InputMismatchException inputMismatch) 

           {

               System.out.println("فرمت وارد کردن اشتباه است");

           }

           scanner.close();

        }

    }