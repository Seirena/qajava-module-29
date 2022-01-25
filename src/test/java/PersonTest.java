import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    @DataProvider(name = "ageDataProvider")
    Object[][] ageDataProvider(){
        return new Object[][]{
                {-1, false},
                {0, false},
                {1, false},
                {7, false},
                {12, false},
                {13, true},
                {14, true},
                {16, true},
                {18, true},
                {19, true},
                {20, false},
                {69, false}
        };
    }

    @Test(dataProvider = "ageDataProvider")
    public void AgeTest(int age, boolean isTeen) {
        boolean result = Person.isTeenager(age);
        assertEquals(result, isTeen, "Teenager acceptance is failed. Caused by entry data: " + age );
    }
}