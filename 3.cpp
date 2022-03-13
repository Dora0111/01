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

���ߣ�morris-xu
���ӣ�https://leetcode-cn.com/problems/permutations/solution/46-quan-pai-lie-hui-su-suan-fa-de-dui-ch-vrce/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
