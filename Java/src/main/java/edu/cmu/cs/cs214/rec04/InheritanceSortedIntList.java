package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
  private int totalAdded = 0;

  @Override
    public boolean add(int num) {
    totalAdded++;
    return super.add(num);
  }

  @Override
    public boolean addAll(IntegerList list) {
    boolean isChanged = false;
    for (int i = 0; i < list.size(); i++) {
      boolean added = super.add(list.get(i)); 
      if (added) {
        totalAdded++; 
        isChanged = true;
      }
    }
    return isChanged;
  }

  @Override
    public boolean remove(int num) {
    return super.remove(num);
  }

  @Override
    public boolean removeAll(IntegerList list) {
    boolean isChanged = false;
    for (int i = 0; i < list.size(); i++) {
      if (remove(list.get(i))) {
        isChanged = true;
      }
    }
    return isChanged;
  }

    @Override
    public int get(int index) {
        return super.get(index); 
    }

    @Override
    public int size() {
        return super.size();
    }


    public int getTotalAdded() {
        return totalAdded;
    }
}
