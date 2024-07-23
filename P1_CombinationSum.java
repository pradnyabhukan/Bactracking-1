// TC : O(2^(m+n))
// SC : 
class Solution {
    List<List<Integer>> result;
    private void helper(int[] candidates, int idx, List<Integer> path, int target) {
        //base
        if(idx == candidates.length || target < 0)
            return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, path, target - candidates[idx]);

        path.remove(path.size() - 1);
        //not choose
        helper(candidates, idx+1, path, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
}