public class FloodFill {
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }
        image[sr][sc] = color;
        //Left
        helper(image, sr, sc - 1, color, vis, orgColor);
        //Right
        helper(image, sr, sc + 1, color, vis, orgColor);
        //Up
        helper(image, sr - 1, sc, color, vis, orgColor);
        //Down
        helper(image, sr + 1, sc, color, vis, orgColor);

    }

    public static void floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, image[sr][sc]);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        floodFill(image,1,1,2);
        for (int i=0;i<image.length;i++){
            for (int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
