class Solution {
private:
    int n;
    vector<int> p;
    unordered_map<int, bool> st;
    vector<vector<int>> res;

public:
    void dfs(int u, vector<int>& nums)
    {
        if (u == n) res.push_back(p);

        for (int& num : nums)
        {
            if (!st[num])
            {
                p.push_back(num);
                st[num] = true;

                dfs(u + 1, nums);

                st[num] = false;
                p.pop_back();
            }
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        n = nums.size();
        dfs(0, nums);
        return res;
    }
};

作者：morris-xu
链接：https://leetcode-cn.com/problems/permutations/solution/46-quan-pai-lie-hui-su-suan-fa-de-dui-ch-vrce/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
