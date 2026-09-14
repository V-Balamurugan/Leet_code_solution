class Solution {
    static int max(int a, int b){
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    static int min(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (max(rec1[0],rec2[0])<min(rec1[2],rec2[2])&&
            min(rec1[3],rec2[3])>max(rec1[1],rec2[1]));
    }
}
