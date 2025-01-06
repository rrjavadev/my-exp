package quickfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickFindTest {

    @Test
    public void quickFindShouldReturnAnArrayOfIds(){

        //Given
        int[] id = new int[]{0, 1, 2, 3};

        //When
        QuickFind qf = new QuickFind(4);

        //Then
        assertThat(qf.getIds()).isEqualTo(id);
    }

    @Test
    public void shouldReturnFalseWhenIdsAreNotConnected(){

        //Given
        int[] id = new int[]{0, 1, 2, 3};
        QuickFind quickFind = new QuickFind(4);

        //When
        boolean areConnected = quickFind.connected(1,2);

        //Then
        assertThat(areConnected).isFalse();
    }

}
