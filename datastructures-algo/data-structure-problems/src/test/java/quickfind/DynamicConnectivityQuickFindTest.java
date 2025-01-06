package quickfind;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicConnectivityQuickFindTest {

    @Test
    public void quickFindShouldReturnAnArrayOfIds() {

        //Given
        int[] id = new int[]{0, 1, 2, 3};

        //When
        DynamicConnectivityQuickFind qf = new DynamicConnectivityQuickFind(4);

        //Then
        assertThat(qf.getIds()).isEqualTo(id);
    }

    @Test
    public void shouldReturnFalseWhenIdsAreNotConnected() {

        //Given
        int[] id = new int[]{0, 1, 2, 3};
        DynamicConnectivityQuickFind quickFind = new DynamicConnectivityQuickFind(4);

        //When
        boolean areConnected = quickFind.connected(1, 2);

        //Then
        assertThat(areConnected).isFalse();
    }

    @Test
    public void shouldReturnConcatenatedIdsWhenUnionOfIndexesIsCalled() {

        //Given
        DynamicConnectivityQuickFind quickFind = new DynamicConnectivityQuickFind(5);

        //When
        int[] concatenatedIds = quickFind.union(2, 4);

        //Then
        assertThat(concatenatedIds).isEqualTo(new int[]{0, 1, 4, 3, 4});
    }

    @Test
    public void connectedShouldReturnTrueWhenIdsAreConnected() {
        //Given
        DynamicConnectivityQuickFind quickFind = new DynamicConnectivityQuickFind(5);
        quickFind.union(2, 4);

        //When/Then
        assertThat(quickFind.connected(2, 4)).isTrue();
    }
}
