package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */


 public class DelegationSortedIntList implements IntegerList {
     private final SortedIntList list = new SortedIntList();
     private int totalAdded = 0;
 
     @Override
     public boolean add(int value) {
         totalAdded++;
         return list.add(value);
     }
 
     @Override
     public boolean addAll(IntegerList values) {
         totalAdded += values.size();
         // IntegerList дахь addAll методыг тодорхойлох
         if (values instanceof DelegationSortedIntList delegationSortedIntList) {
             return list.addAll(delegationSortedIntList.getList());
         }
         // Мөн бусад IntegerList хэсэгт хэрэгжүүлж болно
         return false;
     }
 
     @Override
     public boolean remove(int value) {
         return list.remove(value);
     }
 
     @Override
     public boolean removeAll(IntegerList values) {
         if (values instanceof DelegationSortedIntList delegationSortedIntList) {
             return list.removeAll(delegationSortedIntList.getList());
         }
         return false;
     }
 
     @Override
     public int get(int index) {
         return list.get(index);
     }
 
     @Override
     public int size() {
         return list.size();
     }
 
     public int getTotalAdded() {
         return totalAdded;
     }
 
     public SortedIntList getList() {
         return list;
     }
 }