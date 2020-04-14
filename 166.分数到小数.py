#
# @lc app=leetcode.cn id=166 lang=python3
#
# [166] 分数到小数
#

# @lc code=start


class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        # 整数部分
        flag = True
        if numerator * denominator < 0:
            flag = False
        numerator = abs(numerator)
        denominator = abs(denominator)
        zheng, numerator = divmod(numerator, denominator)
        if numerator == 0:
            return str(zheng) if flag else '-{}'.format(zheng)
        rest = {}
        # 分数部分
        fen = ''
        while numerator != 0 or numerator not in rest:
            shang, numerator = divmod(numerator * 10, denominator)
            if numerator == 0:
                fen += str(shang)
                break
            if (shang, numerator) in rest:
                fen = fen[:rest[(shang, numerator)]] + \
                    '('+fen[rest[(shang, numerator)]:]+')'
                break
            else:
                rest[(shang, numerator)] = len(fen)
                fen += str(shang)
        return '{}.{}'.format(zheng, fen) if flag else '-{}.{}'.format(zheng, fen)


# @lc code=end
