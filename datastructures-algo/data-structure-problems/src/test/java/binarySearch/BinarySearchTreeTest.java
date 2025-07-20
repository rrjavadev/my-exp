package binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void shouldGetValueFromBST() {

        //Given
        Node root = new Node(2, 2);
        root.left = new Node(1, 1);
        root.right = new Node(3, 3);
        root.left.left = new Node(0, 0);

        BinarySearchTree bst = new BinarySearchTree(root);

        //When
        Node value = bst.get(0);

        //Then
        org.assertj.core.api.Assertions.assertThat(value.value).isEqualTo(0);
    }
}