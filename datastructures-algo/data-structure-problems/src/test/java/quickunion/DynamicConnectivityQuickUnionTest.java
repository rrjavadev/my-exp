package quickunion;

import org.junit.jupiter.api.Test;
import quickfind.DynamicConnectivityQuickFind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DynamicConnectivityQuickUnionTest {
    @Test
    public void quickUnionShouldReturnAnArrayOfIds() {

        //Given
        int[] id = new int[]{0, 1, 2, 3};

        //When
        DynamicConnectivityQuickUnion qu = new DynamicConnectivityQuickUnion(4);

        //Then
        assertThat(qu.getIds()).isEqualTo(id);
    }
}