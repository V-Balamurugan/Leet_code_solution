class Solution {
    static int max(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }
    static int min(int a, int b){
        if(a<b)
            return a;
        else
            return b;
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestx = max(x1,min(xCenter,x2));
        int closesty = max(y1,min(yCenter,y2));
        int distance = ((xCenter - closestx)*(xCenter - closestx))+((yCenter-closesty)*(yCenter-closesty));
        if(distance <= (radius*radius))
            return true;
        else
            return false;
    }
}
