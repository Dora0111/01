class StreamRank {
  List<Integer> list;

  public StreamRank() {
    list = new ArrayList<>();
  }

  public void track(int x) {
    // 找到第一个大于x的位置，插入x
    list.add(search(x), x);
  }

  public int getRankOfNumber(int x) {
    return search(x);
  }

  private int search(int x) {
    int l = 0, r = list.size() - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (list.get(mid) > x) r = mid - 1;
      else l = mid + 1;
    }
    return l;
  }
}
