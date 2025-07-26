package top8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListUsingDummyTest {

    @Test
    void shouldRemoveElementsFromALinkedList() {
        //Given
        LinkedListUsingDummy.Node head = new LinkedListUsingDummy.Node(1);
        head.next = new LinkedListUsingDummy.Node(6);
        head.next.next = new LinkedListUsingDummy.Node(2);
        head.next.next.next = new LinkedListUsingDummy.Node(3);

        //Expected
        LinkedListUsingDummy.Node head2 = new LinkedListUsingDummy.Node(1);
        head2.next = new LinkedListUsingDummy.Node(6);
        head2.next.next= new LinkedListUsingDummy.Node(3);

        //When
        LinkedListUsingDummy.Node result = LinkedListUsingDummy.removeElements(head, 2);

        //Then
        assertThat(result.val).isEqualTo( 1);
        assertThat(result.next.val).isEqualTo( 6);
        assertThat(result.next.next.val).isEqualTo( 3);

    }
}