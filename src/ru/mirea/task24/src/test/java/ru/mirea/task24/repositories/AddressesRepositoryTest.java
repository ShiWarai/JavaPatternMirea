package ru.mirea.task24.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.mirea.task24.tables.Address;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AddressesRepositoryTest {

    @Autowired
    private AddressRepository  underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void positiveAddressesTest() {
        Address addresses1 = new Address();
        addresses1.setText("Moscow, street Studencheskaya");
        addresses1.setZip("1406800");
        underTest.save(addresses1);

        Address addresses2 = new Address();
        addresses2.setText("Moscow, street Kievskaya");
        addresses2.setZip("1403100");
        underTest.save(addresses2);

        List<Address> expectedOne = underTest.findAllByText("Moscow, street Studencheskaya");
        List<Address> expectedTwo = underTest.findAllByText("Moscow, street Kievskaya");

        assertThat(expectedOne).isNotNull();
        assertThat(expectedOne.size()).isEqualTo(1);
        assertThat(expectedOne.get(0).getText()).isEqualTo("Moscow, street Studencheskaya");
        assertThat(expectedOne.get(0).getZip()).isEqualTo("1406800");

        assertThat(expectedTwo).isNotNull();
        assertThat(expectedTwo.size()).isEqualTo(1);
        assertThat(expectedTwo.get(0).getText()).isEqualTo("Moscow, street Kievskaya");
        assertThat(expectedTwo.get(0).getZip()).isEqualTo("1403100");
    }

    @Test
    void negativeAddressesTest() {
        Address addresses1 = new Address();
        addresses1.setText("Yegoryevsk");
        addresses1.setZip("140304");
        underTest.save(addresses1);

        List<Address> expectedThree = underTest.findAllByZip("140300");

        assertThat(expectedThree).isNotNull();
        assertThat(expectedThree.size()).isEqualTo(0);
    }
}