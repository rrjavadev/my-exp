package quickunion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptimisedQuickUnionTest {
    @Test
    public void quickUnionShouldReturnAnArrayOfIds() {

        //Given
        int[] id = new int[]{0, 1, 2, 3};

        //When
        OptimisedQuickUnion qu = new OptimisedQuickUnion(4);

        //Then
        assertThat(qu.getIds()).isEqualTo(id);
    }

    @Test
    public void shouldReturnFalseWhenTwoNodesAreNotConnected() {

        //Given
        OptimisedQuickUnion quickUnion = new OptimisedQuickUnion(4);

        //When
        boolean areConnected = quickUnion.connected(1, 2);

        //Then
        assertThat(areConnected).isFalse();
    }

    @Test
    public void connectedShouldReturnTrueWhenUnionOfTwoNodesAreApplied() {

        //Given
        OptimisedQuickUnion quickUnion = new OptimisedQuickUnion(9);

        //When
        quickUnion.union(6, 1);
        quickUnion.union(7, 8);

        //Then
        assertThat(quickUnion.connected(6, 1)).isTrue();
        assertThat(quickUnion.connected(7, 8)).isTrue();
        assertThat(quickUnion.connected(4, 8)).isFalse();//4 and 8 are unconnected
    }
}