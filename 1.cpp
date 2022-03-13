class Solution {
public:
string addStrings(string num1, string num2) {
        string ret;
        int bit;
        int carry = 0;
        auto p1 = num1.begin();
        auto p2 = num2.begin();
        while(p1 != num1.end() && p2 != num2.end()) {
            bit = (*p1 - '0') + (*p2 - '0') + carry;
            if(bit >= 10) {
                bit %= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            p1++;
            p2++;
            ret.push_back(bit + '0');
        }
        
        while(p1 != num1.end()) {
            bit = (*p1 - '0') + carry;
            if(bit >= 10) {
                bit %= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            p1++;
            ret.push_back(bit + '0');
        }
        while(p2 != num2.end()) {
            bit = (*p2 - '0') + carry;
            if(bit >= 10) {
                bit %= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            p2++;
            ret.push_back(bit + '0');
        }
        if(p1 == num1.end() && p2 ==num2.end()) {
            if(carry == 1) {
                ret.push_back('1');
            }
        }
        return ret;
    }
    string multiply(string num1, string num2) {
        string up = (num1.length() > num2.length() ? num1 : num2);
        string down = (num1.length() <= num2.length() ? num1: num2);
        vector<string> ret(down.end() - down.begin());
        auto downend = down.end() - 1;
        int bitCount = 0; 
        int bit = 0;
        int carry = 0;
        while(downend >= down.begin()) {
            carry = 0;
            auto upend = up.end() - 1;
            while(upend >= up.begin()) {
                bit = (*upend - '0') * (*downend - '0') + carry;
                if(bit >= 10) {
                    carry = bit/10;
                } 
                else {
                    carry = 0;
                }
                ret[bitCount].push_back(bit%10 + '0');
                upend--;
            }
            if(carry != 0) {
                ret[bitCount].push_back(carry + '0');
            }
            int tmpbitCount = bitCount;
            reverse(ret[bitCount].begin(), ret[bitCount].end());
            while(tmpbitCount--) { //ºóÃæ²¹0
                ret[bitCount].push_back('0');
            }
            reverse(ret[bitCount].begin(), ret[bitCount].end());
            bitCount++;
            downend--;
        }
        for(int i = 1; i < down.end() - down.begin(); i++) {
            ret[0] = addStrings(ret[0], ret[i]);
        }
        reverse(ret[0].begin(), ret[0].end());
        if(ret[0][0] == '0') {
            ret[0] = "0";
        }
        return ret[0];
    }
};
