class Solution {
    public int[] productExceptSelf(int[] nums) {
        // for this task we need few arrays 
        // first of all we need array which can store the pow of all left elements
        // then we need array which will store all elements from the right
        // then l-1 * r+1, if l < 0 then l-1 = 1, if r > length -1 then r+1 = 1;

        int length = nums.length;
        int l[] = new int[length];
        int r[] = new int[length];
        boolean first = true;
    
        for (int il = 0, ir = length - 1; il < length - 1; il++, ir--) {
            if (!first) {
                l[il] = l[il-1] * nums[il];
                r[ir] = r[ir+1] * nums[ir];
                continue;
            } 
            first = false;
            l[il] = nums[il];
            r[ir] = nums[ir];
        }

        int res[] = new int[length];
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                if (i < length - 1) {
                    res[i] = l[i-1] * r[i+1];
                } else {
                    res[length - 1] = l[i-1];
                }
            } else {
                res[0] = r[i+1];
            }
        }

        return res;
    }
}  
