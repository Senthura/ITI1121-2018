public class Solve {

    private static final Color B = Color.BLUE;
    private static final Color G = Color.GREEN;
    private static final Color R = Color.RED;
    private static final Color W = Color.WHITE;

    public static Queue<Solution> breadthFirstSearchNoDup() {
        return breadthFirstSearch(true);
    }

    public static Queue<Solution> breadthFirstSearch() {
        return breadthFirstSearch(false);
    }

    private static Queue<Solution> breadthFirstSearch(boolean noDups) {

        Solution.resetNumberOfCalls();

        Queue<Solution> solutions;
        solutions = new LinkedQueue<Solution>();

        Cube[] cubes;
        cubes = new Cube[4];

        cubes[0] = new Cube(new Color[]{B,G,W,G,B,R});
        cubes[1] = new Cube(new Color[]{W,G,B,W,R,R});
        cubes[2] = new Cube(new Color[]{G,W,R,B,R,R});
        cubes[3] = new Cube(new Color[]{B,R,G,G,W,W});

        Queue<Solution> open;
        open = new LinkedQueue<Solution>();

        Cube current = cubes[0];

        current.setFirst(noDups);

        current.reset();
        while(current.hasNext()){
            current.next();
            Solution s = new Solution(null, current);
            open.enqueue(s);
        }
        while (! open.isEmpty()) {
            Solution s = open.dequeue();
            current = cubes[s.size()];
            current.reset();
            while(current.hasNext()){
                current.next();
                if (s.isValid(current)) {
                    Solution next = new Solution(s,current);
                    if (next.size() == cubes.length) {
                        System.out.println(next);
                        solutions.enqueue(next);
                    } else {
                        open.enqueue(next);
                    }
                }

            }
        }

        System.out.println(Solution.getNumberOfCalls() + " calls to isValid");

        return solutions;
    }

    public static Queue<Solution> generateAndTest() {

        Solution.resetNumberOfCalls();

        Queue<Solution> solutions;
        solutions = new LinkedQueue<Solution>();

        Cube[] cubesSolution;
        cubesSolution = new Cube[4];

        cubesSolution[0] = new Cube(new Color[]{B,G,W,G,B,R});
        cubesSolution[1] = new Cube(new Color[]{W,G,B,W,R,R});
        cubesSolution[2] = new Cube(new Color[]{G,W,R,B,R,R});
        cubesSolution[3] = new Cube(new Color[]{B,R,G,G,W,W});

        cubesSolution[0].reset();
        while(cubesSolution[0].hasNext()){
            cubesSolution[0].next();
            cubesSolution[1].reset();
            while(cubesSolution[1].hasNext()){
                cubesSolution[1].next();
                cubesSolution[2].reset();
                while(cubesSolution[2].hasNext()){
                    cubesSolution[2].next();
                    cubesSolution[3].reset();
                    while(cubesSolution[3].hasNext()){
                        cubesSolution[3].next();
                        Solution s = new Solution(cubesSolution);
                        if (s.isValid()) {
                            System.out.println(s);
                            solutions.enqueue(s);
                        }
                    }
                }
            }
        }

        System.out.println(Solution.getNumberOfCalls() + " calls to isValid");

        return solutions;
    }

    public static void main(String[] args) {

        long start, stop;

        System.out.println("generateAndTest:");
        start = System.currentTimeMillis(); // could also use nanoTime

        Queue<Solution> solutions = generateAndTest();

        stop = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (stop-start) + " milliseconds");
//        System.out.println(solutions);

        System.out.println("breadthFirstSearch:");
        start = System.currentTimeMillis();

        solutions = breadthFirstSearch();

        stop = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (stop-start) + " milliseconds");
        System.out.println(solutions);

        System.out.println("breadthFirstSearch, no dup:");
        start = System.currentTimeMillis();

        solutions = breadthFirstSearchNoDup();

        stop = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (stop-start) + " milliseconds");
//        System.out.println(solutions);

    }
}
