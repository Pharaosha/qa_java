import com.example.CatFamily;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    CatFamily catFamily;

    @Test
    public void getKittensDelegatesToCatFamilyMale() throws Exception {
        Lion lion = new Lion("Самец", catFamily);
        lion.getKittens();

        Mockito.verify(catFamily, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensDelegatesToCatFamilyFemale() throws Exception {
        Lion lion = new Lion("Самка", catFamily);
        lion.getKittens();

        Mockito.verify(catFamily, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensDelegatesToCatFamilyNonBinary() {
        assertThrows(Exception.class, () -> new Lion("", catFamily));

    }

    @Test
    void constructorSetsHasManeForMale() throws Exception {
        Lion lion = new Lion("Самец", catFamily);
        boolean expected = "Самец".equals("Самец");
        assertTrue(lion.doesHaveMane());

    }

    @Test
    public void getFoodDelegatesToCatFamily() throws Exception {
        Lion lion = new Lion("Самец", catFamily);
        lion.getFood();

        Mockito.verify(catFamily, Mockito.times(1)).getFood();
    }



}


