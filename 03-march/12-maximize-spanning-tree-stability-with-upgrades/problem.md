# 3600. Maximize Spanning Tree Stability with Upgrades (Hard)
LeetCode: https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/

## Summary
Given an undirected graph with mandatory and optional edges, choose a valid spanning tree that includes all mandatory edges and may upgrade at most `k` optional edges (doubling their strength). Maximize the minimum strength among chosen tree edges.

## Constraints
- 2 <= n <= 10^5
- 1 <= edges.length <= 10^5
- `edges[i] = [ui, vi, si, musti]`
- 0 <= ui, vi < n, ui != vi
- 1 <= si <= 10^5
- `musti` is 0 or 1
- 0 <= k <= n

## Examples
- Input: n=3, edges=[[0,1,2,1],[1,2,3,0]], k=1 -> Output: 2
- Input: n=3, edges=[[0,1,4,0],[1,2,3,0],[0,2,1,0]], k=2 -> Output: 6
- Input: n=3, edges=[[0,1,1,1],[1,2,1,1],[2,0,1,1]], k=0 -> Output: -1

## Notes
- Binary search the answer `x` (target minimum strength).
- Feasibility for `x`: all mandatory edges must have `s >= x` and remain acyclic; then connect remaining components using optional edges with cost:
- `0` if `s >= x`, `1` if `s < x <= 2s`, unusable otherwise.
- Greedily union all cost-0 edges first, then cost-1 edges; this minimizes upgrades needed.
- Time complexity: O((n + m) log S), where `S` is max effective strength (`max(s, 2s)`).
