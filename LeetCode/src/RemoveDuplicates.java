public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    /* bookmark 만들어서 풀려다가 실패.. 답 확인해보니 이중 next 써서 해결..*/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

