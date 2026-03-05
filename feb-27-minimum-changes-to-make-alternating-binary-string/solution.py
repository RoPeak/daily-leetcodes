class Solution:
    def minOperations(self, s: str) -> int:
        mismatch_start_zero = 0

        for i, ch in enumerate(s):
            expected = "0" if i % 2 == 0 else "1"
            if ch != expected:
                mismatch_start_zero += 1

        return min(mismatch_start_zero, len(s) - mismatch_start_zero)
