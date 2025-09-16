import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensDelegatesToFelineMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensDelegatesToFelineFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensDelegatesToFelineNonBinary() {
        assertThrows(Exception.class, () -> new Lion("", feline));

    }

    @Test
    void constructorSetsHasManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        assertEquals(expected, lion.doesHaveMane());

    }

    @Test
    void constructorSetsHasManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void getFoodDelegatesToFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();

        Mockito.verify(feline, Mockito.times(1)).getFood();
    }



}


